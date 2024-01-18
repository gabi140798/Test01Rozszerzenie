package zad1.model;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@EqualsAndHashCode

public class Rectangle extends Shape {

    private double width;
    private double height;


    @Override
    public String getType() {
        return "rectangle";
    }

    @JsonIgnore
    @Override
    public double getArea() {
        return width * height;
    }

    @JsonIgnore
    @Override
    public double getPerimeter() {
        return 2 * (width + height);
    }
}
