package labs.intratech.services;

import labs.intratech.models.InvoiceStatus;
import org.springframework.stereotype.Service;
import labs.intratech.repositories.InvoiceStatusRepository;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;
import java.util.Optional;

@Service
public class InvoiceStatusService  {
	private final InvoiceStatusRepository invoiceStatusRepository;

	@Autowired
	public InvoiceStatusService(InvoiceStatusRepository invoiceStatusRepository) {
	    this.invoicestatusRepository = invoiceStatusRepository;
	}

	public List<InvoiceStatus> getAllInvoiceStatus() {
	    return invoiceStatusRepository.findAll();
	}  

	public InvoiceStatus getInvoiceStatusById(Long id) {
	    Optional<InvoiceStatus> invoiceStatus = invoiceStatusRepository.findById(id);
	    if (invoiceStatus.isPresent()) {
	       return invoiceStatus.get();
	    } else {
	       throw new RuntimeException("InvoiceStatus not found with id " + id);
	    }
	}

	public InvoiceStatus createInvoiceStatus(InvoiceStatus invoiceStatus) {
	    return invoiceStatusRepository.save(invoiceStatus);
	}

	public InvoiceStatus updateInvoiceStatus(Long id, InvoiceStatus invoicestatus) {
	    Optional<InvoiceStatus> existingInvoiceStatus = invoicestatusRepository.findById(id);
	       if (existingInvoiceStatus.isPresent()) {
		       invoicestatus.setInvoiceStatusid(id);
	             return invoicestatusRepository.save(invoicestatus);
	       } else {
	          throw new RuntimeException("InvoiceStatus not found with id " + id);
	       }
	}

	public void deleteInvoiceStatus(Long id) {
	    invoicestatusRepository.deleteById(id);
	}

}



