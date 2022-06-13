package com.fit.fitgroup.routines.service;

import com.fit.fitgroup.routines.domain.model.Routine;
import com.fit.fitgroup.routines.domain.repository.RoutineRepository;
import com.fit.fitgroup.routines.domain.service.RoutineService;
import com.fit.fitgroup.routines.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.ResourceAccessException;

import java.awt.print.Pageable;

@Service
public class RoutineServiceImpl implements RoutineService {
    @Autowired
    private RoutineRepository routineRepository;

    @Override
    public Page<Routine> getAllRoutines(Pageable pageable) {

        return routineRepository.findAll((org.springframework.data.domain.Pageable) pageable);
    }

    @Override
    public Routine getRoutineById(Long routineId) {
        return routineRepository.findById(routineId)
                .orElseThrow(() -> new ResourceNotFoundException("Routine", "Id", routineId));
    }

    @Override
    public Routine createRoutine(Routine routine) {
        return routineRepository.save(routine);
    }

    @Override
    public Routine updateRoutine(Long routineId, Routine routineRequest) {
        Routine routine = routineRepository.findById(routineId)
                .orElseThrow(() -> new ResourceNotFoundException("Routine", "Id", routineId));
        routine.setName(routineRequest.getName());
        routine.setRating(routineRequest.getRating());
        return routineRepository.save(routine);
    }

    @Override
    public ResponseEntity<?> deleteRoutine(Long routineId) {
        Routine routine = routineRepository.findById(routineId)
                .orElseThrow(() -> new ResourceNotFoundException("Routine", "Id", routineId));
        routineRepository.delete(routine);
        return ResponseEntity.ok().build();
    }
}
