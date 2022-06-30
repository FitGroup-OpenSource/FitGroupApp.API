package com.fit.fitgroup.training.domain.service;

import com.fit.fitgroup.training.domain.model.Date;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import java.util.List;
public interface DateService {
    List<Date> getAllDatesByTrainerId(Long trainerId);
    Date getDateById(Long dateId);
}
