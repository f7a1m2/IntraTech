package labs.intratech.controllers;

import org.springframework.ui.Model;
import labs.intratech.models.*;
import labs.intratech.services.*;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/userss")
public class UsersController  {
	private final UsersService usersService;
	

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

}



