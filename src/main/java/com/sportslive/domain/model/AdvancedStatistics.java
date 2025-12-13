package com.sportslive.domain.model;

import java.util.Map;

public record AdvancedStatistics(
        Sport sport,
        Map<String, Object> metrics,
        boolean available) {
    public static AdvancedStatistics unavailable(Sport sport) {
        return new AdvancedStatistics(sport, Map.of(), false);
    }

    public static AdvancedStatistics of(Sport sport, Map<String, Object> metrics) {
        return new AdvancedStatistics(sport, metrics, true);
    }
}
