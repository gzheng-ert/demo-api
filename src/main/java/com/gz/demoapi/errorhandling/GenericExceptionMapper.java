package com.gz.demoapi.errorhandling;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

@Provider
public class GenericExceptionMapper implements ExceptionMapper<Throwable> {
    @Override
    public Response toResponse(Throwable throwable) {
        AppError appError = new AppError(500, 9999, throwable.getMessage(), throwable.getMessage());
        return Response.status(appError.getStatus())
                .entity(appError)
                .type(MediaType.APPLICATION_JSON)
                .build();
    }
}
