package labs.intratech.controllers;

import org.springframework.ui.Model;
import labs.intratech.models.*;
import labs.intratech.services.*;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/candidaturess")
public class CandidaturesController  {
	private final CandidaturesService candidaturesService;
	private final CandidatsService candidatsService;
	private final OffresService offresService;
	

	public CandidaturesController(CandidatsService candidatsService,OffresService offresService, CandidaturesService candidaturesService) {
	    this.candidaturesService = candidaturesService;
	    this.candidatsService = candidatsService;
	    this.offresService = offresService;
	    
	}

	@GetMapping
	public String getAllCandidaturess(Model model) {
	    List<Candidatures> candidaturess = candidaturesService.getAllCandidatures();
	    List<Candidats> candidatss = candidatsService.getAllCandidats();
	    List<Offres> offress = offresService.getAllOffres();
	    
	    model.addAttribute("candidaturess", candidaturess);
	    model.addAttribute("candidatss", candidatss);
	    model.addAttribute("offress", offress);
	    
	    return "candidaturess/list-candidatures";
	}

	@GetMapping("/create-candidatures")
	public String returnCandidaturess(Model model) {
	    List<Candidats> candidatss = candidatsService.getAllCandidats();
	    List<Offres> offress = offresService.getAllOffres();
	    
	    model.addAttribute("candidatss", candidatss);
	    model.addAttribute("offress", offress);
	    
	    return "candidaturess/create-candidatures";
	}

	@PostMapping
	public String createCandidatures(@ModelAttribute Candidatures candidatures, RedirectAttributes redirectAttributes, Model model) {
	    try {
		    Candidatures newCandidatures = candidaturesService.createCandidatures(candidatures);
		    model.addAttribute("newCandidatures", newCandidatures);

		    redirectAttributes.addFlashAttribute("success", "candidatures successfully completed");
	    } catch (Exception e) {
		    redirectAttributes.addFlashAttribute(
		     "error",
		     "An error has occurred during the creation of candidatures");
	    }

	    return "redirect:/candidaturess";
	}

	@PostMapping("/{id}")
	public String updateCandidatures(@PathVariable Long id, @ModelAttribute Candidatures candidatures, RedirectAttributes redirectAttributes, Model model) {
	    try {
		    Candidatures updateCandidatures = candidaturesService.updateCandidatures(id, candidatures);
		    model.addAttribute("updateCandidatures", updateCandidatures);

		    redirectAttributes.addFlashAttribute("success", "candidatures modify with success");
	    } catch (Exception e) {
		    redirectAttributes.addFlashAttribute(
		     "error",
		     "An error has occurred during the update of candidatures");
	    }

	    return "redirect:/candidaturess";
	}

	@PostMapping("/{id}/delete")
	public String deleteCandidaturesById(@PathVariable Long id, RedirectAttributes redirectAttributes, Model model) {
	    try {
		     candidaturesService.deleteCandidatures(id);

		    redirectAttributes.addFlashAttribute("success", "candidatures has been deleted ");
	    } catch (Exception e) {
		    redirectAttributes.addFlashAttribute(
		     "error",
		     "An error has occurred during the delete of candidatures");
	    }

	    return "redirect:/candidaturess";
	}

}



