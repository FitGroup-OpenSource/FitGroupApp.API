package com.fit.fitgroup.shared.configuration.configuration;

import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfiguration {
    @Bean(name = "fitgroupOpenApi")
    public OpenAPI fitgroupOpenApi() {
        return new OpenAPI()
                .components(new Components())
                .info(new Info()
                        .title("FitGroup Application API")
                        .description("FitGroup API implemented with Spring Boot RESTful service and documented using springdoc-openapi"));
    }

}
