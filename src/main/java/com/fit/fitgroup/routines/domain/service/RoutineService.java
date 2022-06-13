package com.fit.fitgroup.routines.domain.service;

import com.fit.fitgroup.routines.domain.model.Routine;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;

import java.awt.print.Pageable;

public interface RoutineService {
    Page<Routine> getAllRoutines(Pageable pageable);
    Routine getRoutineById(Long routineId);
    Routine createRoutine(Routine routine);
    Routine updateRoutine(Long routineId, Routine routineRequest);
    ResponseEntity<?> deleteRoutine(Long routineId);

}
