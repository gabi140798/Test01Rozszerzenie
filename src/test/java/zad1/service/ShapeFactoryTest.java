package zad1.service;

import zad1.model.Circle;
import zad1.model.Rectangle;
import zad1.model.Square;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class ShapeFactoryTest {

    private ShapeFactory shapeFactory;
    private Circle c1;
    private Circle c2;
    private Square s1;
    private Square s2;
    private Rectangle r1;
    private  Rectangle r2;

    @Before
    public void init() {
        shapeFactory = ShapeFactory.getInstance();
        c1 = (Circle) shapeFactory.createCircle(5.0);
        c2 = (Circle) shapeFactory.createCircle(5.0);
        s1 = (Square) shapeFactory.createSquare(10.0);
        s2 = (Square) shapeFactory.createSquare(10.0);
        r1 = (Rectangle) shapeFactory.createRectangle(5.0,10.0);
        r2 = (Rectangle) shapeFactory.createRectangle(5.0,10.0);
    }

    @Test
    public void testCreateCircle() {
        assertSame(c1,c2);
        assertTrue(c1 instanceof Circle);
        assertEquals(5.0,c1.getRadius(),0.001);
    }

    @Test
    public void testCreateSquare() {
        assertSame(s1,s2);
        assertTrue(s1 instanceof Square);
        assertEquals(10.0,s1.getSide(),0.001);
    }

    @Test
    public void testCreateRectangle() {
        assertSame(r1,r2);
        assertTrue(r1 instanceof Rectangle);
        assertEquals(5.0,r1.getWidth(),0.001);
        assertEquals(10.0,r1.getHeight(),0.001);
    }
}