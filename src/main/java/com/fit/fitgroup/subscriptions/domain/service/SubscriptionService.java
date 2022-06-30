package com.fit.fitgroup.subscriptions.domain.service;

import com.fit.fitgroup.subscriptions.domain.model.Subscription;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;

import java.awt.print.Pageable;

public interface SubscriptionService {
    Page<Subscription> getAllSubscriptions(Pageable pageable);
    Subscription getSubscriptionById(Long subscriptionId);
    Subscription getSubscriptionByDescription(String description);
    Subscription createSubscription(Subscription subscription);
    Subscription updateSubscription(Long subscriptionId, Subscription subscriptionRequest);
    ResponseEntity<?> deleteSubscription(Long subscriptionId);

}
