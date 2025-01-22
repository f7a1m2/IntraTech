package labs.intratech.controllers;

import org.springframework.ui.Model;
import labs.intratech.models.*;
import labs.intratech.services.*;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/educations")
public class EducationController  {
	private final EducationService educationService;
	

	public EducationController( EducationService educationService) {
	    this.educationService = educationService;
	    
	}

	@GetMapping
	public String getAllEducations(Model model) {
	    List<Education> educations = educationService.getAllEducation();
	    
	    model.addAttribute("educations", educations);
	    
	    return "educations/list-education";
	}

	@GetMapping("/create-education")
	public String returnEducations(Model model) {
	    
	    
	    return "educations/create-education";
	}

	@PostMapping
	public String createEducation(@ModelAttribute Education education, RedirectAttributes redirectAttributes, Model model) {
	    try {
		    Education newEducation = educationService.createEducation(education);
		    model.addAttribute("newEducation", newEducation);

		    redirectAttributes.addFlashAttribute("success", "education successfully completed");
	    } catch (Exception e) {
		    redirectAttributes.addFlashAttribute(
		     "error",
		     "An error has occurred during the creation of education");
	    }

	    return "redirect:/educations";
	}

	@PostMapping("/{id}")
	public String updateEducation(@PathVariable Long id, @ModelAttribute Education education, RedirectAttributes redirectAttributes, Model model) {
	    try {
		    Education updateEducation = educationService.updateEducation(id, education);
		    model.addAttribute("updateEducation", updateEducation);

		    redirectAttributes.addFlashAttribute("success", "education modify with success");
	    } catch (Exception e) {
		    redirectAttributes.addFlashAttribute(
		     "error",
		     "An error has occurred during the update of education");
	    }

	    return "redirect:/educations";
	}

	@PostMapping("/{id}/delete")
	public String deleteEducationById(@PathVariable Long id, RedirectAttributes redirectAttributes, Model model) {
	    try {
		     educationService.deleteEducation(id);

		    redirectAttributes.addFlashAttribute("success", "education has been deleted ");
	    } catch (Exception e) {
		    redirectAttributes.addFlashAttribute(
		     "error",
		     "An error has occurred during the delete of education");
	    }

	    return "redirect:/educations";
	}

}



