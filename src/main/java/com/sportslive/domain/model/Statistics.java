package com.sportslive.domain.model;

import java.util.Map;

public record Statistics(
        String eventId,
        String period,
        Map<String, ParticipantStatistics> participantStats,
        AdvancedStatistics advancedStats,
        CoverageMetadata coverage) {
    public record ParticipantStatistics(
            String participantId,
            String participantName,
            Map<String, Object> stats) {
    }
}
