package com.sportslive.domain.model;

public record Participant(
        String id,
        String name,
        String shortName,
        ParticipantType type,
        String country,
        String logoUrl) {
    public enum ParticipantType {
        TEAM,
        PLAYER
    }
}
