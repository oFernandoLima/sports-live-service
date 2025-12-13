package com.sportslive.domain.model;

public record Period(
        String name,
        Integer number,
        String clock,
        boolean isActive) {
    public static Period halftime(int half) {
        return new Period("Half " + half, half, null, false);
    }

    public static Period quarter(int quarter) {
        return new Period("Quarter " + quarter, quarter, null, false);
    }

    public static Period set(int set) {
        return new Period("Set " + set, set, null, false);
    }
}
