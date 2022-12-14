package com.soljit.touzene.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
@Configuration
public class CorsConf {
    @Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/**")
                        .allowedOrigins("*")
                        .allowCredentials(false)
                        .maxAge(3600)
                        .allowedHeaders("Accept", "Content-Type", "Origin",
                                "Authorization", "X-Auth-Token")
                        .exposedHeaders("X-Auth-Token", "Authorization")
                        .allowedMethods("POST", "GET", "DELETE", "PUT", "OPTIONS");
            }
        };
    }
}
