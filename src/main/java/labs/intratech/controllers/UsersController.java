package labs.intratech.controllers;

import org.springframework.ui.Model;
import labs.intratech.models.*;
import labs.intratech.repositories.UsersRepository;
import labs.intratech.services.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.security.core.Authentication;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.web.bind.annotation.*;
import static org.springframework.security.web.context.HttpSessionSecurityContextRepository.SPRING_SECURITY_CONTEXT_KEY;

import java.util.List;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
@RequestMapping("/userss")
public class UsersController  {
	private final UsersService usersService;

	@Autowired 
	private UsersRepository usersRepository;

	@Autowired
	PasswordEncoder passwordEncoder;

	@Autowired
	private AuthenticationManager authenticationManager;
	

	public UsersController( UsersService usersService) {
	    this.usersService = usersService;
	    
	}

	@GetMapping
	public String getAllUserss(Model model) {
	    List<Users> userss = usersService.getAllUsers();
	    
	    model.addAttribute("userss", userss);
	    
	    return "userss/list-users";
	}

	@GetMapping("/create-users")
	public String returnUserss(Model model) {
	    
	    
	    return "userss/create-users";
	}

	@PostMapping
	public String createUsers(@ModelAttribute Users users, RedirectAttributes redirectAttributes, Model model) {
	    try {
		    Users newUsers = usersService.createUsers(users);
		    model.addAttribute("newUsers", newUsers);

		    redirectAttributes.addFlashAttribute("success", "users successfully completed");
	    } catch (Exception e) {
		    redirectAttributes.addFlashAttribute(
		     "error",
		     "An error has occurred during the creation of users");
	    }

	    return "redirect:/userss";
	}

	@PostMapping("/{id}")
	public String updateUsers(@PathVariable Long id, @ModelAttribute Users users, RedirectAttributes redirectAttributes, Model model) {
	    try {
		    Users updateUsers = usersService.updateUsers(id, users);
		    model.addAttribute("updateUsers", updateUsers);

		    redirectAttributes.addFlashAttribute("success", "users modify with success");
	    } catch (Exception e) {
		    redirectAttributes.addFlashAttribute(
		     "error",
		     "An error has occurred during the update of users");
	    }

	    return "redirect:/userss";
	}

	@PostMapping("/{id}/delete")
	public String deleteUsersById(@PathVariable Long id, RedirectAttributes redirectAttributes, Model model) {
	    try {
		     usersService.deleteUsers(id);

		    redirectAttributes.addFlashAttribute("success", "users has been deleted ");
	    } catch (Exception e) {
		    redirectAttributes.addFlashAttribute(
		     "error",
		     "An error has occurred during the delete of users");
	    }

	    return "redirect:/userss";
	}

	@GetMapping("/error/403")
	public String error403(){
		return "error/error-403";
	}

	@GetMapping("/login")
	public String loginPage(Model model) {
		Users utilisateur = new Users();
		utilisateur.setEmail("finance@gmail.com");
		utilisateur.setPass("finance");

		System.out.println("hello from");

		model.addAttribute("utilisateur", utilisateur);
		return "Auth/login";
	}
	

	@PostMapping("/loginA")
	public String login(Users utilisateur, RedirectAttributes redirectAttributes, HttpSession session, HttpServletRequest request){

	
		Users user  = usersRepository.findUsersByEmail(utilisateur.getEmail());
		if(user==null || !passwordEncoder.matches(utilisateur.getPass(),user.getPass())){
			redirectAttributes.addFlashAttribute("error" , "Mot de passe ou email non valide");
			return "redirect:/users/login";
		}
		
		UsernamePasswordAuthenticationToken authRequest = new UsernamePasswordAuthenticationToken(utilisateur.getEmail(), utilisateur.getPass());

		Authentication authentication = authenticationManager.authenticate(authRequest);
		SecurityContext sc = SecurityContextHolder.getContext();
		sc.setAuthentication(authentication);


		HttpSession s = request.getSession(true);
		session.setAttribute(SPRING_SECURITY_CONTEXT_KEY, sc);

		session.setAttribute("user" , user);


		return "redirect:/";
	}

}



