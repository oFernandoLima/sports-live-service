package com.sportslive.domain.model;

import java.util.List;

public record Timeline(
        String eventId,
        List<TimelineEvent> events,
        CoverageMetadata coverage) {
}
