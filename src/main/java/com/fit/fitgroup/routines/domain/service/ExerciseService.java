package com.fit.fitgroup.routines.domain.service;

import com.fit.fitgroup.routines.domain.model.Exercise;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import java.util.List;
public interface ExerciseService {
    List<Exercise> getAllExercisesByRoutineId(Long routineId);
    Exercise getExerciseById(Long exerciseId);
}
