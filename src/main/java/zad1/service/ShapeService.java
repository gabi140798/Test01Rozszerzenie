package zad1.service;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import zad1.exceptions.ShapeNotFoundException;
import zad1.model.Shape;

import java.io.File;
import java.io.IOException;
import java.io.Serializable;
import java.util.*;

public class ShapeService implements Serializable {

     static ObjectMapper objectMapper = new ObjectMapper();

    public Shape findShapeWithLargestArea(List<Shape> list) {
        return Optional.ofNullable(list)
                .orElse(Collections.emptyList())
                .stream()
                .filter(Objects::nonNull)
                .max(Comparator.comparing(Shape::getArea))
                .orElseThrow(ShapeNotFoundException::new);
    }

    public Shape findShapeWithLargestPerimeter(List<Shape> list, String type) {
        return Optional.ofNullable(list)
                .orElse(Collections.emptyList())
                .stream()
                .filter(Objects::nonNull)
                .filter(shape -> shape.getType().equalsIgnoreCase(type))
                .max(Comparator.comparing(Shape::getPerimeter))
                .orElseThrow(ShapeNotFoundException::new);
    }

    public void exportShapesToJson(List<Shape> list, String path) {
        try {
            objectMapper.writeValue(new File(path),list);
            System.out.println("Export of data to file succeeded");
        } catch (IOException e) {
            System.out.println("Export of data to file failed: " + e.getMessage());
        }
    }

    public List<Shape> importShapesFromJson(String path) {
        try {
            List<Shape> list = objectMapper.readValue(new File(path), new TypeReference<>() {
            });
            System.out.println("Data have been imported");
            return list;
        } catch (IOException e) {
            System.out.println("Data have not been imported: " + e.getMessage());
            return null;
        }
    }
}

