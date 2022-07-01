package com.fit.fitgroup.training.controller;

import com.fit.fitgroup.training.domain.service.DateService;
import com.fit.fitgroup.training.mapping.DateMapper;
import com.fit.fitgroup.training.resource.DateResource;
import com.fit.fitgroup.training.resource.TrainerResource;
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
@RequestMapping("/api/dates")
public class DateController {
    private final  DateService dateService;

    public DateController(DateService dateService, DateMapper mapper) {
        this.dateService = dateService;
        this.mapper = mapper;
    }

    private final DateMapper mapper;
    @Operation(summary="Get Dates by determinate Trainer Id", description = "Get All Dates by Routine Id", tags={"Dates"})
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "All Dates returned", content = @Content(mediaType = "application/json"))
    })
    @GetMapping("trainers/{trainersId}")
    @PreAuthorize("hasRole('USER')")
    public Page<DateResource> getAllDatesByTrainerId(@PathVariable Long trainersId, Pageable pageable){
        return mapper.modelListPage(dateService.getAllDatesByTrainerId(trainersId),pageable);
    }
    @Operation(summary="Get Dates by determinate Id and Trainer Id", description = "Get Dates by Trainer Id and Dates Id", tags={"Dates"})
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Dates returned", content = @Content(mediaType = "application/json"))
    })
    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("{dateId}")
    @PreAuthorize("hasRole('USER')")
    public DateResource getDatesById(@PathVariable Long dateId) {
        return mapper.toResource(dateService.getDateById(dateId));
    }
}
