package ru.gmail.gasimov.task3.validator;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import ru.gmail.gasimov.task3.entity.Point;
import ru.gmail.gasimov.task3.service.FindService;
import ru.gmail.gasimov.task3.service.impl.FindServiceImpl;


public class TriangleValidator {
    private static Logger logger = LogManager.getLogger();

    public static boolean isTriangle(Point firstPoint, Point secondPoint, Point thirdPoint) {
        if (firstPoint == null || secondPoint == null || thirdPoint == null) {
            logger.log(Level.ERROR, "Point cannot be null, " +
                    " first = " + firstPoint +
                    " second = " + secondPoint +
                    " third = " + thirdPoint);
            return false;
        }

        boolean validateOnTriangle = isValidateOnTriangle(firstPoint, secondPoint, thirdPoint);
        return validateOnTriangle;
    }

    private static boolean isValidateOnTriangle(Point x, Point y, Point z) {
        FindService findService = new FindServiceImpl();

        double firstSide = findService.findSide(x, y);
        double secondSide = findService.findSide(y, z);
        double thirdSide = findService.findSide(z, x);

        if (firstSide + secondSide > thirdSide) {
            if (secondSide + thirdSide > firstSide) {
                if (thirdSide + firstSide > secondSide) {
                    return true;
                }
            }
        }

        return false;
    }
}
