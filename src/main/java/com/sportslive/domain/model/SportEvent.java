package com.sportslive.domain.model;

import java.time.LocalDateTime;
import java.util.List;

public record SportEvent(
        String id,
        Sport sport,
        EventStatus status,
        Competition competition,
        List<Participant> participants,
        Score score,
        Period currentPeriod,
        LocalDateTime scheduledAt,
        LocalDateTime startedAt,
        Venue venue,
        CoverageMetadata coverage) {
}
