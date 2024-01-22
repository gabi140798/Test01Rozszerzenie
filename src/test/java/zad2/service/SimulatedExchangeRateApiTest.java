package zad2.service;

import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class SimulatedExchangeRateApiTest {

    @Test
    public void testFetchRateReturnsValidRate() {
        SimulatedExchangeRateApi api = new SimulatedExchangeRateApi();
        double rate = api.fetchRate("EUR", "PLN");

        assertTrue("The exchange rate should be greater than or equal to 0.5", rate >= 0.5);
        assertTrue("The exchange rate should be less than or equal to 1.5", rate <= 1.5);
    }
}