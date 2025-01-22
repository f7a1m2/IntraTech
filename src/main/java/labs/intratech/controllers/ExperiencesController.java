package labs.intratech.controllers;

import org.springframework.ui.Model;
import labs.intratech.models.*;
import labs.intratech.services.*;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/experiencess")
public class ExperiencesController  {
	private final ExperiencesService experiencesService;
	

	public ExperiencesController( ExperiencesService experiencesService) {
	    this.experiencesService = experiencesService;
	    
	}

	@GetMapping
	public String getAllExperiencess(Model model) {
	    List<Experiences> experiencess = experiencesService.getAllExperiences();
	    
	    model.addAttribute("experiencess", experiencess);
	    
	    return "experiencess/list-experiences";
	}

	@GetMapping("/create-experiences")
	public String returnExperiencess(Model model) {
	    
	    
	    return "experiencess/create-experiences";
	}

	@PostMapping
	public String createExperiences(@ModelAttribute Experiences experiences, RedirectAttributes redirectAttributes, Model model) {
	    try {
		    Experiences newExperiences = experiencesService.createExperiences(experiences);
		    model.addAttribute("newExperiences", newExperiences);

		    redirectAttributes.addFlashAttribute("success", "experiences successfully completed");
	    } catch (Exception e) {
		    redirectAttributes.addFlashAttribute(
		     "error",
		     "An error has occurred during the creation of experiences");
	    }

	    return "redirect:/experiencess";
	}

	@PostMapping("/{id}")
	public String updateExperiences(@PathVariable Long id, @ModelAttribute Experiences experiences, RedirectAttributes redirectAttributes, Model model) {
	    try {
		    Experiences updateExperiences = experiencesService.updateExperiences(id, experiences);
		    model.addAttribute("updateExperiences", updateExperiences);

		    redirectAttributes.addFlashAttribute("success", "experiences modify with success");
	    } catch (Exception e) {
		    redirectAttributes.addFlashAttribute(
		     "error",
		     "An error has occurred during the update of experiences");
	    }

	    return "redirect:/experiencess";
	}

	@PostMapping("/{id}/delete")
	public String deleteExperiencesById(@PathVariable Long id, RedirectAttributes redirectAttributes, Model model) {
	    try {
		     experiencesService.deleteExperiences(id);

		    redirectAttributes.addFlashAttribute("success", "experiences has been deleted ");
	    } catch (Exception e) {
		    redirectAttributes.addFlashAttribute(
		     "error",
		     "An error has occurred during the delete of experiences");
	    }

	    return "redirect:/experiencess";
	}

}



