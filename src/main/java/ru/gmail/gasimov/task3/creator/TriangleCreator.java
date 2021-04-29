package ru.gmail.gasimov.task3.creator;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import ru.gmail.gasimov.task3.entity.Point;
import ru.gmail.gasimov.task3.entity.Triangle;
import ru.gmail.gasimov.task3.exception.TriangleException;
import ru.gmail.gasimov.task3.validator.TriangleValidator;

public class TriangleCreator {
    public static final Logger Logger = LogManager.getLogger();

    public TriangleCreator() {
    }

    public static Triangle createTriangleFromDoubleArray(double[] numberArray) throws TriangleException {
        int expectedCountOfNumbers = 6;
        if (numberArray.length != expectedCountOfNumbers) {
            Logger.log(Level.ERROR, "Expected 6 numbers, but got " + numberArray.length);
            throw new TriangleException("Expected 6 numbers, but got " + numberArray.length);
        }

        return createTriangleFromPoints(numberArray[0],
                numberArray[1],
                numberArray[2],
                numberArray[3],
                numberArray[4],
                numberArray[5]);
    }

    public static Triangle createTriangleFromPoints(double x1, double y1, double x2, double y2, double x3, double y3) throws TriangleException {
        Point first = new Point(x1, y1);
        Point second = new Point(x2, y2);
        Point third = new Point(x3, y3);

        if (!TriangleValidator.isTriangle(first, second, third)) {
            Logger.log(Level.ERROR, "Triangle cannot be created from this points, firstPoint - "
                    + first + " secondPoint - "
                    + second + " thirdPoint - "
                    + third);
            throw new TriangleException("Triangle cannot be created from this points");
        }

        return new Triangle(first, second, third);
    }
}
