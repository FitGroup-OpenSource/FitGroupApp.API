package com.fit.fitgroup.training.service;

import com.fit.fitgroup.training.domain.model.Trainer;
import com.fit.fitgroup.training.domain.repository.TrainerRepository;
import com.fit.fitgroup.training.domain.service.TrainerService;
import com.fit.fitgroup.shared.exception.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import org.springframework.data.domain.Pageable;

import java.util.List;

@Service
public class TrainerServiceImpl implements TrainerService {
    private static final String ENTITY = "Trainer";
    @Autowired
    private TrainerRepository trainerRepository;

    public Page<Trainer> getAllTrainers(Pageable pageable) {

        return trainerRepository.findAll( pageable);
    }

    @Override
    public List<Trainer> getAllTrainers() {
        return trainerRepository.findAll();
    }

    @Override
    public Trainer getTrainerById(Long trainerId) {
        return trainerRepository.findById(trainerId)
                .orElseThrow(() -> new ResourceNotFoundException("Trainer", "Id", trainerId));
    }

    @Override
    public Trainer getTrainerByName(String name) {
        return trainerRepository.findByName(name)
                .orElseThrow(() -> new ResourceNotFoundException("Trainer", "Name", name));
    }

    @Override
    public Trainer createTrainer(Trainer trainer) {
        return trainerRepository.save(trainer);
    }

    @Override
    public Trainer updateTrainer(Long trainerId, Trainer trainerRequest) {
        Trainer trainer = trainerRepository.findById(trainerId)
                .orElseThrow(() -> new ResourceNotFoundException("Trainer", "Id", trainerId));
        trainer.setName(trainerRequest.getName());
        trainer.setYear(trainerRequest.getYear());
        return trainerRepository.save(trainer);
    }

    @Override
    public ResponseEntity<?> deleteTrainer(Long trainerId) {
        Trainer trainer = trainerRepository.findById(trainerId)
                .orElseThrow(() -> new ResourceNotFoundException("Trainer", "Id", trainerId));
        trainerRepository.delete(trainer);
        return ResponseEntity.ok().build();
    }
}
