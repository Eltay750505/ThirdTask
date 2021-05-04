package ru.gmail.gasimov.task3.service;

import junit.framework.TestCase;
import org.testng.annotations.Test;
import ru.gmail.gasimov.task3.entity.Point;
import ru.gmail.gasimov.task3.entity.Triangle;
import ru.gmail.gasimov.task3.service.impl.CalculationServiceImpl;

public class CalculationServiceTest extends TestCase {
    private static Point[] testPoints = {
            new Point(2, 1),
            new Point(6, 1),
            new Point(2, 4)
    };

    private static final CalculationService calculationService;

    static {
        calculationService = new CalculationServiceImpl();
    }

    @Test
    public void testFindPerimeter() {
        Triangle triangle = new Triangle(testPoints[0], testPoints[1], testPoints[2]);
        double expected = 12.0;
        double actual = calculationService.findPerimeter(triangle);
        assertEquals(actual, expected, 0.001);
    }

    @Test
    public void testFindArea() {
        Triangle triangle = new Triangle(testPoints[0], testPoints[1], testPoints[2]);
        double expected = 6.0;
        double actual = calculationService.findArea(triangle);
        assertEquals(actual, expected, 0.001);
    }
}