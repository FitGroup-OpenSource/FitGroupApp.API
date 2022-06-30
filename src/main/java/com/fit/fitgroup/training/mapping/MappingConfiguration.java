package com.fit.fitgroup.training.mapping;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration("fitgroupTrainingMappingConfiguration")
public class MappingConfiguration {

    @Bean
    public TrainerMapper trainerMapper() {
        return new TrainerMapper();
    }
    @Bean
    public DateMapper dateMapper() {
        return new DateMapper();
    }

}
