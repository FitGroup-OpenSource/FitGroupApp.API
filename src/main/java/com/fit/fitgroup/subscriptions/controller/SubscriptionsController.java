package com.fit.fitgroup.subscriptions.controller;

import com.fit.fitgroup.subscriptions.domain.model.Subscription;
import com.fit.fitgroup.subscriptions.domain.service.SubscriptionService;
import com.fit.fitgroup.subscriptions.resource.SaveSubscriptionResource;
import com.fit.fitgroup.subscriptions.resource.SubscriptionResource;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@SecurityRequirement(name = "fit")
@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.POST})
@RestController
@RequestMapping("/api")
public class SubscriptionsController {

    @Autowired
    private SubscriptionService subscriptionService;
    @Autowired
    private ModelMapper mapper;

    public SubscriptionsController(SubscriptionService subscriptionService, ModelMapper mapper) {
        this.subscriptionService = subscriptionService;
        this.mapper = mapper;
    }

    @Operation(summary="Get Subscriptions", description = "Get All Subscriptions by Pages", tags={"Subscriptions"})
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "All Subscriptions returned", content = @Content(mediaType = "application/json"))
    })
    @GetMapping("/subscriptions")
    public Page<SubscriptionResource> getAllSubscriptions(Pageable pageable){
        Page<Subscription> subscriptionsPage = subscriptionService.getAllSubscriptions((org.springframework.data.domain.Pageable) pageable);
        List<SubscriptionResource> resources = subscriptionsPage.getContent()
                .stream()
                .map(this::convertToResource)
                .collect(Collectors.toList());
        return new PageImpl<>(resources,pageable,resources.size());
    }
    @Operation(summary="Post Subscriptions", description = "Post Subscription with determinate value", tags={"Subscriptions"})
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Subscription created", content = @Content(mediaType = "application/json"))
    })
    @PostMapping("/subscriptions")
    public SubscriptionResource createSubscription(@Valid @RequestBody SaveSubscriptionResource resource){
        Subscription subscription = convertToEntity(resource);
        return convertToResource(subscriptionService.createSubscription(subscription));
    }
    @Operation(summary="Modify Subscriptions", description = "Modify Subscription with determinate value", tags={"Subscriptions"})
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Subscription modified", content = @Content(mediaType = "application/json"))
    })
    @PutMapping("/subscriptions/{subscriptionId}")
    public SubscriptionResource updateSubscription(@PathVariable Long subscriptionId,@Valid @RequestBody SaveSubscriptionResource resource){
        Subscription subscription = convertToEntity(resource);
        return convertToResource(subscriptionService.updateSubscription(subscriptionId, subscription));
    }
    @Operation(summary="Delete Subscriptions", description = "Delete Subscription by Id", tags={"Subscriptions"})
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Subscription deleted", content = @Content(mediaType = "application/json"))
    })
    @DeleteMapping("/subscriptions/{subscriptionId}")
    public ResponseEntity<?> deleteSubscription(@PathVariable Long subscriptionId){
        return subscriptionService.deleteSubscription(subscriptionId);
    }

    private Subscription convertToEntity(SaveSubscriptionResource resource){
        return mapper.map(resource, Subscription.class);
    }
    private SubscriptionResource convertToResource( Subscription entity){
        return mapper.map(entity, SubscriptionResource.class);
    }
}