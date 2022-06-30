package com.fit.fitgroup.subscriptions.domain.repository;

import com.fit.fitgroup.subscriptions.domain.model.Subscription;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface SubscriptionRepository extends JpaRepository<Subscription, Long> {
    public Optional<Subscription> findByDescription(String description);
}
