package zad1.exceptions;

public class ShapeNotFoundException extends RuntimeException {

    public ShapeNotFoundException() {
    }

    public ShapeNotFoundException(String message) {
        super(message);
    }
}
