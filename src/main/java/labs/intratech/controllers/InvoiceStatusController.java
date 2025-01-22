package labs.intratech.controllers;

import org.springframework.ui.Model;
import labs.intratech.models.*;
import labs.intratech.services.*;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/invoicestatuss")
public class InvoiceStatusController  {
	private final InvoiceStatusService invoicestatusService;
	

	public InvoiceStatusController( InvoiceStatusService invoicestatusService) {
	    this.invoicestatusService = invoicestatusService;
	    
	}

	@GetMapping
	public String getAllInvoiceStatuss(Model model) {
	    List<InvoiceStatus> invoicestatuss = invoicestatusService.getAllInvoiceStatus();
	    
	    model.addAttribute("invoicestatuss", invoicestatuss);
	    
	    return "invoicestatuss/list-invoicestatus";
	}

	@GetMapping("/create-invoicestatus")
	public String returnInvoiceStatuss(Model model) {
	    
	    
	    return "invoicestatuss/create-invoicestatus";
	}

	@PostMapping
	public String createInvoiceStatus(@ModelAttribute InvoiceStatus invoicestatus, RedirectAttributes redirectAttributes, Model model) {
	    try {
		    InvoiceStatus newInvoiceStatus = invoicestatusService.createInvoiceStatus(invoicestatus);
		    model.addAttribute("newInvoiceStatus", newInvoiceStatus);

		    redirectAttributes.addFlashAttribute("success", "invoicestatus successfully completed");
	    } catch (Exception e) {
		    redirectAttributes.addFlashAttribute(
		     "error",
		     "An error has occurred during the creation of invoicestatus");
	    }

	    return "redirect:/invoicestatuss";
	}

	@PostMapping("/{id}")
	public String updateInvoiceStatus(@PathVariable Long id, @ModelAttribute InvoiceStatus invoicestatus, RedirectAttributes redirectAttributes, Model model) {
	    try {
		    InvoiceStatus updateInvoiceStatus = invoicestatusService.updateInvoiceStatus(id, invoicestatus);
		    model.addAttribute("updateInvoiceStatus", updateInvoiceStatus);

		    redirectAttributes.addFlashAttribute("success", "invoicestatus modify with success");
	    } catch (Exception e) {
		    redirectAttributes.addFlashAttribute(
		     "error",
		     "An error has occurred during the update of invoicestatus");
	    }

	    return "redirect:/invoicestatuss";
	}

	@PostMapping("/{id}/delete")
	public String deleteInvoiceStatusById(@PathVariable Long id, RedirectAttributes redirectAttributes, Model model) {
	    try {
		     invoicestatusService.deleteInvoiceStatus(id);

		    redirectAttributes.addFlashAttribute("success", "invoicestatus has been deleted ");
	    } catch (Exception e) {
		    redirectAttributes.addFlashAttribute(
		     "error",
		     "An error has occurred during the delete of invoicestatus");
	    }

	    return "redirect:/invoicestatuss";
	}

}



