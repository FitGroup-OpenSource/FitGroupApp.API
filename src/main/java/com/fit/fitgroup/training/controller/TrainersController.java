package com.fit.fitgroup.training.controller;
import com.fit.fitgroup.training.domain.service.TrainerService;
import com.fit.fitgroup.training.mapping.TrainerMapper;
import com.fit.fitgroup.training.resource.TrainerResource;
import com.fit.fitgroup.training.resource.SaveTrainerResource;
import com.fit.fitgroup.training.resource.UpdateTrainerResource;
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

@SecurityRequirement(name = "fit")
@RestController
@RequestMapping("/api/trainers")
public class TrainersController {

    private final TrainerService trainerService;
    private final TrainerMapper mapper;

    public TrainersController(TrainerService trainerService, TrainerMapper mapper) {
        this.trainerService = trainerService;
        this.mapper = mapper;
    }

    @Operation(summary="Get Trainers", description = "Get All Trainers by Pages", tags={"Dates"})

    @GetMapping
    @PreAuthorize("hasRole('USER')")
    public Page<TrainerResource> getAllTrainers(@ParameterObject Pageable pageable){
        return mapper.modelListPage(trainerService.getAllTrainers(),pageable);
    }
    @Operation(summary="Post Trainers", description = "Post Trainer with determinate value", tags={"Dates"})
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Trainer created", content = @Content(mediaType = "application/json"))
    })
    @PostMapping
    @PreAuthorize("hasRole('USER')")
    public ResponseEntity<TrainerResource> createTrainer(@Valid @RequestBody SaveTrainerResource resource){
        return new ResponseEntity<>(mapper.toResource(trainerService.createTrainer(mapper.toModel(resource))), HttpStatus.CREATED);
    }
    @Operation(summary="Modify Trainers", description = "Modify Trainer with determinate value", tags={"Dates"})
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Trainer modified", content = @Content(mediaType = "application/json"))
    })


    @GetMapping("{trainerId}")
    @PreAuthorize("hasRole('USER')")
    public TrainerResource getTrainerById(@PathVariable Long trainerId) {
        return mapper.toResource(trainerService.getTrainerById(trainerId));
    }
    @Operation(tags={"Dates"})
    @PutMapping("{trainerId}")
    @PreAuthorize("hasRole('USER')")
    public TrainerResource updateTrainer(@PathVariable Long trainerId,@Valid @RequestBody UpdateTrainerResource resource){
        return mapper.toResource(trainerService.updateTrainer(trainerId,mapper.toModel(resource)));
    }
    @Operation(summary="Delete Trainers", description = "Delete Trainer by Id", tags={"Trainers"})
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Trainer deleted", content = @Content(mediaType = "application/json"))
    })
    @DeleteMapping("{trainerId}")
    @PreAuthorize("hasRole('USER')")
    public ResponseEntity<?> deleteTrainer(@PathVariable Long trainerId){
        return trainerService.deleteTrainer(trainerId);
    }

}