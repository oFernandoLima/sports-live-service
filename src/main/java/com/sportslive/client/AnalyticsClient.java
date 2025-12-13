package com.sportslive.client;

import com.sportslive.domain.model.SportEvent;
import com.sportslive.domain.model.Statistics;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;

@Component
public class AnalyticsClient {

    private static final Logger log = LoggerFactory.getLogger(AnalyticsClient.class);

    private final WebClient webClient;

    public AnalyticsClient(WebClient.Builder builder) {
        this.webClient = builder.baseUrl("http://localhost:8080/v1").build();
    }

    public SportEvent getEventDetails(String sport, String eventId) {
        log.debug("Fetching event details for analysis: {}/{}", sport, eventId);
        return webClient.get()
                .uri("/{sport}/events/{eventId}", sport, eventId)
                .retrieve()
                .bodyToMono(SportEvent.class)
                .block();
    }

    public Statistics getAdvancedStatistics(String sport, String eventId, String period) {
        log.debug("Fetching advanced stats for {}/{} period={}", sport, eventId, period);
        return webClient.get()
                .uri(uriBuilder -> uriBuilder
                        .path("/{sport}/events/{eventId}/stats")
                        .queryParam("advanced", true)
                        .queryParam("period", period)
                        .build(sport, eventId))
                .retrieve()
                .bodyToMono(Statistics.class)
                .block();
    }

    public void analyzeMatch(String sport, String eventId) {
        try {
            SportEvent event = getEventDetails(sport, eventId);
            Statistics stats = getAdvancedStatistics(sport, eventId, "total");

            log.info("Match Analysis: {} vs {}",
                    event.participants().get(0).name(),
                    event.participants().get(1).name());

            if (stats.advancedStats() != null && stats.advancedStats().available()) {
                log.info("Advanced metrics available: {}", stats.advancedStats().metrics());
            } else {
                log.info("Advanced metrics not available for this match");
            }
        } catch (Exception e) {
            log.error("Failed to analyze match: {}", e.getMessage());
        }
    }
}
