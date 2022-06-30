package com.fit.fitgroup.routines.domain.repository;

import com.fit.fitgroup.routines.domain.model.Exercise;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.List;
@Repository
public interface ExerciseRepository extends JpaRepository<Exercise,Long> {
    List<Exercise> findByRoutineId(Long routineId);

}
