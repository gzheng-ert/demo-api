package com.gz.demoapi.errorhandling;

public class AppException extends Exception {
    private final AppError appError;

    public AppException(final Throwable cause, final AppError appError) {
        super(cause);
        this.appError = appError;
    }

    public AppError getAppError() {
        return appError;
    }

}
