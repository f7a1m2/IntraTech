package labs.intratech.controllers;

import org.springframework.ui.Model;
import labs.intratech.models.*;
import labs.intratech.services.*;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/historiqueperformanceemployes")
public class HistoriquePerformanceEmployeController  {
	private final HistoriquePerformanceEmployeService historiqueperformanceemployeService;
	private final EmployesService employesService;
	

	public HistoriquePerformanceEmployeController(EmployesService employesService, HistoriquePerformanceEmployeService historiqueperformanceemployeService) {
	    this.historiqueperformanceemployeService = historiqueperformanceemployeService;
	    this.employesService = employesService;
	    
	}

	@GetMapping
	public String getAllHistoriquePerformanceEmployes(Model model) {
	    List<HistoriquePerformanceEmploye> historiqueperformanceemployes = historiqueperformanceemployeService.getAllHistoriquePerformanceEmploye();
	    List<Employes> employess = employesService.getAllEmployes();
	    
	    model.addAttribute("historiqueperformanceemployes", historiqueperformanceemployes);
	    model.addAttribute("employess", employess);
	    
	    return "historiqueperformanceemployes/list-historiqueperformanceemploye";
	}

	@GetMapping("/create-historiqueperformanceemploye")
	public String returnHistoriquePerformanceEmployes(Model model) {
	    List<Employes> employess = employesService.getAllEmployes();
	    
	    model.addAttribute("employess", employess);
	    
	    return "historiqueperformanceemployes/create-historiqueperformanceemploye";
	}

	@PostMapping
	public String createHistoriquePerformanceEmploye(@ModelAttribute HistoriquePerformanceEmploye historiqueperformanceemploye, RedirectAttributes redirectAttributes, Model model) {
	    try {
		    HistoriquePerformanceEmploye newHistoriquePerformanceEmploye = historiqueperformanceemployeService.createHistoriquePerformanceEmploye(historiqueperformanceemploye);
		    model.addAttribute("newHistoriquePerformanceEmploye", newHistoriquePerformanceEmploye);

		    redirectAttributes.addFlashAttribute("success", "historiqueperformanceemploye successfully completed");
	    } catch (Exception e) {
		    redirectAttributes.addFlashAttribute(
		     "error",
		     "An error has occurred during the creation of historiqueperformanceemploye");
	    }

	    return "redirect:/historiqueperformanceemployes";
	}

	@PostMapping("/{id}")
	public String updateHistoriquePerformanceEmploye(@PathVariable Long id, @ModelAttribute HistoriquePerformanceEmploye historiqueperformanceemploye, RedirectAttributes redirectAttributes, Model model) {
	    try {
		    HistoriquePerformanceEmploye updateHistoriquePerformanceEmploye = historiqueperformanceemployeService.updateHistoriquePerformanceEmploye(id, historiqueperformanceemploye);
		    model.addAttribute("updateHistoriquePerformanceEmploye", updateHistoriquePerformanceEmploye);

		    redirectAttributes.addFlashAttribute("success", "historiqueperformanceemploye modify with success");
	    } catch (Exception e) {
		    redirectAttributes.addFlashAttribute(
		     "error",
		     "An error has occurred during the update of historiqueperformanceemploye");
	    }

	    return "redirect:/historiqueperformanceemployes";
	}

	@PostMapping("/{id}/delete")
	public String deleteHistoriquePerformanceEmployeById(@PathVariable Long id, RedirectAttributes redirectAttributes, Model model) {
	    try {
		     historiqueperformanceemployeService.deleteHistoriquePerformanceEmploye(id);

		    redirectAttributes.addFlashAttribute("success", "historiqueperformanceemploye has been deleted ");
	    } catch (Exception e) {
		    redirectAttributes.addFlashAttribute(
		     "error",
		     "An error has occurred during the delete of historiqueperformanceemploye");
	    }

	    return "redirect:/historiqueperformanceemployes";
	}

}



