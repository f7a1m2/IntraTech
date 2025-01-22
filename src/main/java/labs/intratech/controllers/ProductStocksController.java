package labs.intratech.controllers;

import org.springframework.ui.Model;
import labs.intratech.models.*;
import labs.intratech.services.*;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/productstockss")
public class ProductStocksController  {
	private final ProductStocksService productstocksService;
	private final SaasProductsService saasproductsService;
	

	public ProductStocksController(SaasProductsService saasproductsService, ProductStocksService productstocksService) {
	    this.productstocksService = productstocksService;
	    this.saasproductsService = saasproductsService;
	    
	}

	@GetMapping
	public String getAllProductStockss(Model model) {
	    List<ProductStocks> productstockss = productstocksService.getAllProductStocks();
	    List<SaasProducts> saasproductss = saasproductsService.getAllSaasProducts();
	    
	    model.addAttribute("productstockss", productstockss);
	    model.addAttribute("saasProductss", saasproductss);
	    
	    return "productstockss/list-productstocks";
	}

	@GetMapping("/create-productstocks")
	public String returnProductStockss(Model model) {
	    List<SaasProducts> saasproductss = saasproductsService.getAllSaasProducts();
	    
	    model.addAttribute("saasProductss", saasproductss);
	    
	    return "productstockss/create-productstocks";
	}

	@PostMapping
	public String createProductStocks(@ModelAttribute ProductStocks productstocks, RedirectAttributes redirectAttributes, Model model) {
	    try {
		    ProductStocks newProductStocks = productstocksService.createProductStocks(productstocks);
		    model.addAttribute("newProductStocks", newProductStocks);

		    redirectAttributes.addFlashAttribute("success", "productstocks successfully completed");
	    } catch (Exception e) {
		    redirectAttributes.addFlashAttribute(
		     "error",
		     "An error has occurred during the creation of productstocks");
	    }

	    return "redirect:/productstockss";
	}

	@PostMapping("/{id}")
	public String updateProductStocks(@PathVariable Long id, @ModelAttribute ProductStocks productstocks, RedirectAttributes redirectAttributes, Model model) {
	    try {
		    ProductStocks updateProductStocks = productstocksService.updateProductStocks(id, productstocks);
		    model.addAttribute("updateProductStocks", updateProductStocks);

		    redirectAttributes.addFlashAttribute("success", "productstocks modify with success");
	    } catch (Exception e) {
		    redirectAttributes.addFlashAttribute(
		     "error",
		     "An error has occurred during the update of productstocks");
	    }

	    return "redirect:/productstockss";
	}

	@PostMapping("/{id}/delete")
	public String deleteProductStocksById(@PathVariable Long id, RedirectAttributes redirectAttributes, Model model) {
	    try {
		     productstocksService.deleteProductStocks(id);

		    redirectAttributes.addFlashAttribute("success", "productstocks has been deleted ");
	    } catch (Exception e) {
		    redirectAttributes.addFlashAttribute(
		     "error",
		     "An error has occurred during the delete of productstocks");
	    }

	    return "redirect:/productstockss";
	}

}



