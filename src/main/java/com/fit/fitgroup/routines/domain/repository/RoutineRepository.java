package com.fit.fitgroup.routines.domain.repository;

import com.fit.fitgroup.routines.domain.model.Routine;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RoutineRepository extends JpaRepository<Routine, Long> {
    Optional<Routine> findByName(String name);
}
