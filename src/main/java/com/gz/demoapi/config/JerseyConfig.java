package com.gz.demoapi.config;

import com.gz.demoapi.errorhandling.AppExecptionMapper;
import com.gz.demoapi.errorhandling.ConstraintViolationExceptionMapper;
import com.gz.demoapi.errorhandling.GenericExceptionMapper;
import com.gz.demoapi.errorhandling.WebApplicationExceptionMapper;
import com.gz.demoapi.resource.ThingResource;
import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.stereotype.Component;

@Component
public class JerseyConfig extends ResourceConfig {
    public JerseyConfig() {
        //packages("com.gz.demoapi");  //this won't work with Spring Boot 1.4+.
        register(ThingResource.class);
        register(AppExecptionMapper.class);
        register(GenericExceptionMapper.class);
        register(WebApplicationExceptionMapper.class);
        register(ConstraintViolationExceptionMapper.class);
    }
}
