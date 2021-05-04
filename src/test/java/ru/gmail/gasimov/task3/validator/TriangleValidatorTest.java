package ru.gmail.gasimov.task3.validator;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import ru.gmail.gasimov.task3.entity.Point;

import static junit.framework.TestCase.assertTrue;

public class TriangleValidatorTest {
    @DataProvider(name = "pointProvider")
    public Object[][] pointProvider() {
        return new Object[][]{
                {null, null, null},
                {new Point(1, 1), null, new Point(1, 1)},
                {new Point(1, 1), new Point(2, 1), null},
                {new Point(1, 1), new Point(2, 2), new Point(1, 2)}
        };
    }

    @Test(dataProvider = "pointProvider")
    public void isTriangleTest(Point point1, Point point2, Point point3) {
        boolean isTriangle = TriangleValidator.isTriangle(point1, point2, point3);
        assertTrue(isTriangle);
    }
}
