package com.fit.fitgroup.routines.mapping;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration("learningMappingConfiguration")
public class MappingConfiguration {

    @Bean
    public RoutineMapper routineMapper() {
        return new RoutineMapper();
    }

}
