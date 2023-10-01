package com.nekot.achieveme.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class MvcConfig implements WebMvcConfigurer {
  
  @Override
  public void addViewControllers(ViewControllerRegistry registry) {
    registry.addViewController("/error").setViewName("error");
    
    registry.addViewController("/login").setViewName("login");
    registry.addViewController("/signup").setViewName("registration");
  
    registry.addViewController("/main").setViewName("main");
    registry.addViewController("/").setViewName("main");
  
    registry.addViewController("/home").setViewName("home");

  }
}
