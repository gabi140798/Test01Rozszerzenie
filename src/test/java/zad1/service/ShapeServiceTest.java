package zad1.service;


import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import zad1.exceptions.ShapeNotFoundException;
import zad1.model.Circle;
import zad1.model.Rectangle;
import zad1.model.Shape;
import zad1.model.Square;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;

public class ShapeServiceTest implements Serializable {


    @Mock
    private ShapeService service;
    private ObjectMapper objectMapper;
    private List<Shape> list;
    private Rectangle r1;
    private Circle c1;
    private Square s1;
    private String path;

    @Before
    public void init() {
        MockitoAnnotations.openMocks(this);
        service = new ShapeService();
        objectMapper = new ObjectMapper();
        path = "src/main/resources/shapes.json";

        r1 = new Rectangle(5.0, 10.0);
        c1 = new Circle(10.0);
        s1 = new Square(5.0);

        list = new ArrayList<>(List.of(r1, c1, s1));
    }

    @Test
    public void testFindShapeWithLargestArea() {
        Shape result = service.findShapeWithLargestArea(list);
        Shape expected = c1;
        assertEquals(expected, result);
    }

    @Test
    public void testFindShapeWithLargestPerimeter() {
        Shape result = service.findShapeWithLargestPerimeter(list, "square");
        Shape expected = s1;
        assertEquals(expected, result);
    }

    @Test
    public void testExportShapesToJson() throws IOException {
        service.exportShapesToJson(list, path);
        File file = new File(path);
        assertTrue(file.exists());
        List<Shape> readShapes = objectMapper.readValue(file, new TypeReference<List<Shape>>(){});
        assertEquals("The list read from the file should correspond to the input list", list, readShapes);
    }

    @Test
    public void testExportShapesToJsonWithNullPath() {
        try {
            service.exportShapesToJson(new ArrayList<>(), null);
            fail("A NullPointerException should be thrown");
        } catch (NullPointerException e) {
        }
    }

    @Test
    public void testImportShapesFromJson() {
        ShapeService shapeService = mock(ShapeService.class);
        when(shapeService.importShapesFromJson(anyString())).thenReturn(new ArrayList<>());
        List<Shape> result = service.importShapesFromJson(path);
        assertEquals(list, result);
    }

    @Test
    public void testImportShapesFromJsonWithValidData() {
        List<Shape> result = service.importShapesFromJson(path);
        assertNotNull("The list should not be null", result);
    }

    @Test
    public void testSerializationAndDeserialization() throws IOException, ClassNotFoundException {
        String testMessage = "Shape not found!";
        ShapeNotFoundException originalException = new ShapeNotFoundException(testMessage);

        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        ObjectOutputStream oos = new ObjectOutputStream(baos);
        oos.writeObject(originalException);
        oos.close();

        ByteArrayInputStream bais = new ByteArrayInputStream(baos.toByteArray());
        ObjectInputStream ois = new ObjectInputStream(bais);
        ShapeNotFoundException deserializedException = (ShapeNotFoundException) ois.readObject();

        assertEquals("Serialized and deserialized messages should be equal",
                testMessage, deserializedException.getMessage());
    }

    @Test
    public void testShapeSerializationAndDeserialization() throws IOException, ClassNotFoundException {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        ObjectOutputStream oos = new ObjectOutputStream(baos);
        oos.writeObject(r1);
        oos.close();

        ByteArrayInputStream bais = new ByteArrayInputStream(baos.toByteArray());
        ObjectInputStream ois = new ObjectInputStream(bais);
        Shape deserializedShape = (Shape) ois.readObject();

        assertEquals(r1, deserializedShape);
    }
}


