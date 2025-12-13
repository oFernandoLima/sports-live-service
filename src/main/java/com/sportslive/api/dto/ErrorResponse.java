package com.sportslive.api.dto;

import java.time.Instant;

public record ErrorResponse(
        String traceId,
        int status,
        String error,
        String message,
        String providerStatus,
        Instant timestamp) {
    public static ErrorResponse of(String traceId, int status, String error, String message) {
        return new ErrorResponse(traceId, status, error, message, null, Instant.now());
    }

    public static ErrorResponse withProvider(String traceId, int status, String error, String message,
            String providerStatus) {
        return new ErrorResponse(traceId, status, error, message, providerStatus, Instant.now());
    }
}
