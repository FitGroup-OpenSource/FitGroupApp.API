package com.fit.fitgroup.subscriptions.domain.model;

import com.fit.fitgroup.shared.domain.model.AuditModel;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name="subscriptions")
public class Subscription extends AuditModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    private String description;

    @NotNull
    private Integer duration;

    public Subscription() {
    }

    public Subscription(String description, Integer duration) {
        this.description = description;
        this.duration = duration;
    }

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
