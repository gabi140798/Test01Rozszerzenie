package zad1.model;

import org.junit.Test;

import static org.junit.Assert.*;

public class RectangleTest {

    private Rectangle r1 = new Rectangle(5.0,10.0);
    private Rectangle r2 = new Rectangle(5.0,10.0);
    private Rectangle r3 = new Rectangle(10.0,20.0);

    @Test
    public void testArea() {
        assertEquals("Incorrect calculation of the area of a rectangle",50.0,r1.getArea(),0.001);
    }

    @Test
    public void testPerimeter() {
        assertEquals("Incorrect calculation of the perimeter of a rectangle",30.0,r1.getPerimeter(),0.001);
    }

    @Test
    public void testType() {
        assertEquals("Incorrect type", "rectangle",r1.getType());
    }

    @Test
    public void testEquals() {
        assertTrue("Two rectangles of the same dimensions should be equal", r1.equals(r2));
        assertFalse("Rectangles with different dimensions should not be equal", r1.equals(r3));
    }

    @Test
    public void testHashCode() {
        assertEquals("HashCode should be the same for equal objects", r1.hashCode(), r2.hashCode());
    }
}