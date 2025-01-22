package labs.intratech.controllers;

import org.springframework.ui.Model;
import labs.intratech.models.*;
import labs.intratech.services.*;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/reponsesevaluations")
public class ReponsesEvaluationController  {
	private final ReponsesEvaluationService reponsesevaluationService;
	private final EvaluationsService evaluationsService;
	private final QuestionsEvaluationService questionsevaluationService;
	private final ReponsesPossiblesService reponsespossiblesService;
	

	public ReponsesEvaluationController(EvaluationsService evaluationsService,QuestionsEvaluationService questionsevaluationService,ReponsesPossiblesService reponsespossiblesService, ReponsesEvaluationService reponsesevaluationService) {
	    this.reponsesevaluationService = reponsesevaluationService;
	    this.evaluationsService = evaluationsService;
	    this.questionsevaluationService = questionsevaluationService;
	    this.reponsespossiblesService = reponsespossiblesService;
	    
	}

	@GetMapping
	public String getAllReponsesEvaluations(Model model) {
	    List<ReponsesEvaluation> reponsesevaluations = reponsesevaluationService.getAllReponsesEvaluation();
	    List<Evaluations> evaluationss = evaluationsService.getAllEvaluations();
	    List<QuestionsEvaluation> questionsevaluations = questionsevaluationService.getAllQuestionsEvaluation();
	    List<ReponsesPossibles> reponsespossibless = reponsespossiblesService.getAllReponsesPossibles();
	    
	    model.addAttribute("reponsesevaluations", reponsesevaluations);
	    model.addAttribute("evaluationss", evaluationss);
	    model.addAttribute("questionsEvaluations", questionsEvaluations);
	    model.addAttribute("reponsesPossibless", reponsesPossibless);
	    
	    return "reponsesevaluations/list-reponsesevaluation";
	}

	@GetMapping("/create-reponsesevaluation")
	public String returnReponsesEvaluations(Model model) {
	    List<Evaluations> evaluationss = evaluationsService.getAllEvaluations();
	    List<QuestionsEvaluation> questionsevaluations = questionsevaluationService.getAllQuestionsEvaluation();
	    List<ReponsesPossibles> reponsespossibless = reponsespossiblesService.getAllReponsesPossibles();
	    
	    model.addAttribute("evaluationss", evaluationss);
	    model.addAttribute("questionsEvaluations", questionsEvaluations);
	    model.addAttribute("reponsesPossibless", reponsesPossibless);
	    
	    return "reponsesevaluations/create-reponsesevaluation";
	}

	@PostMapping
	public String createReponsesEvaluation(@ModelAttribute ReponsesEvaluation reponsesevaluation, RedirectAttributes redirectAttributes, Model model) {
	    try {
		    ReponsesEvaluation newReponsesEvaluation = reponsesevaluationService.createReponsesEvaluation(reponsesevaluation);
		    model.addAttribute("newReponsesEvaluation", newReponsesEvaluation);

		    redirectAttributes.addFlashAttribute("success", "reponsesevaluation successfully completed");
	    } catch (Exception e) {
		    redirectAttributes.addFlashAttribute(
		     "error",
		     "An error has occurred during the creation of reponsesevaluation");
	    }

	    return "redirect:/reponsesevaluations";
	}

	@PostMapping("/{id}")
	public String updateReponsesEvaluation(@PathVariable Long id, @ModelAttribute ReponsesEvaluation reponsesevaluation, RedirectAttributes redirectAttributes, Model model) {
	    try {
		    ReponsesEvaluation updateReponsesEvaluation = reponsesevaluationService.updateReponsesEvaluation(id, reponsesevaluation);
		    model.addAttribute("updateReponsesEvaluation", updateReponsesEvaluation);

		    redirectAttributes.addFlashAttribute("success", "reponsesevaluation modify with success");
	    } catch (Exception e) {
		    redirectAttributes.addFlashAttribute(
		     "error",
		     "An error has occurred during the update of reponsesevaluation");
	    }

	    return "redirect:/reponsesevaluations";
	}

	@PostMapping("/{id}/delete")
	public String deleteReponsesEvaluationById(@PathVariable Long id, RedirectAttributes redirectAttributes, Model model) {
	    try {
		     reponsesevaluationService.deleteReponsesEvaluation(id);

		    redirectAttributes.addFlashAttribute("success", "reponsesevaluation has been deleted ");
	    } catch (Exception e) {
		    redirectAttributes.addFlashAttribute(
		     "error",
		     "An error has occurred during the delete of reponsesevaluation");
	    }

	    return "redirect:/reponsesevaluations";
	}

}



