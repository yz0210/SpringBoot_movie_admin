package com.example.SpringBoot_movie_admin.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;


@Configuration
public class config implements WebMvcConfigurer {
    /*public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                .allowedOriginPatterns("*")
                .allowedMethods("GET", "HEAD", "POST", "PUT", "DELETE", "OPTIONS")
                .allowCredentials(true)
                .allowedOrigins("*")
                .maxAge(3600)
                .allowedHeaders("*");
    }*/
}
