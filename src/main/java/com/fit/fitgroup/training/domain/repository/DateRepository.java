package com.fit.fitgroup.training.domain.repository;

import com.fit.fitgroup.training.domain.model.Date;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.List;
@Repository
public interface DateRepository extends JpaRepository<Date,Long> {
    List<Date> findByTrainerId(Long trainerId);

}
