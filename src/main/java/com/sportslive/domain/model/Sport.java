package com.sportslive.domain.model;

public enum Sport {
    SOCCER("soccer"),
    BASKETBALL("basketball"),
    TENNIS("tennis");

    private final String code;

    Sport(String code) {
        this.code = code;
    }

    public String getCode() {
        return code;
    }

    public static Sport fromCode(String code) {
        for (Sport sport : values()) {
            if (sport.code.equalsIgnoreCase(code)) {
                return sport;
            }
        }
        throw new IllegalArgumentException("Unknown sport: " + code);
    }
}
