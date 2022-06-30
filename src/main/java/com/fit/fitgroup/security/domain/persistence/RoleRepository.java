package com.fit.fitgroup.security.domain.persistence;

import com.fit.fitgroup.security.domain.model.enumeration.Roles;
import com.fit.fitgroup.security.domain.model.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {

    Optional<Role> findByName(Roles name);

    boolean existsByName(Roles name);

}