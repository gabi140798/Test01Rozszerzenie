package zad1.model;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@EqualsAndHashCode

public class Circle extends Shape {

    private double radius;

    @Override
    public String getType() {
        return "circle";
    }

    @JsonIgnore
    @Override
    public double getArea() {
        return Math.PI * radius * radius;
    }

    @JsonIgnore
    @Override
    public double getPerimeter() {
        return 2 * Math.PI * radius;
    }
}
