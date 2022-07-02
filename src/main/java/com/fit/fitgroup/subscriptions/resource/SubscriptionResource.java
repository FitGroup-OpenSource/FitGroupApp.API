package com.fit.fitgroup.subscriptions.resource;

import com.fit.fitgroup.shared.domain.model.AuditModel;

public class SubscriptionResource extends AuditModel {
    private Long id;
    private String description;
    private Integer duration;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getDuration() {
        return duration;
    }

    public void setDuration(Integer duration) {
        this.duration = duration;
    }
}
