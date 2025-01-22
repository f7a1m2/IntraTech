package labs.intratech.controllers;

import org.springframework.ui.Model;
import labs.intratech.models.*;
import labs.intratech.services.*;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/reponsespossibless")
public class ReponsesPossiblesController  {
	private final ReponsesPossiblesService reponsespossiblesService;
	private final QuestionsEvaluationService questionsevaluationService;
	

	public ReponsesPossiblesController(QuestionsEvaluationService questionsevaluationService, ReponsesPossiblesService reponsespossiblesService) {
	    this.reponsespossiblesService = reponsespossiblesService;
	    this.questionsevaluationService = questionsevaluationService;
	    
	}

	@GetMapping
	public String getAllReponsesPossibless(Model model) {
	    List<ReponsesPossibles> reponsespossibless = reponsespossiblesService.getAllReponsesPossibles();
	    List<QuestionsEvaluation> questionsevaluations = questionsevaluationService.getAllQuestionsEvaluation();
	    
	    model.addAttribute("reponsespossibless", reponsespossibless);
	    model.addAttribute("questionsEvaluations", questionsEvaluations);
	    
	    return "reponsespossibless/list-reponsespossibles";
	}

	@GetMapping("/create-reponsespossibles")
	public String returnReponsesPossibless(Model model) {
	    List<QuestionsEvaluation> questionsevaluations = questionsevaluationService.getAllQuestionsEvaluation();
	    
	    model.addAttribute("questionsEvaluations", questionsEvaluations);
	    
	    return "reponsespossibless/create-reponsespossibles";
	}

	@PostMapping
	public String createReponsesPossibles(@ModelAttribute ReponsesPossibles reponsespossibles, RedirectAttributes redirectAttributes, Model model) {
	    try {
		    ReponsesPossibles newReponsesPossibles = reponsespossiblesService.createReponsesPossibles(reponsespossibles);
		    model.addAttribute("newReponsesPossibles", newReponsesPossibles);

		    redirectAttributes.addFlashAttribute("success", "reponsespossibles successfully completed");
	    } catch (Exception e) {
		    redirectAttributes.addFlashAttribute(
		     "error",
		     "An error has occurred during the creation of reponsespossibles");
	    }

	    return "redirect:/reponsespossibless";
	}

	@PostMapping("/{id}")
	public String updateReponsesPossibles(@PathVariable Long id, @ModelAttribute ReponsesPossibles reponsespossibles, RedirectAttributes redirectAttributes, Model model) {
	    try {
		    ReponsesPossibles updateReponsesPossibles = reponsespossiblesService.updateReponsesPossibles(id, reponsespossibles);
		    model.addAttribute("updateReponsesPossibles", updateReponsesPossibles);

		    redirectAttributes.addFlashAttribute("success", "reponsespossibles modify with success");
	    } catch (Exception e) {
		    redirectAttributes.addFlashAttribute(
		     "error",
		     "An error has occurred during the update of reponsespossibles");
	    }

	    return "redirect:/reponsespossibless";
	}

	@PostMapping("/{id}/delete")
	public String deleteReponsesPossiblesById(@PathVariable Long id, RedirectAttributes redirectAttributes, Model model) {
	    try {
		     reponsespossiblesService.deleteReponsesPossibles(id);

		    redirectAttributes.addFlashAttribute("success", "reponsespossibles has been deleted ");
	    } catch (Exception e) {
		    redirectAttributes.addFlashAttribute(
		     "error",
		     "An error has occurred during the delete of reponsespossibles");
	    }

	    return "redirect:/reponsespossibless";
	}

}



