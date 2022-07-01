package com.fit.fitgroup.nutrition.controller;

import com.fit.fitgroup.nutrition.domain.service.FoodService;
import com.fit.fitgroup.nutrition.mapping.FoodMapper;
import com.fit.fitgroup.nutrition.resource.FoodResource;
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
@RequestMapping("/api/nutritional-plan")
public class FoodsController {
    private final FoodService foodService;
    private final FoodMapper mapper;

    public FoodsController(FoodService foodService, FoodMapper mapper) {
        this.foodService = foodService;
        this.mapper = mapper;
    }
    @Operation(summary="Get Foods of a Nutritional plan", description = "Get All Foods by Pages", tags={"Nutrition"})

    @GetMapping
    @PreAuthorize("hasRole('USER')")
    public List<FoodResource> getAllFoods(@ParameterObject Pageable pageable){
        return mapper.modelListPage(foodService.getAllFoods(),pageable).getContent();
    }
    @Operation(summary="Get Food of a nutritional plan", description = "Get Food with determinate value", tags={"Nutrition"})
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Food created", content = @Content(mediaType = "application/json"))
    })


    @GetMapping("{foodId}")
    @PreAuthorize("hasRole('USER')")
    public FoodResource getFoodById(@PathVariable Long foodId) {
        return mapper.toResource(foodService.getFoodById(foodId));
    }

    @Operation(summary="Delete Foods", description = "Delete Food by Id", tags={"Nutrition"})
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Food deleted", content = @Content(mediaType = "application/json"))
    })
    @DeleteMapping("{foodId}")
    @PreAuthorize("hasRole('USER')")
    public ResponseEntity<?> deleteFood(@PathVariable Long foodId){
        return foodService.deleteFood(foodId);
    }
}
