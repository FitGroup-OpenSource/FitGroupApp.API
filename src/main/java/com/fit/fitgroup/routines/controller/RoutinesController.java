package com.fit.fitgroup.routines.controller;

import com.fit.fitgroup.routines.domain.model.Routine;
import com.fit.fitgroup.routines.domain.service.RoutineService;
import com.fit.fitgroup.routines.resource.RoutineResource;
import com.fit.fitgroup.routines.resource.SaveRoutineResource;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api")
public class RoutinesController {

    @Autowired
    private RoutineService routineService;
    @Autowired
    private ModelMapper mapper;

    @Operation(summary="Get Routines", description = "Get All Routines by Pages", tags={"Routines"})
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "All Routines returned", content = @Content(mediaType = "application/json"))
    })
    @GetMapping("/routines")
    public Page<RoutineResource> getAllRoutines(Pageable pageable){
        Page<Routine> routinesPage = routineService.getAllRoutines((java.awt.print.Pageable) pageable);
        List<RoutineResource> resources = routinesPage.getContent()
                .stream()
                .map(this::convertToResource)
                .collect(Collectors.toList());
        return new PageImpl<>(resources,pageable,resources.size());
    }
    @Operation(summary="Post Routines", description = "Post Routine with determinate value", tags={"Routines"})
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Routine created", content = @Content(mediaType = "application/json"))
    })
    @PostMapping("/routines")
    public RoutineResource createRoutine(@Valid @RequestBody SaveRoutineResource resource){
        Routine routine = convertToEntity(resource);
        return convertToResource(routineService.createRoutine(routine));
    }
    @Operation(summary="Modify Routines", description = "Modify Routine with determinate value", tags={"Routines"})
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Routine modified", content = @Content(mediaType = "application/json"))
    })
    @PutMapping("/routines/{routineId}")
    public RoutineResource updateRoutine(@PathVariable Long routineId,@Valid @RequestBody SaveRoutineResource resource){
        Routine routine = convertToEntity(resource);
        return convertToResource(routineService.updateRoutine(routineId, routine));
    }
    @Operation(summary="Delete Routines", description = "Delete Routine by Id", tags={"Routines"})
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Routine deleted", content = @Content(mediaType = "application/json"))
    })
    @DeleteMapping("/routines/{routineId}")
    public ResponseEntity<?> deleteRoutine(@PathVariable Long routineId){
        return routineService.deleteRoutine(routineId);
    }

    private Routine convertToEntity(SaveRoutineResource resource){
        return mapper.map(resource, Routine.class);
    }
    private RoutineResource convertToResource( Routine entity){
        return mapper.map(entity, RoutineResource.class);
    }
}
