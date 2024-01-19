package zad1.service;

import zad1.model.Circle;
import zad1.model.Rectangle;
import zad1.model.Square;
import zad1.model.Shape;

import java.util.HashMap;
import java.util.Map;

public class ShapeFactory {

    private static final ShapeFactory instance = new ShapeFactory();
    private Map<String, Shape> shapeCache = new HashMap<>();

    private ShapeFactory() {}

    public static ShapeFactory getInstance() {
        return instance;
    }

    public Shape createCircle(double radius) {
        String key = "Circle:" + radius;
        return shapeCache.computeIfAbsent(key, k -> new Circle(radius));
    }

    public Shape createSquare(double side) {
        String key = "Square:" + side;
        return shapeCache.computeIfAbsent(key, k -> new Square(side));
    }

    public Shape createRectangle(double width, double height) {
        String key = "Rectangle:" + width + ":" + height;
        return shapeCache.computeIfAbsent(key, k -> new Rectangle(width, height));
    }
}

