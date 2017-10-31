package com.gz.demoapi.errorhandling;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

@Provider
public class ConstraintViolationExceptionMapper implements ExceptionMapper<ConstraintViolationException> {
    @Override
    public Response toResponse(ConstraintViolationException e) {
        String msg = "";
        for (ConstraintViolation<?> cv : e.getConstraintViolations()) {
            msg += cv.getMessage() + "; ";
        }
        AppError appError = new AppError(400, 9997, msg, msg);
        return Response.status(appError.getStatus())
                .entity(appError)
                .type(MediaType.APPLICATION_JSON)
                .build();
    }
}
