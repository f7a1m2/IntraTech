package labs.intratech.controllers;

import org.springframework.ui.Model;
import labs.intratech.models.*;
import labs.intratech.services.*;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/financialindicatorss")
public class FinancialIndicatorsController  {
	private final FinancialIndicatorsService financialindicatorsService;
	

	public FinancialIndicatorsController( FinancialIndicatorsService financialindicatorsService) {
	    this.financialindicatorsService = financialindicatorsService;
	    
	}

	@GetMapping
	public String getAllFinancialIndicatorss(Model model) {
	    List<FinancialIndicators> financialindicatorss = financialindicatorsService.getAllFinancialIndicators();
	    
	    model.addAttribute("financialindicatorss", financialindicatorss);
	    
	    return "financialindicatorss/list-financialindicators";
	}

	@GetMapping("/create-financialindicators")
	public String returnFinancialIndicatorss(Model model) {
	    
	    
	    return "financialindicatorss/create-financialindicators";
	}

	@PostMapping
	public String createFinancialIndicators(@ModelAttribute FinancialIndicators financialindicators, RedirectAttributes redirectAttributes, Model model) {
	    try {
		    FinancialIndicators newFinancialIndicators = financialindicatorsService.createFinancialIndicators(financialindicators);
		    model.addAttribute("newFinancialIndicators", newFinancialIndicators);

		    redirectAttributes.addFlashAttribute("success", "financialindicators successfully completed");
	    } catch (Exception e) {
		    redirectAttributes.addFlashAttribute(
		     "error",
		     "An error has occurred during the creation of financialindicators");
	    }

	    return "redirect:/financialindicatorss";
	}

	@PostMapping("/{id}")
	public String updateFinancialIndicators(@PathVariable Long id, @ModelAttribute FinancialIndicators financialindicators, RedirectAttributes redirectAttributes, Model model) {
	    try {
		    FinancialIndicators updateFinancialIndicators = financialindicatorsService.updateFinancialIndicators(id, financialindicators);
		    model.addAttribute("updateFinancialIndicators", updateFinancialIndicators);

		    redirectAttributes.addFlashAttribute("success", "financialindicators modify with success");
	    } catch (Exception e) {
		    redirectAttributes.addFlashAttribute(
		     "error",
		     "An error has occurred during the update of financialindicators");
	    }

	    return "redirect:/financialindicatorss";
	}

	@PostMapping("/{id}/delete")
	public String deleteFinancialIndicatorsById(@PathVariable Long id, RedirectAttributes redirectAttributes, Model model) {
	    try {
		     financialindicatorsService.deleteFinancialIndicators(id);

		    redirectAttributes.addFlashAttribute("success", "financialindicators has been deleted ");
	    } catch (Exception e) {
		    redirectAttributes.addFlashAttribute(
		     "error",
		     "An error has occurred during the delete of financialindicators");
	    }

	    return "redirect:/financialindicatorss";
	}

}



