package com.fit.fitgroup.nutrition.mapping;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration("fitgroupNutritionMappingConfiguration")
public class MappingConfiguration {

    @Bean
    public FoodMapper foodMapper() {
        return new FoodMapper();
    }

}