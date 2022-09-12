package com.example.kanban.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class CorsConfigurer implements WebMvcConfigurer {
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                .allowedOriginPatterns("*")
                .allowedOrigins("http://kanban.sad-waterdeer.com", "https://kanban.sad-waterdeer.com")
                .allowedMethods(RequestMethod.GET.name(),
                        RequestMethod.POST.name(),
                        RequestMethod.PUT.name(),
                        RequestMethod.DELETE.name(),
                        RequestMethod.OPTIONS.name())
                .allowedHeaders("*").maxAge(3600)
                .allowCredentials(true);
    }
}
