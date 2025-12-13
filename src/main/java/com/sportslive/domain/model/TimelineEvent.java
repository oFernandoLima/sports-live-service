package com.sportslive.domain.model;

import java.time.Instant;

public record TimelineEvent(
        String id,
        String type,
        String normalizedType,
        Instant timestamp,
        String period,
        String clock,
        String participantId,
        String playerId,
        String playerName,
        String description,
        Object details) {
    public enum NormalizedType {
        GOAL, ASSIST, YELLOW_CARD, RED_CARD, SUBSTITUTION, PENALTY,
        POINT, FOUL, TIMEOUT, QUARTER_END, HALF_END,
        ACE, DOUBLE_FAULT, BREAK_POINT, SET_END, MATCH_END,
        OTHER
    }
}
