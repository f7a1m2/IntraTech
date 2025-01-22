package labs.intratech.controllers;

import org.springframework.ui.Model;
import labs.intratech.models.*;
import labs.intratech.services.*;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/questionsevaluations")
public class QuestionsEvaluationController  {
	private final QuestionsEvaluationService questionsevaluationService;
	

	public QuestionsEvaluationController( QuestionsEvaluationService questionsevaluationService) {
	    this.questionsevaluationService = questionsevaluationService;
	    
	}

	@GetMapping
	public String getAllQuestionsEvaluations(Model model) {
	    List<QuestionsEvaluation> questionsevaluations = questionsevaluationService.getAllQuestionsEvaluation();
	    
	    model.addAttribute("questionsevaluations", questionsevaluations);
	    
	    return "questionsevaluations/list-questionsevaluation";
	}

	@GetMapping("/create-questionsevaluation")
	public String returnQuestionsEvaluations(Model model) {
	    
	    
	    return "questionsevaluations/create-questionsevaluation";
	}

	@PostMapping
	public String createQuestionsEvaluation(@ModelAttribute QuestionsEvaluation questionsevaluation, RedirectAttributes redirectAttributes, Model model) {
	    try {
		    QuestionsEvaluation newQuestionsEvaluation = questionsevaluationService.createQuestionsEvaluation(questionsevaluation);
		    model.addAttribute("newQuestionsEvaluation", newQuestionsEvaluation);

		    redirectAttributes.addFlashAttribute("success", "questionsevaluation successfully completed");
	    } catch (Exception e) {
		    redirectAttributes.addFlashAttribute(
		     "error",
		     "An error has occurred during the creation of questionsevaluation");
	    }

	    return "redirect:/questionsevaluations";
	}

	@PostMapping("/{id}")
	public String updateQuestionsEvaluation(@PathVariable Long id, @ModelAttribute QuestionsEvaluation questionsevaluation, RedirectAttributes redirectAttributes, Model model) {
	    try {
		    QuestionsEvaluation updateQuestionsEvaluation = questionsevaluationService.updateQuestionsEvaluation(id, questionsevaluation);
		    model.addAttribute("updateQuestionsEvaluation", updateQuestionsEvaluation);

		    redirectAttributes.addFlashAttribute("success", "questionsevaluation modify with success");
	    } catch (Exception e) {
		    redirectAttributes.addFlashAttribute(
		     "error",
		     "An error has occurred during the update of questionsevaluation");
	    }

	    return "redirect:/questionsevaluations";
	}

	@PostMapping("/{id}/delete")
	public String deleteQuestionsEvaluationById(@PathVariable Long id, RedirectAttributes redirectAttributes, Model model) {
	    try {
		     questionsevaluationService.deleteQuestionsEvaluation(id);

		    redirectAttributes.addFlashAttribute("success", "questionsevaluation has been deleted ");
	    } catch (Exception e) {
		    redirectAttributes.addFlashAttribute(
		     "error",
		     "An error has occurred during the delete of questionsevaluation");
	    }

	    return "redirect:/questionsevaluations";
	}

}



