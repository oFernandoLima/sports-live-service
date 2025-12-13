package com.sportslive.domain.model;

public record CoverageMetadata(
        String level,
        boolean hasTimeline,
        boolean hasAdvancedStats,
        boolean hasPlayerStats,
        boolean hasLineups) {
    public static CoverageMetadata full() {
        return new CoverageMetadata("full", true, true, true, true);
    }

    public static CoverageMetadata basic() {
        return new CoverageMetadata("basic", true, false, false, false);
    }

    public static CoverageMetadata minimal() {
        return new CoverageMetadata("minimal", false, false, false, false);
    }
}
