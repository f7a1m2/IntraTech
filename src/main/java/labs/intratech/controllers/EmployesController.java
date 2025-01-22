package labs.intratech.controllers;

import org.springframework.ui.Model;
import labs.intratech.models.*;
import labs.intratech.services.*;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/employess")
public class EmployesController  {
	private final EmployesService employesService;
	private final CandidatsService candidatsService;
	private final PostesService postesService;
	private final UsersService usersService;
	

	public EmployesController(CandidatsService candidatsService,PostesService postesService,UsersService usersService, EmployesService employesService) {
	    this.employesService = employesService;
	    this.candidatsService = candidatsService;
	    this.postesService = postesService;
	    this.usersService = usersService;
	    
	}

	@GetMapping
	public String getAllEmployess(Model model) {
	    List<Employes> employess = employesService.getAllEmployes();
	    List<Candidats> candidatss = candidatsService.getAllCandidats();
	    List<Postes> postess = postesService.getAllPostes();
	    List<Users> userss = usersService.getAllUsers();
	    
	    model.addAttribute("employess", employess);
	    model.addAttribute("candidatss", candidatss);
	    model.addAttribute("postess", postess);
	    model.addAttribute("userss", userss);
	    
	    return "employess/list-employes";
	}

	@GetMapping("/create-employes")
	public String returnEmployess(Model model) {
	    List<Candidats> candidatss = candidatsService.getAllCandidats();
	    List<Postes> postess = postesService.getAllPostes();
	    List<Users> userss = usersService.getAllUsers();
	    
	    model.addAttribute("candidatss", candidatss);
	    model.addAttribute("postess", postess);
	    model.addAttribute("userss", userss);
	    
	    return "employess/create-employes";
	}

	@PostMapping
	public String createEmployes(@ModelAttribute Employes employes, RedirectAttributes redirectAttributes, Model model) {
	    try {
		    Employes newEmployes = employesService.createEmployes(employes);
		    model.addAttribute("newEmployes", newEmployes);

		    redirectAttributes.addFlashAttribute("success", "employes successfully completed");
	    } catch (Exception e) {
		    redirectAttributes.addFlashAttribute(
		     "error",
		     "An error has occurred during the creation of employes");
	    }

	    return "redirect:/employess";
	}

	@PostMapping("/{id}")
	public String updateEmployes(@PathVariable Long id, @ModelAttribute Employes employes, RedirectAttributes redirectAttributes, Model model) {
	    try {
		    Employes updateEmployes = employesService.updateEmployes(id, employes);
		    model.addAttribute("updateEmployes", updateEmployes);

		    redirectAttributes.addFlashAttribute("success", "employes modify with success");
	    } catch (Exception e) {
		    redirectAttributes.addFlashAttribute(
		     "error",
		     "An error has occurred during the update of employes");
	    }

	    return "redirect:/employess";
	}

	@PostMapping("/{id}/delete")
	public String deleteEmployesById(@PathVariable Long id, RedirectAttributes redirectAttributes, Model model) {
	    try {
		     employesService.deleteEmployes(id);

		    redirectAttributes.addFlashAttribute("success", "employes has been deleted ");
	    } catch (Exception e) {
		    redirectAttributes.addFlashAttribute(
		     "error",
		     "An error has occurred during the delete of employes");
	    }

	    return "redirect:/employess";
	}

}



