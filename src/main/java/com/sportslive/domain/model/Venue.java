package com.sportslive.domain.model;

public record Venue(
        String id,
        String name,
        String city,
        String country,
        Integer capacity) {
}
