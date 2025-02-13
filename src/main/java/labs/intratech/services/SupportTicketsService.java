package labs.intratech.services;

import labs.intratech.models.SupportTickets;
import org.springframework.stereotype.Service;
import labs.intratech.repositories.SupportTicketsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;
import java.util.Optional;

@Service
public class SupportTicketsService  {
	private final SupportTicketsRepository supportTicketsRepository;

	@Autowired
	public SupportTicketsService(SupportTicketsRepository supportTicketsRepository, SupportTicketsRepository supportTicketsRepository1) {
        this.supportTicketsRepository = supportTicketsRepository1;
	}

	public List<SupportTickets> getAllSupportTickets() {
	    return supportTicketsRepository.findAll();
	}  

	public SupportTickets getSupportTicketsById(Long id) {
	    Optional<SupportTickets> supportTickets = supportTicketsRepository.findById(id);
	    if (supportTickets.isPresent()) {
	       return supportTickets.get();
	    } else {
	       throw new RuntimeException("SupportTickets not found with id " + id);
	    }
	}

	public SupportTickets createSupportTickets(SupportTickets supportTickets) {
	    return supportTicketsRepository.save(supportTickets);
	}

	public SupportTickets updateSupportTickets(Long id, SupportTickets supporttickets) {
	    Optional<SupportTickets> existingSupportTickets = supportTicketsRepository.findById(id);
	       if (existingSupportTickets.isPresent()) {
		       supporttickets.setId(id);
	             return supportTicketsRepository.save(supporttickets);
	       } else {
	          throw new RuntimeException("SupportTickets not found with id " + id);
	       }
	}

	public void deleteSupportTickets(Long id) {
		supportTicketsRepository.deleteById(id);
	}

}



