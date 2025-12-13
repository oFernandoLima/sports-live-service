package com.sportslive.config;

import com.sportslive.adapter.SportAdapter;
import com.sportslive.domain.model.Sport;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

@Configuration
public class AdapterConfig {

    @Bean
    public Map<String, SportAdapter> sportAdapters(List<SportAdapter> adapters) {
        return adapters.stream()
                .collect(Collectors.toMap(
                        adapter -> adapter.getSupportedSport().getCode(),
                        Function.identity()));
    }
}
