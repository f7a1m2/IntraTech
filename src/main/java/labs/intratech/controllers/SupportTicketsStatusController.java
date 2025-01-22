package labs.intratech.controllers;

import org.springframework.ui.Model;
import labs.intratech.models.*;
import labs.intratech.services.*;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/supportticketsstatuss")
public class SupportTicketsStatusController  {
	private final SupportTicketsStatusService supportticketsstatusService;
	

	public SupportTicketsStatusController( SupportTicketsStatusService supportticketsstatusService) {
	    this.supportticketsstatusService = supportticketsstatusService;
	    
	}

	@GetMapping
	public String getAllSupportTicketsStatuss(Model model) {
	    List<SupportTicketsStatus> supportticketsstatuss = supportticketsstatusService.getAllSupportTicketsStatus();
	    
	    model.addAttribute("supportticketsstatuss", supportticketsstatuss);
	    
	    return "supportticketsstatuss/list-supportticketsstatus";
	}

	@GetMapping("/create-supportticketsstatus")
	public String returnSupportTicketsStatuss(Model model) {
	    
	    
	    return "supportticketsstatuss/create-supportticketsstatus";
	}

	@PostMapping
	public String createSupportTicketsStatus(@ModelAttribute SupportTicketsStatus supportticketsstatus, RedirectAttributes redirectAttributes, Model model) {
	    try {
		    SupportTicketsStatus newSupportTicketsStatus = supportticketsstatusService.createSupportTicketsStatus(supportticketsstatus);
		    model.addAttribute("newSupportTicketsStatus", newSupportTicketsStatus);

		    redirectAttributes.addFlashAttribute("success", "supportticketsstatus successfully completed");
	    } catch (Exception e) {
		    redirectAttributes.addFlashAttribute(
		     "error",
		     "An error has occurred during the creation of supportticketsstatus");
	    }

	    return "redirect:/supportticketsstatuss";
	}

	@PostMapping("/{id}")
	public String updateSupportTicketsStatus(@PathVariable Long id, @ModelAttribute SupportTicketsStatus supportticketsstatus, RedirectAttributes redirectAttributes, Model model) {
	    try {
		    SupportTicketsStatus updateSupportTicketsStatus = supportticketsstatusService.updateSupportTicketsStatus(id, supportticketsstatus);
		    model.addAttribute("updateSupportTicketsStatus", updateSupportTicketsStatus);

		    redirectAttributes.addFlashAttribute("success", "supportticketsstatus modify with success");
	    } catch (Exception e) {
		    redirectAttributes.addFlashAttribute(
		     "error",
		     "An error has occurred during the update of supportticketsstatus");
	    }

	    return "redirect:/supportticketsstatuss";
	}

	@PostMapping("/{id}/delete")
	public String deleteSupportTicketsStatusById(@PathVariable Long id, RedirectAttributes redirectAttributes, Model model) {
	    try {
		     supportticketsstatusService.deleteSupportTicketsStatus(id);

		    redirectAttributes.addFlashAttribute("success", "supportticketsstatus has been deleted ");
	    } catch (Exception e) {
		    redirectAttributes.addFlashAttribute(
		     "error",
		     "An error has occurred during the delete of supportticketsstatus");
	    }

	    return "redirect:/supportticketsstatuss";
	}

}



