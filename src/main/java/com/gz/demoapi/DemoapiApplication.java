package com.gz.demoapi;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
 
@SpringBootApplication
public class DemoapiApplication extends SpringBootServletInitializer
{
    public static void main(String[] args) 
    {
        new DemoapiApplication().configure(new SpringApplicationBuilder(DemoapiApplication.class)).run(args);
    }
    
    
}
