package labs.intratech.controllers;

import org.springframework.ui.Model;
import labs.intratech.models.*;
import labs.intratech.services.*;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/evaluationss")
public class EvaluationsController  {
	private final EvaluationsService evaluationsService;
	private final CandidaturesService candidaturesService;
	

	public EvaluationsController(CandidaturesService candidaturesService, EvaluationsService evaluationsService) {
	    this.evaluationsService = evaluationsService;
	    this.candidaturesService = candidaturesService;
	    
	}

	@GetMapping
	public String getAllEvaluationss(Model model) {
	    List<Evaluations> evaluationss = evaluationsService.getAllEvaluations();
	    List<Candidatures> candidaturess = candidaturesService.getAllCandidatures();
	    
	    model.addAttribute("evaluationss", evaluationss);
	    model.addAttribute("candidaturess", candidaturess);
	    
	    return "evaluationss/list-evaluations";
	}

	@GetMapping("/create-evaluations")
	public String returnEvaluationss(Model model) {
	    List<Candidatures> candidaturess = candidaturesService.getAllCandidatures();
	    
	    model.addAttribute("candidaturess", candidaturess);
	    
	    return "evaluationss/create-evaluations";
	}

	@PostMapping
	public String createEvaluations(@ModelAttribute Evaluations evaluations, RedirectAttributes redirectAttributes, Model model) {
	    try {
		    Evaluations newEvaluations = evaluationsService.createEvaluations(evaluations);
		    model.addAttribute("newEvaluations", newEvaluations);

		    redirectAttributes.addFlashAttribute("success", "evaluations successfully completed");
	    } catch (Exception e) {
		    redirectAttributes.addFlashAttribute(
		     "error",
		     "An error has occurred during the creation of evaluations");
	    }

	    return "redirect:/evaluationss";
	}

	@PostMapping("/{id}")
	public String updateEvaluations(@PathVariable Long id, @ModelAttribute Evaluations evaluations, RedirectAttributes redirectAttributes, Model model) {
	    try {
		    Evaluations updateEvaluations = evaluationsService.updateEvaluations(id, evaluations);
		    model.addAttribute("updateEvaluations", updateEvaluations);

		    redirectAttributes.addFlashAttribute("success", "evaluations modify with success");
	    } catch (Exception e) {
		    redirectAttributes.addFlashAttribute(
		     "error",
		     "An error has occurred during the update of evaluations");
	    }

	    return "redirect:/evaluationss";
	}

	@PostMapping("/{id}/delete")
	public String deleteEvaluationsById(@PathVariable Long id, RedirectAttributes redirectAttributes, Model model) {
	    try {
		     evaluationsService.deleteEvaluations(id);

		    redirectAttributes.addFlashAttribute("success", "evaluations has been deleted ");
	    } catch (Exception e) {
		    redirectAttributes.addFlashAttribute(
		     "error",
		     "An error has occurred during the delete of evaluations");
	    }

	    return "redirect:/evaluationss";
	}

}



