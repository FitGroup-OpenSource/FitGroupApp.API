package com.fit.fitgroup.training.domain.service;

import com.fit.fitgroup.training.domain.model.Trainer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface TrainerService {
    Page<Trainer> getAllTrainers(Pageable pageable);
    List<Trainer> getAllTrainers();
    Trainer getTrainerById(Long trainerId);
    Trainer getTrainerByName(String name);
    Trainer createTrainer(Trainer trainer);
    Trainer updateTrainer(Long trainerId, Trainer trainerRequest);
    ResponseEntity<?> deleteTrainer(Long trainerId);

}
