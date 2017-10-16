package com.gz.demoapi.errorhandling;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

@Provider
public class AppExecptionMapper implements ExceptionMapper<AppException> {
    @Override
    public Response toResponse(AppException appExecption) {
        return Response.status(appExecption.getAppError().getStatus())
                .entity(appExecption.getAppError())
                .type(MediaType.APPLICATION_JSON)
                .build();
    }
}
