package com.microservices.flights.circuitBreaker;

import io.github.resilience4j.bulkhead.annotation.Bulkhead;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.ratelimiter.annotation.RateLimiter;
import io.github.resilience4j.retry.annotation.Retry;
import org.springframework.stereotype.Service;

import java.util.function.Supplier;

@Service
public class CircuitBreakerService {
    private static final String CBFAULTCONFIG = "content-purchase";
    @CircuitBreaker(name = CBFAULTCONFIG)
    @RateLimiter(name = CBFAULTCONFIG)
    @Bulkhead(name = CBFAULTCONFIG)
    @Retry(name = CBFAULTCONFIG)
    public <T> T executeRetrieveContentPurchase(Supplier<T> operation) {
        return operation.get();
    }

}
