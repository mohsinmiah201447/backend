package com.isdbbros.realestate;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.security.core.context.SecurityContextHolder;

@SpringBootApplication
public class RealEstateApplication {

    public static ApplicationContext context;
    public static void main(String[] args) {
        context = SpringApplication.run(RealEstateApplication.class, args);
    }

    public static String getCurrentUsername(){
        return SecurityContextHolder.getContext().getAuthentication().getName();
    }
}
