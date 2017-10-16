package com.gz.demoapi.errorhandling;

public class AppError {
    private final int status;
    private final int appStatus;
    private final String errorMessage;
    private final String developerMessage;

    public AppError(int status, int appStatus, String errorMessage, String developerMessage) {
        this.status = status;
        this.appStatus = appStatus;
        this.errorMessage = errorMessage;
        this.developerMessage = developerMessage;
    }

    public int getStatus() {
        return status;
    }

    public int getAppStatus() {
        return appStatus;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public String getDeveloperMessage() {
        return developerMessage;
    }
}
