package labs.intratech.controllers;

import org.springframework.ui.Model;
import labs.intratech.models.*;
import labs.intratech.services.*;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/importanceeducations")
public class ImportanceEducationController  {
	private final ImportanceEducationService importanceeducationService;
	private final PostesService postesService;
	private final EducationService educationService;
	

	public ImportanceEducationController(PostesService postesService,EducationService educationService, ImportanceEducationService importanceeducationService) {
	    this.importanceeducationService = importanceeducationService;
	    this.postesService = postesService;
	    this.educationService = educationService;
	    
	}

	@GetMapping
	public String getAllImportanceEducations(Model model) {
	    List<ImportanceEducation> importanceeducations = importanceeducationService.getAllImportanceEducation();
	    List<Postes> postess = postesService.getAllPostes();
	    List<Education> educations = educationService.getAllEducation();
	    
	    model.addAttribute("importanceeducations", importanceeducations);
	    model.addAttribute("postess", postess);
	    model.addAttribute("educations", educations);
	    
	    return "importanceeducations/list-importanceeducation";
	}

	@GetMapping("/create-importanceeducation")
	public String returnImportanceEducations(Model model) {
	    List<Postes> postess = postesService.getAllPostes();
	    List<Education> educations = educationService.getAllEducation();
	    
	    model.addAttribute("postess", postess);
	    model.addAttribute("educations", educations);
	    
	    return "importanceeducations/create-importanceeducation";
	}

	@PostMapping
	public String createImportanceEducation(@ModelAttribute ImportanceEducation importanceeducation, RedirectAttributes redirectAttributes, Model model) {
	    try {
		    ImportanceEducation newImportanceEducation = importanceeducationService.createImportanceEducation(importanceeducation);
		    model.addAttribute("newImportanceEducation", newImportanceEducation);

		    redirectAttributes.addFlashAttribute("success", "importanceeducation successfully completed");
	    } catch (Exception e) {
		    redirectAttributes.addFlashAttribute(
		     "error",
		     "An error has occurred during the creation of importanceeducation");
	    }

	    return "redirect:/importanceeducations";
	}

	@PostMapping("/{id}")
	public String updateImportanceEducation(@PathVariable Long id, @ModelAttribute ImportanceEducation importanceeducation, RedirectAttributes redirectAttributes, Model model) {
	    try {
		    ImportanceEducation updateImportanceEducation = importanceeducationService.updateImportanceEducation(id, importanceeducation);
		    model.addAttribute("updateImportanceEducation", updateImportanceEducation);

		    redirectAttributes.addFlashAttribute("success", "importanceeducation modify with success");
	    } catch (Exception e) {
		    redirectAttributes.addFlashAttribute(
		     "error",
		     "An error has occurred during the update of importanceeducation");
	    }

	    return "redirect:/importanceeducations";
	}

	@PostMapping("/{id}/delete")
	public String deleteImportanceEducationById(@PathVariable Long id, RedirectAttributes redirectAttributes, Model model) {
	    try {
		     importanceeducationService.deleteImportanceEducation(id);

		    redirectAttributes.addFlashAttribute("success", "importanceeducation has been deleted ");
	    } catch (Exception e) {
		    redirectAttributes.addFlashAttribute(
		     "error",
		     "An error has occurred during the delete of importanceeducation");
	    }

	    return "redirect:/importanceeducations";
	}

}



