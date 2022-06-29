package com.fit.fitgroup.security.domain.service;

import com.fit.fitgroup.security.domain.model.entity.Role;

import java.util.List;

public interface RoleService {

    void seed();

    List<Role> getAll();
}