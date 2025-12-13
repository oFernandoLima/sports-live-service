package com.sportslive.exception;

public class ExternalServiceException extends RuntimeException {

    private final String providerStatus;

    public ExternalServiceException(String message, String providerStatus) {
        super(message);
        this.providerStatus = providerStatus;
    }

    public ExternalServiceException(String message, String providerStatus, Throwable cause) {
        super(message, cause);
        this.providerStatus = providerStatus;
    }

    public String getProviderStatus() {
        return providerStatus;
    }
}
