package labs.intratech.controllers;

import org.springframework.ui.Model;
import labs.intratech.models.*;
import labs.intratech.services.*;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/supportticketss")
public class SupportTicketsController  {
	private final SupportTicketsService supportticketsService;
	private final UsersService usersService;
	private final SupportTicketsStatusService supportticketsstatusService;
	

	public SupportTicketsController(UsersService usersService,SupportTicketsStatusService supportticketsstatusService, SupportTicketsService supportticketsService) {
	    this.supportticketsService = supportticketsService;
	    this.usersService = usersService;
	    this.supportticketsstatusService = supportticketsstatusService;
	    
	}

	@GetMapping
	public String getAllSupportTicketss(Model model) {
	    List<SupportTickets> supportticketss = supportticketsService.getAllSupportTickets();
	    List<Users> userss = usersService.getAllUsers();
	    List<SupportTicketsStatus> supportticketsstatuss = supportticketsstatusService.getAllSupportTicketsStatus();
	    
	    model.addAttribute("supportticketss", supportticketss);
	    model.addAttribute("userss", userss);
	    model.addAttribute("supportTicketsStatuss", supportTicketsStatuss);
	    
	    return "supportticketss/list-supporttickets";
	}

	@GetMapping("/create-supporttickets")
	public String returnSupportTicketss(Model model) {
	    List<Users> userss = usersService.getAllUsers();
	    List<SupportTicketsStatus> supportticketsstatuss = supportticketsstatusService.getAllSupportTicketsStatus();
	    
	    model.addAttribute("userss", userss);
	    model.addAttribute("supportTicketsStatuss", supportTicketsStatuss);
	    
	    return "supportticketss/create-supporttickets";
	}

	@PostMapping
	public String createSupportTickets(@ModelAttribute SupportTickets supporttickets, RedirectAttributes redirectAttributes, Model model) {
	    try {
		    SupportTickets newSupportTickets = supportticketsService.createSupportTickets(supporttickets);
		    model.addAttribute("newSupportTickets", newSupportTickets);

		    redirectAttributes.addFlashAttribute("success", "supporttickets successfully completed");
	    } catch (Exception e) {
		    redirectAttributes.addFlashAttribute(
		     "error",
		     "An error has occurred during the creation of supporttickets");
	    }

	    return "redirect:/supportticketss";
	}

	@PostMapping("/{id}")
	public String updateSupportTickets(@PathVariable Long id, @ModelAttribute SupportTickets supporttickets, RedirectAttributes redirectAttributes, Model model) {
	    try {
		    SupportTickets updateSupportTickets = supportticketsService.updateSupportTickets(id, supporttickets);
		    model.addAttribute("updateSupportTickets", updateSupportTickets);

		    redirectAttributes.addFlashAttribute("success", "supporttickets modify with success");
	    } catch (Exception e) {
		    redirectAttributes.addFlashAttribute(
		     "error",
		     "An error has occurred during the update of supporttickets");
	    }

	    return "redirect:/supportticketss";
	}

	@PostMapping("/{id}/delete")
	public String deleteSupportTicketsById(@PathVariable Long id, RedirectAttributes redirectAttributes, Model model) {
	    try {
		     supportticketsService.deleteSupportTickets(id);

		    redirectAttributes.addFlashAttribute("success", "supporttickets has been deleted ");
	    } catch (Exception e) {
		    redirectAttributes.addFlashAttribute(
		     "error",
		     "An error has occurred during the delete of supporttickets");
	    }

	    return "redirect:/supportticketss";
	}

}



