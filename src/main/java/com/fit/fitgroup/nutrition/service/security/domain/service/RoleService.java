package com.fit.fitgroup.nutrition.service.security.domain.service;

import com.fit.fitgroup.nutrition.service.security.domain.model.entity.Role;

import java.util.List;

public interface RoleService {

    void seed();

    List<Role> getAll();
}