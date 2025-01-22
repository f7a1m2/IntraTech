package labs.intratech.controllers;

import org.springframework.ui.Model;
import labs.intratech.models.*;
import labs.intratech.services.*;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/importanceexperiences")
public class ImportanceExperienceController  {
	private final ImportanceExperienceService importanceexperienceService;
	private final PostesService postesService;
	private final ExperiencesService experiencesService;
	

	public ImportanceExperienceController(PostesService postesService,ExperiencesService experiencesService, ImportanceExperienceService importanceexperienceService) {
	    this.importanceexperienceService = importanceexperienceService;
	    this.postesService = postesService;
	    this.experiencesService = experiencesService;
	    
	}

	@GetMapping
	public String getAllImportanceExperiences(Model model) {
	    List<ImportanceExperience> importanceexperiences = importanceexperienceService.getAllImportanceExperience();
	    List<Postes> postess = postesService.getAllPostes();
	    List<Experiences> experiencess = experiencesService.getAllExperiences();
	    
	    model.addAttribute("importanceexperiences", importanceexperiences);
	    model.addAttribute("postess", postess);
	    model.addAttribute("experiencess", experiencess);
	    
	    return "importanceexperiences/list-importanceexperience";
	}

	@GetMapping("/create-importanceexperience")
	public String returnImportanceExperiences(Model model) {
	    List<Postes> postess = postesService.getAllPostes();
	    List<Experiences> experiencess = experiencesService.getAllExperiences();
	    
	    model.addAttribute("postess", postess);
	    model.addAttribute("experiencess", experiencess);
	    
	    return "importanceexperiences/create-importanceexperience";
	}

	@PostMapping
	public String createImportanceExperience(@ModelAttribute ImportanceExperience importanceexperience, RedirectAttributes redirectAttributes, Model model) {
	    try {
		    ImportanceExperience newImportanceExperience = importanceexperienceService.createImportanceExperience(importanceexperience);
		    model.addAttribute("newImportanceExperience", newImportanceExperience);

		    redirectAttributes.addFlashAttribute("success", "importanceexperience successfully completed");
	    } catch (Exception e) {
		    redirectAttributes.addFlashAttribute(
		     "error",
		     "An error has occurred during the creation of importanceexperience");
	    }

	    return "redirect:/importanceexperiences";
	}

	@PostMapping("/{id}")
	public String updateImportanceExperience(@PathVariable Long id, @ModelAttribute ImportanceExperience importanceexperience, RedirectAttributes redirectAttributes, Model model) {
	    try {
		    ImportanceExperience updateImportanceExperience = importanceexperienceService.updateImportanceExperience(id, importanceexperience);
		    model.addAttribute("updateImportanceExperience", updateImportanceExperience);

		    redirectAttributes.addFlashAttribute("success", "importanceexperience modify with success");
	    } catch (Exception e) {
		    redirectAttributes.addFlashAttribute(
		     "error",
		     "An error has occurred during the update of importanceexperience");
	    }

	    return "redirect:/importanceexperiences";
	}

	@PostMapping("/{id}/delete")
	public String deleteImportanceExperienceById(@PathVariable Long id, RedirectAttributes redirectAttributes, Model model) {
	    try {
		     importanceexperienceService.deleteImportanceExperience(id);

		    redirectAttributes.addFlashAttribute("success", "importanceexperience has been deleted ");
	    } catch (Exception e) {
		    redirectAttributes.addFlashAttribute(
		     "error",
		     "An error has occurred during the delete of importanceexperience");
	    }

	    return "redirect:/importanceexperiences";
	}

}



