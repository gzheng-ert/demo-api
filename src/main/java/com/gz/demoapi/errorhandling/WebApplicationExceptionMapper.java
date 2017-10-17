package com.gz.demoapi.errorhandling;

import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

@Provider
public class WebApplicationExceptionMapper implements ExceptionMapper<WebApplicationException> {
    @Override
    public Response toResponse(WebApplicationException e) {
        AppError appError = new AppError(e.getResponse().getStatus(), 9998, e.getMessage(), e.getMessage());
        return Response.status(appError.getStatus())
                .entity(appError)
                .type(MediaType.APPLICATION_JSON)
                .build();
    }
}
