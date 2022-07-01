package com.fit.fitgroup.subscriptions.service;

import com.fit.fitgroup.shared.exception.exception.ResourceNotFoundException;
import com.fit.fitgroup.subscriptions.domain.model.Subscription;
import com.fit.fitgroup.subscriptions.domain.repository.SubscriptionRepository;
import com.fit.fitgroup.subscriptions.domain.service.SubscriptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class SubscriptionServiceImpl implements SubscriptionService {
    @Autowired
    private SubscriptionRepository subscriptionRepository;

    @Override
    public Page<Subscription> getAllSubscriptions(Pageable pageable) {

        return subscriptionRepository.findAll((org.springframework.data.domain.Pageable) pageable);
    }

    @Override
    public Subscription getSubscriptionById(Long subscriptionId) {
        return subscriptionRepository.findById(subscriptionId)
                .orElseThrow(() -> new ResourceNotFoundException("Subscription", "Id", subscriptionId));
    }

    @Override
    public Subscription getSubscriptionByDescription(String description) {
        return subscriptionRepository.findByDescription(description)
                .orElseThrow(() -> new ResourceNotFoundException("Subscription", "Description", description));
    }

    @Override
    public Subscription createSubscription(Subscription subscription) {
        return subscriptionRepository.save(subscription);
    }

    @Override
    public Subscription updateSubscription(Long subscriptionId, Subscription subscriptionRequest) {
        Subscription subscription = subscriptionRepository.findById(subscriptionId)
                .orElseThrow(() -> new ResourceNotFoundException("Subscription", "Id", subscriptionId));
        subscription.setDescription(subscriptionRequest.getDescription());
        subscription.setDuration(subscriptionRequest.getDuration());
        return subscriptionRepository.save(subscription);
    }

    @Override
    public ResponseEntity<?> deleteSubscription(Long subscriptionId) {
        Subscription routine = subscriptionRepository.findById(subscriptionId)
                .orElseThrow(() -> new ResourceNotFoundException("Routine", "Id", subscriptionId));
        subscriptionRepository.delete(routine);
        return ResponseEntity.ok().build();
    }
}
