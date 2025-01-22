package labs.intratech.controllers;

import org.springframework.ui.Model;
import labs.intratech.models.*;
import labs.intratech.services.*;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/cvs")
public class CvController  {
	private final CvService cvService;
	private final CandidatsService candidatsService;
	

	public CvController(CandidatsService candidatsService, CvService cvService) {
	    this.cvService = cvService;
	    this.candidatsService = candidatsService;
	    
	}

	@GetMapping
	public String getAllCvs(Model model) {
	    List<Cv> cvs = cvService.getAllCv();
	    List<Candidats> candidatss = candidatsService.getAllCandidats();
	    
	    model.addAttribute("cvs", cvs);
	    model.addAttribute("candidatss", candidatss);
	    
	    return "cvs/list-cv";
	}

	@GetMapping("/create-cv")
	public String returnCvs(Model model) {
	    List<Candidats> candidatss = candidatsService.getAllCandidats();
	    
	    model.addAttribute("candidatss", candidatss);
	    
	    return "cvs/create-cv";
	}

	@PostMapping
	public String createCv(@ModelAttribute Cv cv, RedirectAttributes redirectAttributes, Model model) {
	    try {
		    Cv newCv = cvService.createCv(cv);
		    model.addAttribute("newCv", newCv);

		    redirectAttributes.addFlashAttribute("success", "cv successfully completed");
	    } catch (Exception e) {
		    redirectAttributes.addFlashAttribute(
		     "error",
		     "An error has occurred during the creation of cv");
	    }

	    return "redirect:/cvs";
	}

	@PostMapping("/{id}")
	public String updateCv(@PathVariable Long id, @ModelAttribute Cv cv, RedirectAttributes redirectAttributes, Model model) {
	    try {
		    Cv updateCv = cvService.updateCv(id, cv);
		    model.addAttribute("updateCv", updateCv);

		    redirectAttributes.addFlashAttribute("success", "cv modify with success");
	    } catch (Exception e) {
		    redirectAttributes.addFlashAttribute(
		     "error",
		     "An error has occurred during the update of cv");
	    }

	    return "redirect:/cvs";
	}

	@PostMapping("/{id}/delete")
	public String deleteCvById(@PathVariable Long id, RedirectAttributes redirectAttributes, Model model) {
	    try {
		     cvService.deleteCv(id);

		    redirectAttributes.addFlashAttribute("success", "cv has been deleted ");
	    } catch (Exception e) {
		    redirectAttributes.addFlashAttribute(
		     "error",
		     "An error has occurred during the delete of cv");
	    }

	    return "redirect:/cvs";
	}

}



