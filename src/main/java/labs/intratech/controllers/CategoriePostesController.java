package labs.intratech.controllers;

import org.springframework.ui.Model;
import labs.intratech.models.*;
import labs.intratech.services.*;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/categoriepostess")
public class CategoriePostesController  {
	private final CategoriePostesService categoriepostesService;
	

	public CategoriePostesController( CategoriePostesService categoriepostesService) {
	    this.categoriepostesService = categoriepostesService;
	    
	}

	@GetMapping
	public String getAllCategoriePostess(Model model) {
	    List<CategoriePostes> categoriepostess = categoriepostesService.getAllCategoriePostes();
	    
	    model.addAttribute("categoriepostess", categoriepostess);
	    
	    return "categoriepostess/list-categoriepostes";
	}

	@GetMapping("/create-categoriepostes")
	public String returnCategoriePostess(Model model) {
	    
	    
	    return "categoriepostess/create-categoriepostes";
	}

	@PostMapping
	public String createCategoriePostes(@ModelAttribute CategoriePostes categoriepostes, RedirectAttributes redirectAttributes, Model model) {
	    try {
		    CategoriePostes newCategoriePostes = categoriepostesService.createCategoriePostes(categoriepostes);
		    model.addAttribute("newCategoriePostes", newCategoriePostes);

		    redirectAttributes.addFlashAttribute("success", "categoriepostes successfully completed");
	    } catch (Exception e) {
		    redirectAttributes.addFlashAttribute(
		     "error",
		     "An error has occurred during the creation of categoriepostes");
	    }

	    return "redirect:/categoriepostess";
	}

	@PostMapping("/{id}")
	public String updateCategoriePostes(@PathVariable Long id, @ModelAttribute CategoriePostes categoriepostes, RedirectAttributes redirectAttributes, Model model) {
	    try {
		    CategoriePostes updateCategoriePostes = categoriepostesService.updateCategoriePostes(id, categoriepostes);
		    model.addAttribute("updateCategoriePostes", updateCategoriePostes);

		    redirectAttributes.addFlashAttribute("success", "categoriepostes modify with success");
	    } catch (Exception e) {
		    redirectAttributes.addFlashAttribute(
		     "error",
		     "An error has occurred during the update of categoriepostes");
	    }

	    return "redirect:/categoriepostess";
	}

	@PostMapping("/{id}/delete")
	public String deleteCategoriePostesById(@PathVariable Long id, RedirectAttributes redirectAttributes, Model model) {
	    try {
		     categoriepostesService.deleteCategoriePostes(id);

		    redirectAttributes.addFlashAttribute("success", "categoriepostes has been deleted ");
	    } catch (Exception e) {
		    redirectAttributes.addFlashAttribute(
		     "error",
		     "An error has occurred during the delete of categoriepostes");
	    }

	    return "redirect:/categoriepostess";
	}

}



