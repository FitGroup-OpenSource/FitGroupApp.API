package com.fit.fitgroup.membership.controller;

import com.fit.fitgroup.membership.domain.service.MembershipService;
import com.fit.fitgroup.membership.mapping.MembershipMapper;
import com.fit.fitgroup.membership.resource.MembershipResource;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import org.springdoc.api.annotations.ParameterObject;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@SecurityRequirement(name = "fit")
@RestController
@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.POST})
@RequestMapping("/api/membership-plan")
public class MembershipsController {
    private final MembershipService membershipService;
    private final MembershipMapper mapper;

    public MembershipsController(MembershipService membershipService, MembershipMapper mapper) {
        this.membershipService = membershipService;
        this.mapper = mapper;
    }
    @Operation(summary="Get Memberships of a membership plan", description = "Get All Memberships by Pages", tags={"Membership"})

    @GetMapping
    @PreAuthorize("hasRole('USER')")
    public List<MembershipResource> getAllMemberships(@ParameterObject Pageable pageable){
        return mapper.modelListPage(membershipService.getAllMemberships(),pageable).getContent();
    }
    @Operation(summary="Get Membership of a membership plan", description = "Get Membership with determinate value", tags={"Membership"})
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Membership created", content = @Content(mediaType = "application/json"))
    })


    @GetMapping("{membershipId}")
    @PreAuthorize("hasRole('USER')")
    public MembershipResource getMembershipById(@PathVariable Long membershipId) {
        return mapper.toResource(membershipService.getMembershipById(membershipId));
    }

    @Operation(summary="Delete Memberships", description = "Delete Membership by Id", tags={"Membership"})
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Membership deleted", content = @Content(mediaType = "application/json"))
    })
    @DeleteMapping("{membershipId}")
    @PreAuthorize("hasRole('USER')")
    public ResponseEntity<?> deleteMembership(@PathVariable Long membershipId){
        return membershipService.deleteMembership(membershipId);
    }
}
