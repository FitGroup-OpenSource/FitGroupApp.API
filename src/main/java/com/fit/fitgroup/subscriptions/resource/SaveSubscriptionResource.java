package com.fit.fitgroup.subscriptions.resource;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class SaveSubscriptionResource {
    @NotNull
    @NotBlank
    @Size(max = 100)
    private String description;

    @NotNull
    private Integer duration;

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
