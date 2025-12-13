package com.sportslive.client;

import com.sportslive.domain.model.Score;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;

@Component
public class LiveScoreClient {

    private static final Logger log = LoggerFactory.getLogger(LiveScoreClient.class);

    private final WebClient webClient;

    public LiveScoreClient(WebClient.Builder builder) {
        this.webClient = builder.baseUrl("http://localhost:8080/v1").build();
    }

    public Score getScore(String sport, String eventId) {
        log.debug("Fetching live score for {}/{}", sport, eventId);
        return webClient.get()
                .uri("/{sport}/events/{eventId}/score", sport, eventId)
                .retrieve()
                .bodyToMono(Score.class)
                .block();
    }

    public void pollLiveScore(String sport, String eventId) {
        try {
            Score score = getScore(sport, eventId);
            log.info("Live score update: {} -> {}", eventId, score.displayScore());
        } catch (Exception e) {
            log.warn("Failed to fetch live score: {}", e.getMessage());
        }
    }
}
