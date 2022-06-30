package com.fit.fitgroup.membership.domain.service;

import com.fit.fitgroup.membership.domain.model.Membership;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface MembershipService {
    List<Membership> getAllMemberships();
    Membership getMembershipById(Long membershipId);
    ResponseEntity<?> deleteMembership(Long membershipId);
}
