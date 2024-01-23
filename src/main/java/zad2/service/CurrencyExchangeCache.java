package zad2.service;

import zad2.model.Currency;
import zad2.model.ExchangeRateApi;

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

    public double getOrFetchRate(Currency currency, ExchangeRateApi api) {
        return rates.computeIfAbsent(currency, key -> {
            double fetchedRate = api.fetchRate(key.getCurrencyFrom(), key.getCurrencyTo());
            executor.schedule(() -> rates.remove(key), duration, TimeUnit.SECONDS);
            return fetchedRate;
        });
    }
}


