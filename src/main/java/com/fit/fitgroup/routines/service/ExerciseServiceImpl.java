package com.fit.fitgroup.routines.service;

import com.fit.fitgroup.routines.domain.model.Exercise;
import com.fit.fitgroup.routines.domain.repository.ExerciseRepository;
import com.fit.fitgroup.routines.domain.repository.RoutineRepository;
import com.fit.fitgroup.routines.domain.service.ExerciseService;
import com.fit.fitgroup.shared.exception.exception.ResourceNotFoundException;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RestController;


@Service
public class ExerciseServiceImpl implements ExerciseService {

    @Autowired
    private RoutineRepository routineRepository;
    @Autowired
    private ExerciseRepository exerciseRepository;

    @Override
    public Page<Exercise> getAllExercisesByRoutineId(Long routineId, Pageable pageable) {
        return exerciseRepository.findByRoutineId(routineId, pageable);
    }

    @Override
    public Exercise getExerciseByIdAndRoutineId(Long exerciseId, Long routineId) {
        return exerciseRepository.findByIdAndRoutineId(exerciseId, routineId)
                .orElseThrow(() -> new ResourceNotFoundException("Exercise not found with Id " + exerciseId + " and RoutineId " + routineId));
    }

    @Override
    public Exercise createExercise(Long routineId, Exercise exercise) {
        return routineRepository.findById(routineId).map(routine -> {
            exercise.setRoutine(routine);
            return exerciseRepository.save(exercise);
        }).orElseThrow(() -> new ResourceNotFoundException("Routine", "Id", routineId));
    }

    @Override
    public Exercise updateExercise(Long routineId, Long exerciseId, Exercise exerciseDetails) {
        if (!routineRepository.existsById(routineId))
            throw new ResourceNotFoundException("Routine", "Id", routineId);
        return exerciseRepository.findById(exerciseId).map(exercise -> {
                    exercise.setName(exerciseDetails.getName());
                    return exerciseRepository.save(exercise);
                })
                .orElseThrow(() -> new ResourceNotFoundException("Exercise", "Id", exerciseId));
    }

    @Override
    public ResponseEntity<?> deleteExercise(Long routineId, Long exerciseId) {
        if (!routineRepository.existsById(routineId))
            throw new ResourceNotFoundException("Routine", "Id", routineId);
        return exerciseRepository.findById(exerciseId).map(exercise -> {
            exerciseRepository.delete(exercise);
            return ResponseEntity.ok().build();
        }).orElseThrow(() -> new ResourceNotFoundException("Exercise", "Id", exerciseId));

    }
}
