package com.fit.fitgroup.routines.domain.service;

import com.fit.fitgroup.routines.domain.model.Exercise;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;

public interface ExerciseService {
    Page<Exercise> getAllExercisesByRoutineId(Long routineId, Pageable pageable);
    Exercise getExerciseByIdAndRoutineId(Long exerciseId, Long routineId);
    Exercise createExercise(Long routineId, Exercise exercise);
    Exercise updateExercise(Long routineId, Long exerciseId, Exercise exerciseDetails);
    ResponseEntity<?> deleteExercise(Long routineId, Long exerciseId);
}
