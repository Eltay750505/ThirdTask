package ru.gmail.gasimov.task3.validator;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import ru.gmail.gasimov.task3.entity.Point;
import ru.gmail.gasimov.task3.exception.TriangleException;
import ru.gmail.gasimov.task3.service.FindService;
import ru.gmail.gasimov.task3.service.impl.FindServiceImpl;

import java.util.regex.Pattern;


public class TriangleValidator {
    private static Logger logger = LogManager.getLogger();
    public static final String PARAMS_PATTERN = "\\s*\\d*\\s*\\d*\\s*\\d*\\s*\\d*\\s*\\d*\\s*\\d*\\s*";

    public static boolean validateString(String paramsString) {
        if (paramsString == null || paramsString.equals("")) {
            logger.error("String cannot be empty");
            return false;
        }

        return Pattern.matches(PARAMS_PATTERN, paramsString);
    }

    public static boolean isTriangle(Point firstPoint, Point secondPoint, Point thirdPoint) throws TriangleException {
        if (firstPoint == null || secondPoint == null || thirdPoint == null) {
            throw new TriangleException("Point cannot be null, " +
                    " first = " + firstPoint +
                    " second = " + secondPoint +
                    " third = " + thirdPoint);
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
