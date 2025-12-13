package com.sportslive.domain.model;

public record Competition(
        String id,
        String name,
        String country,
        String season,
        String round) {
}
