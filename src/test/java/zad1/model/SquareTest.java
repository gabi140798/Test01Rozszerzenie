package zad1.model;

import org.junit.Test;

import static org.junit.Assert.*;

public class SquareTest {

    private Square s1 = new Square(5.0);
    private Square s2 = new Square(5.0);
    private Square s3 = new Square(10.0);

    @Test
    public void testArea() {
        assertEquals("Incorrect calculation of the area of a square", 25.0, s1.getArea(), 0.001);
    }

    @Test
    public void testPerimeter() {
        assertEquals("Incorrect calculation of the perimeter of a square", 20.0, s1.getPerimeter(), 0.001);
    }

    @Test
    public void testType() {
        assertEquals("Incorrect type", "square", s1.getType());
    }

    @Test
    public void testEquals() {
        assertTrue("Two squares with the same side should be equal", s1.equals(s2));
        assertFalse("Squares with different sides should not be equal", s1.equals(s3));
    }

    @Test
    public void testHashCode() {
        assertEquals("HashCode should be the same for equal objects", s1.hashCode(), s2.hashCode());
    }

}