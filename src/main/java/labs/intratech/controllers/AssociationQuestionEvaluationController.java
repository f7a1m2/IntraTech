package labs.intratech.controllers;

import org.springframework.ui.Model;
import labs.intratech.models.*;
import labs.intratech.services.*;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/associationquestionevaluations")
public class AssociationQuestionEvaluationController  {
	private final AssociationQuestionEvaluationService associationquestionevaluationService;
	private final QuestionsEvaluationService questionsevaluationService;
	private final EvaluationsService evaluationsService;
	

	public AssociationQuestionEvaluationController(QuestionsEvaluationService questionsevaluationService,EvaluationsService evaluationsService, AssociationQuestionEvaluationService associationquestionevaluationService) {
	    this.associationquestionevaluationService = associationquestionevaluationService;
	    this.questionsevaluationService = questionsevaluationService;
	    this.evaluationsService = evaluationsService;
	    
	}

	@GetMapping
	public String getAllAssociationQuestionEvaluations(Model model) {
	    List<AssociationQuestionEvaluation> associationquestionevaluations = associationquestionevaluationService.getAllAssociationQuestionEvaluation();
	    List<QuestionsEvaluation> questionsevaluations = questionsevaluationService.getAllQuestionsEvaluation();
	    List<Evaluations> evaluationss = evaluationsService.getAllEvaluations();
	    
	    model.addAttribute("associationquestionevaluations", associationquestionevaluations);
	    model.addAttribute("questionsEvaluations", questionsevaluations);
	    model.addAttribute("evaluationss", evaluationss);
	    
	    return "associationquestionevaluations/list-associationquestionevaluation";
	}

	@GetMapping("/create-associationquestionevaluation")
	public String returnAssociationQuestionEvaluations(Model model) {
	    List<QuestionsEvaluation> questionsevaluations = questionsevaluationService.getAllQuestionsEvaluation();
	    List<Evaluations> evaluationss = evaluationsService.getAllEvaluations();
	    
	    model.addAttribute("questionsEvaluations", questionsevaluations);
	    model.addAttribute("evaluationss", evaluationss);
	    
	    return "associationquestionevaluations/create-associationquestionevaluation";
	}

	@PostMapping
	public String createAssociationQuestionEvaluation(@ModelAttribute AssociationQuestionEvaluation associationquestionevaluation, RedirectAttributes redirectAttributes, Model model) {
	    try {
		    AssociationQuestionEvaluation newAssociationQuestionEvaluation = associationquestionevaluationService.createAssociationQuestionEvaluation(associationquestionevaluation);
		    model.addAttribute("newAssociationQuestionEvaluation", newAssociationQuestionEvaluation);

		    redirectAttributes.addFlashAttribute("success", "associationquestionevaluation successfully completed");
	    } catch (Exception e) {
		    redirectAttributes.addFlashAttribute(
		     "error",
		     "An error has occurred during the creation of associationquestionevaluation");
	    }

	    return "redirect:/associationquestionevaluations";
	}

	@PostMapping("/{id}")
	public String updateAssociationQuestionEvaluation(@PathVariable Long id, @ModelAttribute AssociationQuestionEvaluation associationquestionevaluation, RedirectAttributes redirectAttributes, Model model) {
	    try {
		    AssociationQuestionEvaluation updateAssociationQuestionEvaluation = associationquestionevaluationService.updateAssociationQuestionEvaluation(id, associationquestionevaluation);
		    model.addAttribute("updateAssociationQuestionEvaluation", updateAssociationQuestionEvaluation);

		    redirectAttributes.addFlashAttribute("success", "associationquestionevaluation modify with success");
	    } catch (Exception e) {
		    redirectAttributes.addFlashAttribute(
		     "error",
		     "An error has occurred during the update of associationquestionevaluation");
	    }

	    return "redirect:/associationquestionevaluations";
	}

	@PostMapping("/{id}/delete")
	public String deleteAssociationQuestionEvaluationById(@PathVariable Long id, RedirectAttributes redirectAttributes, Model model) {
	    try {
		     associationquestionevaluationService.deleteAssociationQuestionEvaluation(id);

		    redirectAttributes.addFlashAttribute("success", "associationquestionevaluation has been deleted ");
	    } catch (Exception e) {
		    redirectAttributes.addFlashAttribute(
		     "error",
		     "An error has occurred during the delete of associationquestionevaluation");
	    }

	    return "redirect:/associationquestionevaluations";
	}

}



