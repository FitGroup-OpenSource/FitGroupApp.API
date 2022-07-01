package com.fit.fitgroup.routines.domain.service;

import com.fit.fitgroup.routines.domain.model.Routine;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;

import org.springframework.data.domain.Pageable;

import java.util.List;

public interface RoutineService {
    Page<Routine> getAllRoutines(Pageable pageable);
    List<Routine> getAllRoutines();
    Routine getRoutineById(Long routineId);
    Routine getRoutineByName(String name);
    Routine createRoutine(Routine routine);
    Routine updateRoutine(Long routineId, Routine routineRequest);
    ResponseEntity<?> deleteRoutine(Long routineId);

}
