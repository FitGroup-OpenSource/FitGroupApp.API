package com.fit.fitgroup.membership.domain.repository;

import com.fit.fitgroup.membership.domain.model.Membership;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface MembershipRepository extends JpaRepository<Membership, Long> {
    Optional<Membership> findByName(String name);
}
