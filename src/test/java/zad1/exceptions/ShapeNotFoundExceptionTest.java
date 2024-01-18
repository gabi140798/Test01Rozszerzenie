package zad1.exceptions;

import org.junit.Test;

import static org.junit.Assert.*;

public class ShapeNotFoundExceptionTest {

    @Test
    public void testEmptyConstructor() {
        ShapeNotFoundException exception = new ShapeNotFoundException();
        assertNull("Message should be null", exception.getMessage());
    }

    @Test
    public void testConstructorWithMessage() {
        String testMessage = "Test message";
        ShapeNotFoundException exception = new ShapeNotFoundException(testMessage);
        assertEquals("Messages should be equal", testMessage, exception.getMessage());
    }

}