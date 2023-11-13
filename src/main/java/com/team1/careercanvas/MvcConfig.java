package com.team1.careercanvas;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.io.File;

@Configuration
public class MvcConfig implements WebMvcConfigurer {
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        String projectDir = new File("").getAbsolutePath();
        registry.addResourceHandler("/upload/**")
                .addResourceLocations("file:" + projectDir + "/upload/");
    }
}