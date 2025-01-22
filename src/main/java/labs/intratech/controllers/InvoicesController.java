package labs.intratech.controllers;

import org.springframework.ui.Model;
import labs.intratech.models.*;
import labs.intratech.services.*;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/invoicess")
public class InvoicesController  {
	private final InvoicesService invoicesService;
	private final SubscriptionsService subscriptionsService;
	private final InvoiceStatusService invoicestatusService;
	

	public InvoicesController(SubscriptionsService subscriptionsService,InvoiceStatusService invoicestatusService, InvoicesService invoicesService) {
	    this.invoicesService = invoicesService;
	    this.subscriptionsService = subscriptionsService;
	    this.invoicestatusService = invoicestatusService;
	    
	}

	@GetMapping
	public String getAllInvoicess(Model model) {
	    List<Invoices> invoicess = invoicesService.getAllInvoices();
	    List<Subscriptions> subscriptionss = subscriptionsService.getAllSubscriptions();
	    List<InvoiceStatus> invoicestatuss = invoicestatusService.getAllInvoiceStatus();
	    
	    model.addAttribute("invoicess", invoicess);
	    model.addAttribute("subscriptionss", subscriptionss);
	    model.addAttribute("invoiceStatuss", invoicestatuss);
	    
	    return "invoicess/list-invoices";
	}

	@GetMapping("/create-invoices")
	public String returnInvoicess(Model model) {
	    List<Subscriptions> subscriptionss = subscriptionsService.getAllSubscriptions();
	    List<InvoiceStatus> invoicestatuss = invoicestatusService.getAllInvoiceStatus();
	    
	    model.addAttribute("subscriptionss", subscriptionss);
	    model.addAttribute("invoiceStatuss", invoicestatuss);
	    
	    return "invoicess/create-invoices";
	}

	@PostMapping
	public String createInvoices(@ModelAttribute Invoices invoices, RedirectAttributes redirectAttributes, Model model) {
	    try {
		    Invoices newInvoices = invoicesService.createInvoices(invoices);
		    model.addAttribute("newInvoices", newInvoices);

		    redirectAttributes.addFlashAttribute("success", "invoices successfully completed");
	    } catch (Exception e) {
		    redirectAttributes.addFlashAttribute(
		     "error",
		     "An error has occurred during the creation of invoices");
	    }

	    return "redirect:/invoicess";
	}

	@PostMapping("/{id}")
	public String updateInvoices(@PathVariable Long id, @ModelAttribute Invoices invoices, RedirectAttributes redirectAttributes, Model model) {
	    try {
		    Invoices updateInvoices = invoicesService.updateInvoices(id, invoices);
		    model.addAttribute("updateInvoices", updateInvoices);

		    redirectAttributes.addFlashAttribute("success", "invoices modify with success");
	    } catch (Exception e) {
		    redirectAttributes.addFlashAttribute(
		     "error",
		     "An error has occurred during the update of invoices");
	    }

	    return "redirect:/invoicess";
	}

	@PostMapping("/{id}/delete")
	public String deleteInvoicesById(@PathVariable Long id, RedirectAttributes redirectAttributes, Model model) {
	    try {
		     invoicesService.deleteInvoices(id);

		    redirectAttributes.addFlashAttribute("success", "invoices has been deleted ");
	    } catch (Exception e) {
		    redirectAttributes.addFlashAttribute(
		     "error",
		     "An error has occurred during the delete of invoices");
	    }

	    return "redirect:/invoicess";
	}

}



