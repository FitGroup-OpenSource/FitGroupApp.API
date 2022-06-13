package com.fit.fitgroup.routines.controller;

import com.fit.fitgroup.routines.domain.model.Routine;
import com.fit.fitgroup.routines.domain.service.RoutineService;
import com.fit.fitgroup.routines.resource.RoutineResource;
import com.fit.fitgroup.routines.resource.SaveRoutineResource;
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
    private ModelMapper mapper;

    @GetMapping("/routines")
    public Page<RoutineResource> getAllRoutines(Pageable pageable){
        Page<Routine> routinesPage = routineService.getAllRoutines((java.awt.print.Pageable) pageable);
        List<RoutineResource> resources = routinesPage.getContent()
                .stream()
                .map(this::convertToResource)
                .collect(Collectors.toList());
        return new PageImpl<>(resources,pageable,resources.size());
    }

    @PostMapping("/routines")
    public RoutineResource createRoutine(@Valid @RequestBody SaveRoutineResource resource){
        Routine routine = convertToEntity(resource);
        return convertToResource(routineService.createRoutine(routine));
    }
    @PutMapping("/routines/{routineId}")
    public RoutineResource updateRoutine(@PathVariable Long routineId,@Valid @RequestBody SaveRoutineResource resource){
        Routine routine = convertToEntity(resource);
        return convertToResource(routineService.updateRoutine(routineId, routine));
    }
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
