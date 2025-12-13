package com.sportslive.exception;

public class UnsupportedSportException extends RuntimeException {

    private final String sport;

    public UnsupportedSportException(String sport) {
        super("Unsupported sport: " + sport);
        this.sport = sport;
    }

    public String getSport() {
        return sport;
    }
}
