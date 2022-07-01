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

import java.util.List;


@Service
public class ExerciseServiceImpl implements ExerciseService {
    private static final String ENTITY = "Exercise";

    @Autowired
    private ExerciseRepository exerciseRepository;



    @Override
    public List<Exercise> getAllExercisesByRoutineId(Long routineId) {
        return exerciseRepository.findByRoutineId(routineId);
    }

    @Override
    public Exercise getExerciseById(Long exerciseId) {
        return exerciseRepository.findById(exerciseId)
                .orElseThrow(() -> new ResourceNotFoundException("Exercise not found with Id " + exerciseId));
    }


}
