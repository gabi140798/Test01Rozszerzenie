package zad2.service;

import lombok.AllArgsConstructor;
import zad2.model.Currency;
import zad2.model.ExchangeRateApi;

import java.util.Optional;


@AllArgsConstructor

public class CurrencyService {

    private final CurrencyExchangeCache cache;
    private final ExchangeRateApi api;

    public double exchange(String currencyFrom, String currencyTo, double amount) {
        Currency currency = new Currency(currencyFrom, currencyTo);
        Optional<Double> rate = cache.getRate(currency);

        if (!rate.isPresent()) {
            double fetchedRate = api.fetchRate(currencyFrom, currencyTo);
            cache.putRate(currency, fetchedRate);
            rate = Optional.of(fetchedRate);
        }

        return amount * rate.get();
    }
}
