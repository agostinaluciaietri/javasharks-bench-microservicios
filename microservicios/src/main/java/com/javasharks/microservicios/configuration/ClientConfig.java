package com.javasharks.microservicios.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ClientConfig {
    @Bean
    public ModelMapper modelMapperBean() {
        return new ModelMapper();
    }

    @Bean
    public RestTemplate restTemplateBean() {
        return new RestTemplate();
    }
}
