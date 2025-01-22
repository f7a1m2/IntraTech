package labs.intratech.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import labs.intratech.models.Subscriptions;


public interface SubscriptionsRepository extends JpaRepository<Subscriptions, Long> {
}



