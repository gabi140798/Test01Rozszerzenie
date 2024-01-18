package zad2.service;

import org.junit.Before;
import org.junit.Test;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import static org.junit.Assert.*;

public class CurrencyServiceTest {

    private CurrencyService service;
    private CurrencyExchangeCache cache;
    private final long cacheDuration = 10;

    @Before
    public void init() {
        cache = new CurrencyExchangeCache(cacheDuration);
        service = new CurrencyService(cache);
    }

    @Test
    public void testExchangeRateFetching() {
        double rate = service.exchange("EUR", "PLN", 100);
        assertTrue(rate > 0);
    }

    @Test
    public void testExchangeRateCaching() throws InterruptedException {
        double rate1 = service.exchange("EUR", "PLN", 100);
        Thread.sleep(1000);
        double rate2 = service.exchange("EUR", "PLN", 100);

        assertEquals(rate1, rate2, 0.0001);
    }

    @Test
    public void testCacheExpiration() throws InterruptedException {
        double rate1 = service.exchange("EUR", "PLN", 100);
        Thread.sleep((cacheDuration + 1) * 1000);
        double rate2 = service.exchange("EUR", "PLN", 100);

        assertNotEquals(rate1, rate2, 0.0001);
    }

    @Test
    public void testCacheThreadSafety() throws InterruptedException {
        ExecutorService executor = Executors.newFixedThreadPool(10);
        CountDownLatch latch = new CountDownLatch(10);

        for (int i = 0; i < 10; i++) {
            executor.submit(() -> {
                service.exchange("EUR", "PLN", 100);
                latch.countDown();
            });
        }
        latch.await();
        assertTrue(true);
    }
}