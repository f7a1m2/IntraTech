package labs.intratech.controllers;

import org.springframework.ui.Model;
import labs.intratech.models.*;
import labs.intratech.services.*;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/candidatss")
public class CandidatsController  {
	private final CandidatsService candidatsService;
	private final UsersService usersService;
	

	public CandidatsController(UsersService usersService, CandidatsService candidatsService) {
	    this.candidatsService = candidatsService;
	    this.usersService = usersService;
	    
	}

	@GetMapping
	public String getAllCandidatss(Model model) {
	    List<Candidats> candidatss = candidatsService.getAllCandidats();
	    List<Users> userss = usersService.getAllUsers();
	    
	    model.addAttribute("candidatss", candidatss);
	    model.addAttribute("userss", userss);
	    
	    return "candidatss/list-candidats";
	}

	@GetMapping("/create-candidats")
	public String returnCandidatss(Model model) {
	    List<Users> userss = usersService.getAllUsers();
	    
	    model.addAttribute("userss", userss);
	    
	    return "candidatss/create-candidats";
	}

	@PostMapping
	public String createCandidats(@ModelAttribute Candidats candidats, RedirectAttributes redirectAttributes, Model model) {
	    try {
		    Candidats newCandidats = candidatsService.createCandidats(candidats);
		    model.addAttribute("newCandidats", newCandidats);

		    redirectAttributes.addFlashAttribute("success", "candidats successfully completed");
	    } catch (Exception e) {
		    redirectAttributes.addFlashAttribute(
		     "error",
		     "An error has occurred during the creation of candidats");
	    }

	    return "redirect:/candidatss";
	}

	@PostMapping("/{id}")
	public String updateCandidats(@PathVariable Long id, @ModelAttribute Candidats candidats, RedirectAttributes redirectAttributes, Model model) {
	    try {
		    Candidats updateCandidats = candidatsService.updateCandidats(id, candidats);
		    model.addAttribute("updateCandidats", updateCandidats);

		    redirectAttributes.addFlashAttribute("success", "candidats modify with success");
	    } catch (Exception e) {
		    redirectAttributes.addFlashAttribute(
		     "error",
		     "An error has occurred during the update of candidats");
	    }

	    return "redirect:/candidatss";
	}

	@PostMapping("/{id}/delete")
	public String deleteCandidatsById(@PathVariable Long id, RedirectAttributes redirectAttributes, Model model) {
	    try {
		     candidatsService.deleteCandidats(id);

		    redirectAttributes.addFlashAttribute("success", "candidats has been deleted ");
	    } catch (Exception e) {
		    redirectAttributes.addFlashAttribute(
		     "error",
		     "An error has occurred during the delete of candidats");
	    }

	    return "redirect:/candidatss";
	}

}



