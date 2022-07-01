package com.fit.fitgroup.routines.controller;

import com.fit.fitgroup.routines.domain.model.nutritionist;
import com.fit.fitgroup.routines.domain.service.nutritionistService;
import com.fit.fitgroup.routines.resource.nutritionistResource;
import com.fit.fitgroup.routines.resource.SavenutritionistResource;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api")
public class nutritionistController {
    @Autowired
    private nutritionistService nutritionistService;
    @Autowired
    private ModelMapper mapper;
    @Operation(summary="Get nutritionists by determinate Routine Id", description = "Get All Routines by Routine Id", tags={"nutritionists"})
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "All nutritionists returned", content = @Content(mediaType = "application/json"))
    })
    @GetMapping("/routines/{routinesId}/nutritionists")
    public Page<nutritionistResource> getAllnutritionistsByRoutineId(@PathVariable Long routineId, Pageable pageable){
        Page<nutritionist> nutritionistPage = nutritionistService.getAllnutritionistsByRoutineId(routineId,pageable);
        List<nutritionistResource> resources = nutritionistPage.getContent().stream().map(
                this::convertToResource).collect(Collectors.toList());
        return new PageImpl<>(resources, pageable, resources.size());
    }
    @Operation(summary="Get nutritionists by determinate Id and Routine Id", description = "Get nutritionists by Routine Id and nutritionists Id", tags={"nutritionists"})
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "nutritionists returned", content = @Content(mediaType = "application/json"))
    })
    @GetMapping("/routines/{routinesId}/nutritionists/{nutritionistId}")
    public nutritionistResource getnutritionistsByRoutineId(@PathVariable Long routineId,@PathVariable Long nutritionistId ){
        return convertToResource(nutritionistService.getnutritionistByIdAndRoutineId(nutritionistId,routineId));
    }
    private nutritionist convertToEntity(SavenutritionistResource resource){
        return mapper.map(resource, nutritionist.class);
    }
    private nutritionistResource convertToResource(nutritionist entity){
        return mapper.map(entity, nutritionistResource.class);
    }
}
