package ru.gmail.gasimov.task3;

import ru.gmail.gasimov.task3.entity.Point;
import ru.gmail.gasimov.task3.entity.Triangle;
import ru.gmail.gasimov.task3.exception.TriangleException;
import ru.gmail.gasimov.task3.parser.TriangleParser;
import ru.gmail.gasimov.task3.reader.TriangleReader;
import ru.gmail.gasimov.task3.service.CalculationService;
import ru.gmail.gasimov.task3.service.FindService;
import ru.gmail.gasimov.task3.service.impl.CalculationServiceImpl;
import ru.gmail.gasimov.task3.service.impl.FindServiceImpl;
import ru.gmail.gasimov.task3.validator.TriangleValidator;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) throws TriangleException {
        TriangleReader triangleReader = new TriangleReader();
        String[] strings = triangleReader.readCorrectStringsFromFile("src\\main\\resources\\data\\numbers.txt");
        Triangle triangle = new Triangle();
        TriangleParser triangleParser = new TriangleParser();
        double[] doubles = triangleParser.parseTriangle(strings[0]);
        Point firstPoint = new Point(doubles[0], doubles[1]);
        Point secondPoint = new Point(doubles[2], doubles[3]);
        Point thirdPoint = new Point(doubles[4], doubles[5]);

        triangle.setFirstPoint(firstPoint);
        triangle.setSecondPoint(secondPoint);
        triangle.setThirdPoint(thirdPoint);

        FindService findService = new FindServiceImpl();

        triangle.setTriangleType(findService.findTriangleType(triangle));

        try {
            boolean isTriangle = TriangleValidator.isTriangle(
                    triangle.getFirstPoint(),
                    triangle.getSecondPoint(),
                    triangle.getThirdPoint()
            );


            System.out.println(isTriangle);
            System.out.println(triangle.getTriangleType().toString().toLowerCase());
        } catch (TriangleException e) {
            e.getMessage();
        }
        CalculationService calculationService = new CalculationServiceImpl();
        double area = calculationService.findArea(triangle);
        double perimeter = calculationService.findPerimeter(triangle);

        System.out.println("Area = " + area);
        System.out.println("Perimeter = " + perimeter);
    }
}
