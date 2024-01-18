package zad1.model;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@EqualsAndHashCode

public class Square extends Shape {

    private double side;

    @Override
    public String getType() {
        return "square";
    }

    @JsonIgnore
    @Override
    public double getArea() {
        return side * side;
    }

    @JsonIgnore
    @Override
    public double getPerimeter() {
        return 4 * side;
    }
}
