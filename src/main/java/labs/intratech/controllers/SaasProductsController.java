package labs.intratech.controllers;

import org.springframework.ui.Model;
import labs.intratech.models.*;
import labs.intratech.services.*;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/saasproductss")
public class SaasProductsController  {
	private final SaasProductsService saasproductsService;
	

	public SaasProductsController( SaasProductsService saasproductsService) {
	    this.saasproductsService = saasproductsService;
	    
	}

	@GetMapping
	public String getAllSaasProductss(Model model) {
	    List<SaasProducts> saasproductss = saasproductsService.getAllSaasProducts();
	    
	    model.addAttribute("saasproductss", saasproductss);
	    
	    return "saasproductss/list-saasproducts";
	}

	@GetMapping("/create-saasproducts")
	public String returnSaasProductss(Model model) {
	    
	    
	    return "saasproductss/create-saasproducts";
	}

	@PostMapping
	public String createSaasProducts(@ModelAttribute SaasProducts saasproducts, RedirectAttributes redirectAttributes, Model model) {
	    try {
		    SaasProducts newSaasProducts = saasproductsService.createSaasProducts(saasproducts);
		    model.addAttribute("newSaasProducts", newSaasProducts);

		    redirectAttributes.addFlashAttribute("success", "saasproducts successfully completed");
	    } catch (Exception e) {
		    redirectAttributes.addFlashAttribute(
		     "error",
		     "An error has occurred during the creation of saasproducts");
	    }

	    return "redirect:/saasproductss";
	}

	@PostMapping("/{id}")
	public String updateSaasProducts(@PathVariable Long id, @ModelAttribute SaasProducts saasproducts, RedirectAttributes redirectAttributes, Model model) {
	    try {
		    SaasProducts updateSaasProducts = saasproductsService.updateSaasProducts(id, saasproducts);
		    model.addAttribute("updateSaasProducts", updateSaasProducts);

		    redirectAttributes.addFlashAttribute("success", "saasproducts modify with success");
	    } catch (Exception e) {
		    redirectAttributes.addFlashAttribute(
		     "error",
		     "An error has occurred during the update of saasproducts");
	    }

	    return "redirect:/saasproductss";
	}

	@PostMapping("/{id}/delete")
	public String deleteSaasProductsById(@PathVariable Long id, RedirectAttributes redirectAttributes, Model model) {
	    try {
		     saasproductsService.deleteSaasProducts(id);

		    redirectAttributes.addFlashAttribute("success", "saasproducts has been deleted ");
	    } catch (Exception e) {
		    redirectAttributes.addFlashAttribute(
		     "error",
		     "An error has occurred during the delete of saasproducts");
	    }

	    return "redirect:/saasproductss";
	}

}



