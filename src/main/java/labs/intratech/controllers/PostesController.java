package labs.intratech.controllers;

import org.springframework.ui.Model;
import labs.intratech.models.*;
import labs.intratech.services.*;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/postess")
public class PostesController  {
	private final PostesService postesService;
	

	public PostesController( PostesService postesService) {
	    this.postesService = postesService;
	    
	}

	@GetMapping
	public String getAllPostess(Model model) {
	    List<Postes> postess = postesService.getAllPostes();
	    
	    model.addAttribute("postess", postess);
	    
	    return "postess/list-postes";
	}

	@GetMapping("/create-postes")
	public String returnPostess(Model model) {
	    
	    
	    return "postess/create-postes";
	}

	@PostMapping
	public String createPostes(@ModelAttribute Postes postes, RedirectAttributes redirectAttributes, Model model) {
	    try {
		    Postes newPostes = postesService.createPostes(postes);
		    model.addAttribute("newPostes", newPostes);

		    redirectAttributes.addFlashAttribute("success", "postes successfully completed");
	    } catch (Exception e) {
		    redirectAttributes.addFlashAttribute(
		     "error",
		     "An error has occurred during the creation of postes");
	    }

	    return "redirect:/postess";
	}

	@PostMapping("/{id}")
	public String updatePostes(@PathVariable Long id, @ModelAttribute Postes postes, RedirectAttributes redirectAttributes, Model model) {
	    try {
		    Postes updatePostes = postesService.updatePostes(id, postes);
		    model.addAttribute("updatePostes", updatePostes);

		    redirectAttributes.addFlashAttribute("success", "postes modify with success");
	    } catch (Exception e) {
		    redirectAttributes.addFlashAttribute(
		     "error",
		     "An error has occurred during the update of postes");
	    }

	    return "redirect:/postess";
	}

	@PostMapping("/{id}/delete")
	public String deletePostesById(@PathVariable Long id, RedirectAttributes redirectAttributes, Model model) {
	    try {
		     postesService.deletePostes(id);

		    redirectAttributes.addFlashAttribute("success", "postes has been deleted ");
	    } catch (Exception e) {
		    redirectAttributes.addFlashAttribute(
		     "error",
		     "An error has occurred during the delete of postes");
	    }

	    return "redirect:/postess";
	}

}



