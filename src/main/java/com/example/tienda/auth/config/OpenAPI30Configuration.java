package com.example.tienda.auth.config;

import io.swagger.v3.oas.models.OpenAPI;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenAPI30Configuration {

    @Bean
    public OpenAPI customizeOpenAPI(){
        return new OpenAPI();
    }
}
