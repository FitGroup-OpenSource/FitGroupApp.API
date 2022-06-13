package com.fit.fitgroup.routines.domain.model;

import com.fit.fitgroup.shared.domain.model.AuditModel;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name="routines")
public class Routine extends AuditModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    private String name;

    @NotNull
    private Integer rating;

    public Routine() {
    }

    public Routine(String name, Integer rating) {
        this.name = name;
        this.rating = rating;
    }

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
