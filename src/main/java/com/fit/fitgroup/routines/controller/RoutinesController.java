package com.fit.fitgroup.routines.controller;

import com.fit.fitgroup.routines.domain.service.RoutineService;
import com.fit.fitgroup.routines.mapping.RoutineMapper;
import com.fit.fitgroup.routines.resource.RoutineResource;
import com.fit.fitgroup.routines.resource.SaveRoutineResource;
import com.fit.fitgroup.routines.resource.UpdateRoutineResource;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import org.springdoc.api.annotations.ParameterObject;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@SecurityRequirement(name = "fit")
@RestController
@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.POST})
@RequestMapping("/api/routines")
public class RoutinesController {

    private final RoutineService routineService;
    private final RoutineMapper mapper;

    public RoutinesController(RoutineService routineService, RoutineMapper mapper) {
        this.routineService = routineService;
        this.mapper = mapper;
    }


    @Operation(summary="Get Routines", description = "Get All Routines by Pages", tags={"Routines"})

    @GetMapping
    @PreAuthorize("hasRole('USER')")
    public List<RoutineResource> getAllRoutines(@ParameterObject Pageable pageable){
        return mapper.modelListPage(routineService.getAllRoutines(),pageable).getContent();
    }
    @Operation(summary="Post Routines", description = "Post Routine with determinate value", tags={"Routines"})
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Routine created", content = @Content(mediaType = "application/json"))
    })
    @PostMapping
    @PreAuthorize("hasRole('USER')")
    public ResponseEntity<RoutineResource> createRoutine(@Valid @RequestBody SaveRoutineResource resource){
        return new ResponseEntity<>(mapper.toResource(routineService.createRoutine(mapper.toModel(resource))), HttpStatus.CREATED);
    }
    @Operation(summary="Modify Routines", description = "Modify Routine with determinate value", tags={"Routines"})
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Routine modified", content = @Content(mediaType = "application/json"))
    })


    @GetMapping("{routineId}")
    @PreAuthorize("hasRole('USER')")
    public RoutineResource getRoutineById(@PathVariable Long routineId) {
        return mapper.toResource(routineService.getRoutineById(routineId));
    }
    @Operation(tags={"Routines"})
    @PutMapping("{routineId}")
    @PreAuthorize("hasRole('USER')")
    public RoutineResource updateRoutine(@PathVariable Long routineId,@Valid @RequestBody UpdateRoutineResource resource){
        return mapper.toResource(routineService.updateRoutine(routineId,mapper.toModel(resource)));
    }
    @Operation(summary="Delete Routines", description = "Delete Routine by Id", tags={"Routines"})
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Routine deleted", content = @Content(mediaType = "application/json"))
    })
    @DeleteMapping("{routineId}")
    @PreAuthorize("hasRole('USER')")
    public ResponseEntity<?> deleteRoutine(@PathVariable Long routineId){
        return routineService.deleteRoutine(routineId);
    }

}
