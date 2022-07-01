package com.fit.fitgroup.training.resource;

import com.fit.fitgroup.shared.domain.model.AuditModel;

public class TrainerResource extends AuditModel {
    private Long id;
    private String name;
    private Integer year;

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

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }
}