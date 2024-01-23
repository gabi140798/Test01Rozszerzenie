package zad2.service;

import lombok.AllArgsConstructor;
import zad2.model.Currency;
import zad2.model.ExchangeRateApi;


@AllArgsConstructor

public class CurrencyService {

        private final CurrencyExchangeCache cache;
        private final ExchangeRateApi api;

        public double exchange(String currencyFrom, String currencyTo, double amount) {
            Currency currency = new Currency(currencyFrom, currencyTo);
            double rate = cache.getOrFetchRate(currency, api);
            return amount * rate;
        }
    }
