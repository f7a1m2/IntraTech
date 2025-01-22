package labs.intratech.controllers;

import org.springframework.ui.Model;
import labs.intratech.models.*;
import labs.intratech.services.*;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/subscriptionss")
public class SubscriptionsController  {
	private final SubscriptionsService subscriptionsService;
	private final UsersService usersService;
	private final SaasProductsService saasproductsService;
	private final SubscriptionsStatusService subscriptionsstatusService;
	

	public SubscriptionsController(UsersService usersService,SaasProductsService saasproductsService,SubscriptionsStatusService subscriptionsstatusService, SubscriptionsService subscriptionsService) {
	    this.subscriptionsService = subscriptionsService;
	    this.usersService = usersService;
	    this.saasproductsService = saasproductsService;
	    this.subscriptionsstatusService = subscriptionsstatusService;
	    
	}

	@GetMapping
	public String getAllSubscriptionss(Model model) {
	    List<Subscriptions> subscriptionss = subscriptionsService.getAllSubscriptions();
	    List<Users> userss = usersService.getAllUsers();
	    List<SaasProducts> saasproductss = saasproductsService.getAllSaasProducts();
	    List<SubscriptionsStatus> subscriptionsstatuss = subscriptionsstatusService.getAllSubscriptionsStatus();
	    
	    model.addAttribute("subscriptionss", subscriptionss);
	    model.addAttribute("userss", userss);
	    model.addAttribute("saasProductss", saasProductss);
	    model.addAttribute("subscriptionsStatuss", subscriptionsStatuss);
	    
	    return "subscriptionss/list-subscriptions";
	}

	@GetMapping("/create-subscriptions")
	public String returnSubscriptionss(Model model) {
	    List<Users> userss = usersService.getAllUsers();
	    List<SaasProducts> saasproductss = saasproductsService.getAllSaasProducts();
	    List<SubscriptionsStatus> subscriptionsstatuss = subscriptionsstatusService.getAllSubscriptionsStatus();
	    
	    model.addAttribute("userss", userss);
	    model.addAttribute("saasProductss", saasProductss);
	    model.addAttribute("subscriptionsStatuss", subscriptionsStatuss);
	    
	    return "subscriptionss/create-subscriptions";
	}

	@PostMapping
	public String createSubscriptions(@ModelAttribute Subscriptions subscriptions, RedirectAttributes redirectAttributes, Model model) {
	    try {
		    Subscriptions newSubscriptions = subscriptionsService.createSubscriptions(subscriptions);
		    model.addAttribute("newSubscriptions", newSubscriptions);

		    redirectAttributes.addFlashAttribute("success", "subscriptions successfully completed");
	    } catch (Exception e) {
		    redirectAttributes.addFlashAttribute(
		     "error",
		     "An error has occurred during the creation of subscriptions");
	    }

	    return "redirect:/subscriptionss";
	}

	@PostMapping("/{id}")
	public String updateSubscriptions(@PathVariable Long id, @ModelAttribute Subscriptions subscriptions, RedirectAttributes redirectAttributes, Model model) {
	    try {
		    Subscriptions updateSubscriptions = subscriptionsService.updateSubscriptions(id, subscriptions);
		    model.addAttribute("updateSubscriptions", updateSubscriptions);

		    redirectAttributes.addFlashAttribute("success", "subscriptions modify with success");
	    } catch (Exception e) {
		    redirectAttributes.addFlashAttribute(
		     "error",
		     "An error has occurred during the update of subscriptions");
	    }

	    return "redirect:/subscriptionss";
	}

	@PostMapping("/{id}/delete")
	public String deleteSubscriptionsById(@PathVariable Long id, RedirectAttributes redirectAttributes, Model model) {
	    try {
		     subscriptionsService.deleteSubscriptions(id);

		    redirectAttributes.addFlashAttribute("success", "subscriptions has been deleted ");
	    } catch (Exception e) {
		    redirectAttributes.addFlashAttribute(
		     "error",
		     "An error has occurred during the delete of subscriptions");
	    }

	    return "redirect:/subscriptionss";
	}

}



