package com.fit.fitgroup.routines.controller;

import com.fit.fitgroup.routines.domain.service.ExerciseService;
import com.fit.fitgroup.routines.mapping.ExerciseMapper;
import com.fit.fitgroup.routines.resource.ExerciseResource;
import com.fit.fitgroup.routines.resource.RoutineResource;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;


@SecurityRequirement(name = "fit")
@RestController
@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.POST})
@RequestMapping("/api/exercises")
public class ExerciseController {
    private final  ExerciseService exerciseService;

    public ExerciseController(ExerciseService exerciseService, ExerciseMapper mapper) {
        this.exerciseService = exerciseService;
        this.mapper = mapper;
    }

    private final ExerciseMapper mapper;
    @Operation(summary="Get Exercises by determinate Routine Id", description = "Get All Routines by Routine Id", tags={"Exercises"})
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "All Exercises returned", content = @Content(mediaType = "application/json"))
    })
    @GetMapping("routines/{routinesId}")
    @PreAuthorize("hasRole('USER')")
    public Page<ExerciseResource> getAllExercisesByRoutineId(@PathVariable Long routinesId, Pageable pageable){
        return mapper.modelListPage(exerciseService.getAllExercisesByRoutineId(routinesId),pageable);
    }
    @Operation(summary="Get Exercises by determinate Id and Routine Id", description = "Get Exercises by Routine Id and Exercises Id", tags={"Exercises"})
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Exercises returned", content = @Content(mediaType = "application/json"))
    })
    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("{exerciseId}")
    @PreAuthorize("hasRole('USER')")
    public ExerciseResource getExerciseById(@PathVariable Long exerciseId) {
        return mapper.toResource(exerciseService.getExerciseById(exerciseId));
    }
}
