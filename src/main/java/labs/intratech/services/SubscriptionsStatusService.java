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
	public SubscriptionsStatusService(SubscriptionsStatusRepository subscriptionsStatusRepository, SubscriptionsStatusRepository subscriptionsStatusRepository1) {
        this.subscriptionsStatusRepository = subscriptionsStatusRepository1;
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
	    Optional<SubscriptionsStatus> existingSubscriptionsStatus = subscriptionsStatusRepository.findById(id);
	       if (existingSubscriptionsStatus.isPresent()) {
		       subscriptionsstatus.setId(id);
	             return subscriptionsStatusRepository.save(subscriptionsstatus);
	       } else {
	          throw new RuntimeException("SubscriptionsStatus not found with id " + id);
	       }
	}

	public void deleteSubscriptionsStatus(Long id) {
		subscriptionsStatusRepository.deleteById(id);
	}

}



