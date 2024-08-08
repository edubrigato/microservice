package br.com.seguros.infrastructure.configuration;

import org.springdoc.core.models.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {

    @Bean
    public GroupedOpenApi apiV1() {
        return GroupedOpenApi.builder()
                .group("v1")
                .packagesToScan("br.com.seguros.infrastructure.controller")
                .pathsToMatch("/**")
                .build();
    }
}
