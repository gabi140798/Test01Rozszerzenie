package zad1.model;

import org.junit.Test;

import static org.junit.Assert.*;

public class CircleTest {

    private Circle c1 = new Circle(10.0);
    private Circle c2 = new Circle(5.0);
    private Circle c3 = new Circle(10.0);

    @Test
    public void testArea() {
        assertEquals("Incorrect calculation of the area of a circle",314.1592653589793,c1.getArea(),0.001);
    }

    @Test
    public void testPerimeter() {
        assertEquals("Incorrect calculation of the perimeter of a circle",62.83185307179586,c1.getPerimeter(),0.001);
    }

    @Test
    public void testType() {
        assertEquals("Incorrect type", "circle",c1.getType());
    }

    @Test
    public void testEquals() {
        assertTrue("Two circles of the same radius should be equal", c1.equals(c3));
        assertFalse("Circles with different radii should not be equal", c1.equals(c2));
    }

    @Test
    public void testHashCode() {
        assertEquals("HashCode should be the same for equal objects", c1.hashCode(), c3.hashCode());
    }

}