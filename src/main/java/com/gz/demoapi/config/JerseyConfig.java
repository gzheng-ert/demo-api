package com.gz.demoapi.config;

import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.stereotype.Component;

@Component
public class JerseyConfig extends ResourceConfig {
    public JerseyConfig() {
        //packages("com.gzheng.boot.jersey.resource");
        packages("com.gz.demoapi");
    }
}
