package labs.intratech.services;

import labs.intratech.models.Subscriptions;
import org.springframework.stereotype.Service;
import labs.intratech.repositories.SubscriptionsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;
import java.util.Optional;

@Service
public class SubscriptionsService  {
	private final SubscriptionsRepository subscriptionsRepository;

	@Autowired
	public SubscriptionsService(SubscriptionsRepository subscriptionsRepository) {
	    this.subscriptionsRepository = subscriptionsRepository;
	}

	public List<Subscriptions> getAllSubscriptions() {
	    return subscriptionsRepository.findAll();
	}  

	public Subscriptions getSubscriptionsById(Long id) {
	    Optional<Subscriptions> subscriptions = subscriptionsRepository.findById(id);
	    if (subscriptions.isPresent()) {
	       return subscriptions.get();
	    } else {
	       throw new RuntimeException("Subscriptions not found with id " + id);
	    }
	}

	public Subscriptions createSubscriptions(Subscriptions subscriptions) {
	    return subscriptionsRepository.save(subscriptions);
	}

	public Subscriptions updateSubscriptions(Long id, Subscriptions subscriptions) {
	    Optional<Subscriptions> existingSubscriptions = subscriptionsRepository.findById(id);
	       if (existingSubscriptions.isPresent()) {
		       subscriptions.setSubscriptionsid(id);
	             return subscriptionsRepository.save(subscriptions);
	       } else {
	          throw new RuntimeException("Subscriptions not found with id " + id);
	       }
	}

	public void deleteSubscriptions(Long id) {
	    subscriptionsRepository.deleteById(id);
	}

}



