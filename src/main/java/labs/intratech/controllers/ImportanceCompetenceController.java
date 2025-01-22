package labs.intratech.controllers;

import org.springframework.ui.Model;
import labs.intratech.models.*;
import labs.intratech.services.*;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/importancecompetences")
public class ImportanceCompetenceController  {
	private final ImportanceCompetenceService importancecompetenceService;
	private final PostesService postesService;
	private final CompetencesService competencesService;
	

	public ImportanceCompetenceController(PostesService postesService,CompetencesService competencesService, ImportanceCompetenceService importancecompetenceService) {
	    this.importancecompetenceService = importancecompetenceService;
	    this.postesService = postesService;
	    this.competencesService = competencesService;
	    
	}

	@GetMapping
	public String getAllImportanceCompetences(Model model) {
	    List<ImportanceCompetence> importancecompetences = importancecompetenceService.getAllImportanceCompetence();
	    List<Postes> postess = postesService.getAllPostes();
	    List<Competences> competencess = competencesService.getAllCompetences();
	    
	    model.addAttribute("importancecompetences", importancecompetences);
	    model.addAttribute("postess", postess);
	    model.addAttribute("competencess", competencess);
	    
	    return "importancecompetences/list-importancecompetence";
	}

	@GetMapping("/create-importancecompetence")
	public String returnImportanceCompetences(Model model) {
	    List<Postes> postess = postesService.getAllPostes();
	    List<Competences> competencess = competencesService.getAllCompetences();
	    
	    model.addAttribute("postess", postess);
	    model.addAttribute("competencess", competencess);
	    
	    return "importancecompetences/create-importancecompetence";
	}

	@PostMapping
	public String createImportanceCompetence(@ModelAttribute ImportanceCompetence importancecompetence, RedirectAttributes redirectAttributes, Model model) {
	    try {
		    ImportanceCompetence newImportanceCompetence = importancecompetenceService.createImportanceCompetence(importancecompetence);
		    model.addAttribute("newImportanceCompetence", newImportanceCompetence);

		    redirectAttributes.addFlashAttribute("success", "importancecompetence successfully completed");
	    } catch (Exception e) {
		    redirectAttributes.addFlashAttribute(
		     "error",
		     "An error has occurred during the creation of importancecompetence");
	    }

	    return "redirect:/importancecompetences";
	}

	@PostMapping("/{id}")
	public String updateImportanceCompetence(@PathVariable Long id, @ModelAttribute ImportanceCompetence importancecompetence, RedirectAttributes redirectAttributes, Model model) {
	    try {
		    ImportanceCompetence updateImportanceCompetence = importancecompetenceService.updateImportanceCompetence(id, importancecompetence);
		    model.addAttribute("updateImportanceCompetence", updateImportanceCompetence);

		    redirectAttributes.addFlashAttribute("success", "importancecompetence modify with success");
	    } catch (Exception e) {
		    redirectAttributes.addFlashAttribute(
		     "error",
		     "An error has occurred during the update of importancecompetence");
	    }

	    return "redirect:/importancecompetences";
	}

	@PostMapping("/{id}/delete")
	public String deleteImportanceCompetenceById(@PathVariable Long id, RedirectAttributes redirectAttributes, Model model) {
	    try {
		     importancecompetenceService.deleteImportanceCompetence(id);

		    redirectAttributes.addFlashAttribute("success", "importancecompetence has been deleted ");
	    } catch (Exception e) {
		    redirectAttributes.addFlashAttribute(
		     "error",
		     "An error has occurred during the delete of importancecompetence");
	    }

	    return "redirect:/importancecompetences";
	}

}



