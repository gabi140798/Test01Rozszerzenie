package zad2.service;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import zad2.model.ExchangeRateApi;

import java.util.concurrent.TimeUnit;

import static org.junit.Assert.*;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.verify;

public class CurrencyServiceTest {

    private CurrencyExchangeCache cache;
    private ExchangeRateApi mock;
    private CurrencyService service;
    private final long cacheDuration = 10;

    @Before
    public void init() {
        cache = new CurrencyExchangeCache(cacheDuration);
        mock = Mockito.mock(ExchangeRateApi.class);
        service = new CurrencyService(cache, mock);
    }

    @Test
    public void testExchangeRate() {
        when(mock.fetchRate("PLN", "EUR")).thenReturn(0.85);
        double exchangedAmount = service.exchange("PLN", "EUR", 100);
        assertEquals(85.0, exchangedAmount, 0.001);
    }

    @Test
    public void testExchangeRateCaching() {
        when(mock.fetchRate("PLN", "EUR")).thenReturn(0.85);

        service.exchange("PLN", "EUR", 100);
        service.exchange("PLN", "EUR", 100);

        verify(mock, times(1)).fetchRate("PLN", "EUR");
    }

    @Test
    public void testCacheExpiration() throws InterruptedException {
        when(mock.fetchRate("PLN", "EUR")).thenReturn(0.85).thenReturn(0.86);

        service.exchange("PLN", "EUR", 100);
        TimeUnit.SECONDS.sleep(cacheDuration + 1);
        service.exchange("PLN", "EUR", 100);

        verify(mock, times(2)).fetchRate("PLN", "EUR");
    }
}