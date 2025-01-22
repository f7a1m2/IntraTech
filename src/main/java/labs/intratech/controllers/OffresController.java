package labs.intratech.controllers;

import org.springframework.ui.Model;
import labs.intratech.models.*;
import labs.intratech.services.*;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/offress")
public class OffresController  {
	private final OffresService offresService;
	private final PostesService postesService;
	

	public OffresController(PostesService postesService, OffresService offresService) {
	    this.offresService = offresService;
	    this.postesService = postesService;
	    
	}

	@GetMapping
	public String getAllOffress(Model model) {
	    List<Offres> offress = offresService.getAllOffres();
	    List<Postes> postess = postesService.getAllPostes();
	    
	    model.addAttribute("offress", offress);
	    model.addAttribute("postess", postess);
	    
	    return "offress/list-offres";
	}

	@GetMapping("/create-offres")
	public String returnOffress(Model model) {
	    List<Postes> postess = postesService.getAllPostes();
	    
	    model.addAttribute("postess", postess);
	    
	    return "offress/create-offres";
	}

	@PostMapping
	public String createOffres(@ModelAttribute Offres offres, RedirectAttributes redirectAttributes, Model model) {
	    try {
		    Offres newOffres = offresService.createOffres(offres);
		    model.addAttribute("newOffres", newOffres);

		    redirectAttributes.addFlashAttribute("success", "offres successfully completed");
	    } catch (Exception e) {
		    redirectAttributes.addFlashAttribute(
		     "error",
		     "An error has occurred during the creation of offres");
	    }

	    return "redirect:/offress";
	}

	@PostMapping("/{id}")
	public String updateOffres(@PathVariable Long id, @ModelAttribute Offres offres, RedirectAttributes redirectAttributes, Model model) {
	    try {
		    Offres updateOffres = offresService.updateOffres(id, offres);
		    model.addAttribute("updateOffres", updateOffres);

		    redirectAttributes.addFlashAttribute("success", "offres modify with success");
	    } catch (Exception e) {
		    redirectAttributes.addFlashAttribute(
		     "error",
		     "An error has occurred during the update of offres");
	    }

	    return "redirect:/offress";
	}

	@PostMapping("/{id}/delete")
	public String deleteOffresById(@PathVariable Long id, RedirectAttributes redirectAttributes, Model model) {
	    try {
		     offresService.deleteOffres(id);

		    redirectAttributes.addFlashAttribute("success", "offres has been deleted ");
	    } catch (Exception e) {
		    redirectAttributes.addFlashAttribute(
		     "error",
		     "An error has occurred during the delete of offres");
	    }

	    return "redirect:/offress";
	}

}



