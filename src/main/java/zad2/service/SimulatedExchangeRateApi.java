package zad2.service;

import zad2.model.ExchangeRateApi;

import java.util.Random;

public class SimulatedExchangeRateApi implements ExchangeRateApi {

    @Override
    public double fetchRate(String currencyFrom, String currencyTo) {
        Random random = new Random();
        double simulatedRate = 0.5 + (1.5 - 0.5) * random.nextDouble();
        return simulatedRate;
    }
}
