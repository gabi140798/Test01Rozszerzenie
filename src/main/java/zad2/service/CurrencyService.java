package zad2.service;

import lombok.AllArgsConstructor;
import zad2.model.Currency;

import java.util.Optional;
import java.util.Random;

@AllArgsConstructor

public class CurrencyService {

    private final CurrencyExchangeCache cache;

    public double exchange(String currencyFrom, String currencyTo, double amount) {
        Currency currency = new Currency(currencyFrom, currencyTo);
        Optional<Double> rate = cache.getRate(currency);

        if (!rate.isPresent()) {
            double fetchedRate = fetchRateFromAPI(currencyFrom, currencyTo);
            cache.putRate(currency, fetchedRate);
            rate = Optional.of(fetchedRate);
        }

        return amount * rate.get();
    }

    private double fetchRateFromAPI(String currencyFrom, String currencyTo) {
        Random random = new Random();
        double simulatedRate = 0.5 + (1.5 - 0.5) * random.nextDouble();

        System.out.println("API Simulation: A course with " + currencyFrom + " at " + currencyTo + " = " + simulatedRate);
        return simulatedRate;
    }
}
