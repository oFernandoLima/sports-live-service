# SportsLiveService

Microserviço para consumo da Sportradar API com exposição de API unificada para dados esportivos.

## Esportes Suportados

- ⚽ Soccer
- 🏀 Basketball
- 🎾 Tennis

## Executar

```bash
# Definir API Key
export SPORTRADAR_API_KEY=your-api-key

# Executar
mvn spring-boot:run
```

## Endpoints

| Método | Endpoint                                                        | Descrição             |
| ------ | --------------------------------------------------------------- | --------------------- |
| GET    | `/v1/{sport}/events/{eventId}`                                  | Detalhes do evento    |
| GET    | `/v1/{sport}/events/{eventId}/score`                            | Placar atual          |
| GET    | `/v1/{sport}/events/{eventId}/timeline`                         | Timeline/play-by-play |
| GET    | `/v1/{sport}/events/{eventId}/stats?advanced=true&period=total` | Estatísticas          |

## Swagger

Acesse: http://localhost:8080/swagger-ui.html

## Arquitetura

```
┌─────────────────────────────────────────────────────────┐
│                    SportsLiveService                     │
├─────────────────────────────────────────────────────────┤
│  API Layer (Controllers)                                │
│    └── /v1/{sport}/events/{eventId}/*                   │
├─────────────────────────────────────────────────────────┤
│  Service Layer (EventService)                           │
│    └── Roteamento + Cache                               │
├─────────────────────────────────────────────────────────┤
│  Adapter Layer                                          │
│    ├── SoccerAdapter                                    │
│    ├── BasketballAdapter                                │
│    └── TennisAdapter                                    │
├─────────────────────────────────────────────────────────┤
│  Infrastructure (SportradarClient)                      │
│    └── Resilience4j (Circuit Breaker + Retry)          │
└─────────────────────────────────────────────────────────┘
```

## Resiliência

- Circuit Breaker: 50% failure rate threshold
- Retry: 3 tentativas com backoff exponencial
- Timeout: 10 segundos
