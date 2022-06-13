package com.fit.fitgroup.routines.resource;

import com.fit.fitgroup.shared.domain.model.AuditModel;

public class RoutineResource extends AuditModel {
    private Long id;
    private String name;
    private Integer rating;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getRating() {
        return rating;
    }

    public void setRating(Integer rating) {
        this.rating = rating;
    }
}