package labs.intratech.controllers;

import org.springframework.ui.Model;
import labs.intratech.models.*;
import labs.intratech.services.*;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/subscriptionsstatuss")
public class SubscriptionsStatusController  {
	private final SubscriptionsStatusService subscriptionsstatusService;
	

	public SubscriptionsStatusController( SubscriptionsStatusService subscriptionsstatusService) {
	    this.subscriptionsstatusService = subscriptionsstatusService;
	    
	}

	@GetMapping
	public String getAllSubscriptionsStatuss(Model model) {
	    List<SubscriptionsStatus> subscriptionsstatuss = subscriptionsstatusService.getAllSubscriptionsStatus();
	    
	    model.addAttribute("subscriptionsstatuss", subscriptionsstatuss);
	    
	    return "subscriptionsstatuss/list-subscriptionsstatus";
	}

	@GetMapping("/create-subscriptionsstatus")
	public String returnSubscriptionsStatuss(Model model) {
	    
	    
	    return "subscriptionsstatuss/create-subscriptionsstatus";
	}

	@PostMapping
	public String createSubscriptionsStatus(@ModelAttribute SubscriptionsStatus subscriptionsstatus, RedirectAttributes redirectAttributes, Model model) {
	    try {
		    SubscriptionsStatus newSubscriptionsStatus = subscriptionsstatusService.createSubscriptionsStatus(subscriptionsstatus);
		    model.addAttribute("newSubscriptionsStatus", newSubscriptionsStatus);

		    redirectAttributes.addFlashAttribute("success", "subscriptionsstatus successfully completed");
	    } catch (Exception e) {
		    redirectAttributes.addFlashAttribute(
		     "error",
		     "An error has occurred during the creation of subscriptionsstatus");
	    }

	    return "redirect:/subscriptionsstatuss";
	}

	@PostMapping("/{id}")
	public String updateSubscriptionsStatus(@PathVariable Long id, @ModelAttribute SubscriptionsStatus subscriptionsstatus, RedirectAttributes redirectAttributes, Model model) {
	    try {
		    SubscriptionsStatus updateSubscriptionsStatus = subscriptionsstatusService.updateSubscriptionsStatus(id, subscriptionsstatus);
		    model.addAttribute("updateSubscriptionsStatus", updateSubscriptionsStatus);

		    redirectAttributes.addFlashAttribute("success", "subscriptionsstatus modify with success");
	    } catch (Exception e) {
		    redirectAttributes.addFlashAttribute(
		     "error",
		     "An error has occurred during the update of subscriptionsstatus");
	    }

	    return "redirect:/subscriptionsstatuss";
	}

	@PostMapping("/{id}/delete")
	public String deleteSubscriptionsStatusById(@PathVariable Long id, RedirectAttributes redirectAttributes, Model model) {
	    try {
		     subscriptionsstatusService.deleteSubscriptionsStatus(id);

		    redirectAttributes.addFlashAttribute("success", "subscriptionsstatus has been deleted ");
	    } catch (Exception e) {
		    redirectAttributes.addFlashAttribute(
		     "error",
		     "An error has occurred during the delete of subscriptionsstatus");
	    }

	    return "redirect:/subscriptionsstatuss";
	}

}



