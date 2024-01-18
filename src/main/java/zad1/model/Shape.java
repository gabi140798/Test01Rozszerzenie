package zad1.model;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import lombok.*;

@JsonPropertyOrder({"type", "perimeter", "radius", "width", "height", "area", "side"})
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, property = "type")
@JsonSubTypes({
        @JsonSubTypes.Type(value = Rectangle.class, name = "rectangle"),
        @JsonSubTypes.Type(value = Circle.class, name = "circle"),
        @JsonSubTypes.Type(value = Square.class, name = "square")
})

@AllArgsConstructor
@Getter
@ToString
@EqualsAndHashCode

public abstract class Shape {

    public abstract String getType();
    public abstract double getArea();
    public abstract double getPerimeter();
}
