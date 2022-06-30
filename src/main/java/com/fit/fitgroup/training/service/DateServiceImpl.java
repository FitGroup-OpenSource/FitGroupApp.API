package com.fit.fitgroup.training.service;

import com.fit.fitgroup.training.domain.model.Date;
import com.fit.fitgroup.training.domain.repository.DateRepository;
import com.fit.fitgroup.training.domain.repository.TrainerRepository;
import com.fit.fitgroup.training.domain.service.DateService;
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
public class DateServiceImpl implements DateService {
    private static final String ENTITY = "Date";

    @Autowired
    private DateRepository dateRepository;



    @Override
    public List<Date> getAllDatesByTrainerId(Long trainerId) {
        return dateRepository.findByTrainerId(trainerId);
    }

    @Override
    public Date getDateById(Long dateId) {
        return dateRepository.findById(dateId)
                .orElseThrow(() -> new ResourceNotFoundException("Date not found with Id " + dateId));
    }


}