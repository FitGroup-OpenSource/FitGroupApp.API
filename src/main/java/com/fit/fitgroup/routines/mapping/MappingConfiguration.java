package com.fit.fitgroup.routines.mapping;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration("fitgroupMappingConfiguration")
public class MappingConfiguration {

    @Bean
    public RoutineMapper routineMapper() {
        return new RoutineMapper();
    }
    @Bean
    public ExerciseMapper exerciseMapper() {
        return new ExerciseMapper();
    }

}
