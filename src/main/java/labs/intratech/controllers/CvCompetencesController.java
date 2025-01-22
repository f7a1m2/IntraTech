package labs.intratech.controllers;

import org.springframework.ui.Model;
import labs.intratech.models.*;
import labs.intratech.services.*;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/cvcompetencess")
public class CvCompetencesController  {
	private final CvCompetencesService cvcompetencesService;
	private final CvService cvService;
	private final CompetencesService competencesService;
	

	public CvCompetencesController(CvService cvService,CompetencesService competencesService, CvCompetencesService cvcompetencesService) {
	    this.cvcompetencesService = cvcompetencesService;
	    this.cvService = cvService;
	    this.competencesService = competencesService;
	    
	}

	@GetMapping
	public String getAllCvCompetencess(Model model) {
	    List<CvCompetences> cvcompetencess = cvcompetencesService.getAllCvCompetences();
	    List<Cv> cvs = cvService.getAllCv();
	    List<Competences> competencess = competencesService.getAllCompetences();
	    
	    model.addAttribute("cvcompetencess", cvcompetencess);
	    model.addAttribute("cvs", cvs);
	    model.addAttribute("competencess", competencess);
	    
	    return "cvcompetencess/list-cvcompetences";
	}

	@GetMapping("/create-cvcompetences")
	public String returnCvCompetencess(Model model) {
	    List<Cv> cvs = cvService.getAllCv();
	    List<Competences> competencess = competencesService.getAllCompetences();
	    
	    model.addAttribute("cvs", cvs);
	    model.addAttribute("competencess", competencess);
	    
	    return "cvcompetencess/create-cvcompetences";
	}

	@PostMapping
	public String createCvCompetences(@ModelAttribute CvCompetences cvcompetences, RedirectAttributes redirectAttributes, Model model) {
	    try {
		    CvCompetences newCvCompetences = cvcompetencesService.createCvCompetences(cvcompetences);
		    model.addAttribute("newCvCompetences", newCvCompetences);

		    redirectAttributes.addFlashAttribute("success", "cvcompetences successfully completed");
	    } catch (Exception e) {
		    redirectAttributes.addFlashAttribute(
		     "error",
		     "An error has occurred during the creation of cvcompetences");
	    }

	    return "redirect:/cvcompetencess";
	}

	@PostMapping("/{id}")
	public String updateCvCompetences(@PathVariable Long id, @ModelAttribute CvCompetences cvcompetences, RedirectAttributes redirectAttributes, Model model) {
	    try {
		    CvCompetences updateCvCompetences = cvcompetencesService.updateCvCompetences(id, cvcompetences);
		    model.addAttribute("updateCvCompetences", updateCvCompetences);

		    redirectAttributes.addFlashAttribute("success", "cvcompetences modify with success");
	    } catch (Exception e) {
		    redirectAttributes.addFlashAttribute(
		     "error",
		     "An error has occurred during the update of cvcompetences");
	    }

	    return "redirect:/cvcompetencess";
	}

	@PostMapping("/{id}/delete")
	public String deleteCvCompetencesById(@PathVariable Long id, RedirectAttributes redirectAttributes, Model model) {
	    try {
		     cvcompetencesService.deleteCvCompetences(id);

		    redirectAttributes.addFlashAttribute("success", "cvcompetences has been deleted ");
	    } catch (Exception e) {
		    redirectAttributes.addFlashAttribute(
		     "error",
		     "An error has occurred during the delete of cvcompetences");
	    }

	    return "redirect:/cvcompetencess";
	}

}



