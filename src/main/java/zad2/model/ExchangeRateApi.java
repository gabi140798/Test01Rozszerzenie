package zad2.model;

public interface ExchangeRateApi {
    double fetchRate(String currencyFrom, String currencyTo);
}
