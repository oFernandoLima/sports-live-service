package com.sportslive.adapter;

import com.sportslive.domain.model.*;

public interface SportAdapter {

    Sport getSupportedSport();

    SportEvent getEvent(String eventId);

    Score getScore(String eventId);

    Timeline getTimeline(String eventId);

    Statistics getStatistics(String eventId, StatisticsFilter filter);

    record StatisticsFilter(
            boolean includeAdvanced,
            String period) {
        public static StatisticsFilter basic() {
            return new StatisticsFilter(false, "total");
        }

        public static StatisticsFilter advanced(String period) {
            return new StatisticsFilter(true, period);
        }
    }
}
