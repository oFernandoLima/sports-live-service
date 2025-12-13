package com.sportslive.domain.model;

import java.util.List;
import java.util.Map;

public record Score(
        Integer home,
        Integer away,
        Map<String, PeriodScore> periodScores,
        String displayScore) {
    public record PeriodScore(
            String periodName,
            Integer home,
            Integer away) {
    }

    public static Score of(int home, int away) {
        return new Score(home, away, Map.of(), home + " - " + away);
    }

    public static Score tennis(List<int[]> sets, int currentGameHome, int currentGameAway) {
        StringBuilder display = new StringBuilder();
        for (int[] set : sets) {
            display.append(set[0]).append("-").append(set[1]).append(" ");
        }
        return new Score(null, null, Map.of(), display.toString().trim());
    }
}
