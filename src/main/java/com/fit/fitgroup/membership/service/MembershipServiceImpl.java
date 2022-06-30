package com.fit.fitgroup.membership.service;

import com.fit.fitgroup.membership.domain.model.Membership;
import com.fit.fitgroup.membership.domain.repository.MembershipRepository;
import com.fit.fitgroup.membership.domain.service.MembershipService;
import com.fit.fitgroup.shared.exception.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MembershipServiceImpl implements MembershipService {
    private static final String ENTITY = "Membership";
    @Autowired
    private MembershipRepository membershipRepository;
    
    @Override
    public List<Membership> getAllMemberships() {
        return membershipRepository.findAll();
    }

    @Override
    public Membership getMembershipById(Long membershipId) {
        return membershipRepository.findById(membershipId)
                .orElseThrow(()-> new ResourceNotFoundException("Membership","Id",membershipId));
    }

    @Override
    public ResponseEntity<?> deleteMembership(Long membershipId) {
        Membership membership = membershipRepository.findById(membershipId)
                .orElseThrow(() -> new ResourceNotFoundException("Membership", "Id", membershipId));
        membershipRepository.delete(membership);
        return ResponseEntity.ok().build();
    }
}
