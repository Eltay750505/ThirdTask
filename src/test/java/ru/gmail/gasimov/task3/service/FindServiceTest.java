package ru.gmail.gasimov.task3.service;


import junit.framework.TestCase;
import org.testng.annotations.Test;
import ru.gmail.gasimov.task3.entity.Point;
import ru.gmail.gasimov.task3.entity.Triangle;
import ru.gmail.gasimov.task3.service.impl.FindServiceImpl;

import static org.testng.internal.junit.ArrayAsserts.assertArrayEquals;


public class FindServiceTest extends TestCase {
    private static final Point[] testPoints = {
            new Point(2, 1),
            new Point(6, 1),
            new Point(2, 4)
    };
    private static final Triangle testTriangle = new Triangle(testPoints[0], testPoints[1], testPoints[2]);

    private static FindService findService;

    static {
        findService = new FindServiceImpl();
    }

    @Test
    public void testFindTriangleType() {
        String expected = "rectangular";
        String actual = findService.findTriangleType(testTriangle).toString().toLowerCase();
        assertEquals(expected, actual);
    }

    @Test
    public void testFindSides() {
        double[] expectedSides = {4, 5, 3};
        double[] actualSides = findService.findSides(testTriangle);
        assertArrayEquals(expectedSides, actualSides, 0.001);
    }

    @Test
    public void testFindSide() {
        double expected = 3;
        double actual = findService.findSide(testPoints[0], testPoints[2]);
        assertEquals(expected, actual, 0.001);
    }
}