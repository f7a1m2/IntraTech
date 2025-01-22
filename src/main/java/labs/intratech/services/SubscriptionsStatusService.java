package labs.intratech.services;

import labs.intratech.models.SubscriptionsStatus;
import org.springframework.stereotype.Service;
import labs.intratech.repositories.SubscriptionsStatusRepository;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;
import java.util.Optional;

@Service
public class SubscriptionsStatusService  {
	private final SubscriptionsStatusRepository subscriptionsStatusRepository;

	@Autowired
	public SubscriptionsStatusService(SubscriptionsStatusRepository subscriptionsStatusRepository) {
	    this.subscriptionsstatusRepository = subscriptionsStatusRepository;
	}

	public List<SubscriptionsStatus> getAllSubscriptionsStatus() {
	    return subscriptionsStatusRepository.findAll();
	}  

	public SubscriptionsStatus getSubscriptionsStatusById(Long id) {
	    Optional<SubscriptionsStatus> subscriptionsStatus = subscriptionsStatusRepository.findById(id);
	    if (subscriptionsStatus.isPresent()) {
	       return subscriptionsStatus.get();
	    } else {
	       throw new RuntimeException("SubscriptionsStatus not found with id " + id);
	    }
	}

	public SubscriptionsStatus createSubscriptionsStatus(SubscriptionsStatus subscriptionsStatus) {
	    return subscriptionsStatusRepository.save(subscriptionsStatus);
	}

	public SubscriptionsStatus updateSubscriptionsStatus(Long id, SubscriptionsStatus subscriptionsstatus) {
	    Optional<SubscriptionsStatus> existingSubscriptionsStatus = subscriptionsstatusRepository.findById(id);
	       if (existingSubscriptionsStatus.isPresent()) {
		       subscriptionsstatus.setSubscriptionsStatusid(id);
	             return subscriptionsstatusRepository.save(subscriptionsstatus);
	       } else {
	          throw new RuntimeException("SubscriptionsStatus not found with id " + id);
	       }
	}

	public void deleteSubscriptionsStatus(Long id) {
	    subscriptionsstatusRepository.deleteById(id);
	}

}



