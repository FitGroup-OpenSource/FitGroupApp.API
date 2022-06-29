package com.fit.fitgroup.routines.controller;

import com.fit.fitgroup.routines.domain.model.Exercise;
import com.fit.fitgroup.routines.domain.service.ExerciseService;
import com.fit.fitgroup.routines.resource.ExerciseResource;
import com.fit.fitgroup.routines.resource.SaveExerciseResource;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@SecurityRequirement(name = "fit")
@RestController
@RequestMapping("/api/routines/")
public class ExerciseController {
    @Autowired
    private ExerciseService exerciseService;
    @Autowired
    private ModelMapper mapper;
    @Operation(summary="Get Exercises by determinate Routine Id", description = "Get All Routines by Routine Id", tags={"Exercises"})
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "All Exercises returned", content = @Content(mediaType = "application/json"))
    })
    @GetMapping("{routinesId}/exercises")
    @PreAuthorize("hasRole('USER')")
    public Page<ExerciseResource> getAllExercisesByRoutineId(@PathVariable Long routineId, Pageable pageable){
        Page<Exercise> exercisePage = exerciseService.getAllExercisesByRoutineId(routineId,pageable);
        List<ExerciseResource> resources = exercisePage.getContent().stream().map(
                this::convertToResource).collect(Collectors.toList());
        return new PageImpl<>(resources, pageable, resources.size());
    }
    @Operation(summary="Get Exercises by determinate Id and Routine Id", description = "Get Exercises by Routine Id and Exercises Id", tags={"Exercises"})
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Exercises returned", content = @Content(mediaType = "application/json"))
    })
    @GetMapping("{routinesId}/exercises/{exerciseId}")
    @PreAuthorize("hasRole('USER')")
    public ExerciseResource getExercisesByRoutineId(@PathVariable Long routineId,@PathVariable Long exerciseId ){
        return convertToResource(exerciseService.getExerciseByIdAndRoutineId(exerciseId,routineId));
    }
    private Exercise convertToEntity(SaveExerciseResource resource){
        return mapper.map(resource, Exercise.class);
    }
    private ExerciseResource convertToResource(Exercise entity){
        return mapper.map(entity, ExerciseResource.class);
    }
}
