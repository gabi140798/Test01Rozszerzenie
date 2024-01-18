package zad2.service;

import zad2.model.Currency;

import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class CurrencyExchangeCache {

    private final ConcurrentHashMap<Currency, Double> rates;
    private final long duration;
    private final ScheduledExecutorService executor;

    public CurrencyExchangeCache(long durationInSeconds) {
        rates = new ConcurrentHashMap<>();
        this.duration = durationInSeconds;
        executor = Executors.newScheduledThreadPool(1);
    }

    public Optional<Double> getRate(Currency currency) {
        return Optional.ofNullable(rates.get(currency));
    }

    public void putRate(Currency currency, Double rate) {
        rates.put(currency, rate);
        executor.schedule(() -> rates.remove(currency), duration, TimeUnit.SECONDS);
    }
}

