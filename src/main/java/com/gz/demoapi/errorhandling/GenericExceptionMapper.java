package com.gz.demoapi.errorhandling;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

@Provider
public class GenericExceptionMapper implements ExceptionMapper<Throwable> {
    private static final Logger log = LoggerFactory.getLogger(GenericExceptionMapper.class);

    @Override
    public Response toResponse(Throwable throwable) {
        //log.info(throwable.toString());
        throwable.printStackTrace();
        AppError appError = new AppError(500, 9999, throwable.getMessage(), throwable.getMessage());
        return Response.status(appError.getStatus())
                .entity(appError)
                .type(MediaType.APPLICATION_JSON)
                .build();
    }
}
