package zad2.model;

import org.junit.Test;

import static org.junit.Assert.*;

public class CurrencyTest {

    @Test
    public void testEquality() {
        Currency c1 = new Currency("EUR", "PLN");
        Currency c2 = new Currency("EUR", "PLN");

        assertEquals(c1, c2);
    }

    @Test
    public void testInequalityDifferentFromCurrency() {
        Currency c1 = new Currency("EUR", "PLN");
        Currency c2 = new Currency("USD", "EUR");

        assertNotEquals(c1, c2);
    }

    @Test
    public void testInequalityDifferentToCurrency() {
        Currency c1 = new Currency("PLN", "EUR");
        Currency c2 = new Currency("PLN", "USD");

        assertNotEquals(c1, c2);
    }

    @Test
    public void testHashCodeConsistency() {
        Currency c1 = new Currency("PLN", "EUR");
        Currency c2 = new Currency("PLN", "EUR");

        assertEquals(c1.hashCode(), c2.hashCode());
    }
}
