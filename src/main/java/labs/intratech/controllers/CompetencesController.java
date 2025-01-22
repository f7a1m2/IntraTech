package labs.intratech.controllers;

import org.springframework.ui.Model;
import labs.intratech.models.*;
import labs.intratech.repositories.UsersRepository;
import labs.intratech.services.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/competencess")
public class CompetencesController  {
	private final CompetencesService competencesService;

	@Autowired
	public UsersRepository usersRepository;
	

	public CompetencesController( CompetencesService competencesService) {
	    this.competencesService = competencesService;
	    
	}

	@GetMapping
	public String getAllCompetencess(Model model) {
	    List<Competences> competencess = competencesService.getAllCompetences();
	    
	    model.addAttribute("competencess", competencess);

	    
	    return "competencess/list-competences";
	}

	@GetMapping("/create-competences")
	public String returnCompetencess(Model model) {
	    
	    
	    return "competencess/create-competences";
	}

	@PostMapping
	public String createCompetences(@ModelAttribute Competences competences, RedirectAttributes redirectAttributes, Model model) {
	    try {
		    Competences newCompetences = competencesService.createCompetences(competences);
		    model.addAttribute("newCompetences", newCompetences);

		    redirectAttributes.addFlashAttribute("success", "competences successfully completed");
	    } catch (Exception e) {
		    redirectAttributes.addFlashAttribute(
		     "error",
		     "An error has occurred during the creation of competences");
	    }

	    return "redirect:/competencess";
	}

	@PostMapping("/{id}")
	public String updateCompetences(@PathVariable Long id, @ModelAttribute Competences competences, RedirectAttributes redirectAttributes, Model model) {
	    try {
		    Competences updateCompetences = competencesService.updateCompetences(id, competences);
		    model.addAttribute("updateCompetences", updateCompetences);

		    redirectAttributes.addFlashAttribute("success", "competences modify with success");
	    } catch (Exception e) {
		    redirectAttributes.addFlashAttribute(
		     "error",
		     "An error has occurred during the update of competences");
	    }

	    return "redirect:/competencess";
	}

	@PostMapping("/{id}/delete")
	public String deleteCompetencesById(@PathVariable Long id, RedirectAttributes redirectAttributes, Model model) {
	    try {
		     competencesService.deleteCompetences(id);

		    redirectAttributes.addFlashAttribute("success", "competences has been deleted ");
	    } catch (Exception e) {
		    redirectAttributes.addFlashAttribute(
		     "error",
		     "An error has occurred during the delete of competences");
	    }

	    return "redirect:/competencess";
	}

}



