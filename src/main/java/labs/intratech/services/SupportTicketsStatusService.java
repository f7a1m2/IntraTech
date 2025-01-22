package labs.intratech.services;

import labs.intratech.models.SupportTicketsStatus;
import org.springframework.stereotype.Service;
import labs.intratech.repositories.SupportTicketsStatusRepository;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;
import java.util.Optional;

@Service
public class SupportTicketsStatusService  {
	private final SupportTicketsStatusRepository supportTicketsStatusRepository;

	@Autowired
	public SupportTicketsStatusService(SupportTicketsStatusRepository supportTicketsStatusRepository) {
	    this.supportticketsstatusRepository = supportTicketsStatusRepository;
	}

	public List<SupportTicketsStatus> getAllSupportTicketsStatus() {
	    return supportTicketsStatusRepository.findAll();
	}  

	public SupportTicketsStatus getSupportTicketsStatusById(Long id) {
	    Optional<SupportTicketsStatus> supportTicketsStatus = supportTicketsStatusRepository.findById(id);
	    if (supportTicketsStatus.isPresent()) {
	       return supportTicketsStatus.get();
	    } else {
	       throw new RuntimeException("SupportTicketsStatus not found with id " + id);
	    }
	}

	public SupportTicketsStatus createSupportTicketsStatus(SupportTicketsStatus supportTicketsStatus) {
	    return supportTicketsStatusRepository.save(supportTicketsStatus);
	}

	public SupportTicketsStatus updateSupportTicketsStatus(Long id, SupportTicketsStatus supportticketsstatus) {
	    Optional<SupportTicketsStatus> existingSupportTicketsStatus = supportticketsstatusRepository.findById(id);
	       if (existingSupportTicketsStatus.isPresent()) {
		       supportticketsstatus.setSupportTicketsStatusid(id);
	             return supportticketsstatusRepository.save(supportticketsstatus);
	       } else {
	          throw new RuntimeException("SupportTicketsStatus not found with id " + id);
	       }
	}

	public void deleteSupportTicketsStatus(Long id) {
	    supportticketsstatusRepository.deleteById(id);
	}

}



