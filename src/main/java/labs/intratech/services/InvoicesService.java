package labs.intratech.services;

import labs.intratech.models.Invoices;
import org.springframework.stereotype.Service;
import labs.intratech.repositories.InvoicesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;
import java.util.Optional;

@Service
public class InvoicesService  {
	private final InvoicesRepository invoicesRepository;

	@Autowired
	public InvoicesService(InvoicesRepository invoicesRepository) {
	    this.invoicesRepository = invoicesRepository;
	}

	public List<Invoices> getAllInvoices() {
	    return invoicesRepository.findAll();
	}  

	public Invoices getInvoicesById(Long id) {
	    Optional<Invoices> invoices = invoicesRepository.findById(id);
	    if (invoices.isPresent()) {
	       return invoices.get();
	    } else {
	       throw new RuntimeException("Invoices not found with id " + id);
	    }
	}

	public Invoices createInvoices(Invoices invoices) {
	    return invoicesRepository.save(invoices);
	}

	public Invoices updateInvoices(Long id, Invoices invoices) {
	    Optional<Invoices> existingInvoices = invoicesRepository.findById(id);
	       if (existingInvoices.isPresent()) {
		       invoices.setInvoicesid(id);
	             return invoicesRepository.save(invoices);
	       } else {
	          throw new RuntimeException("Invoices not found with id " + id);
	       }
	}

	public void deleteInvoices(Long id) {
	    invoicesRepository.deleteById(id);
	}

}



