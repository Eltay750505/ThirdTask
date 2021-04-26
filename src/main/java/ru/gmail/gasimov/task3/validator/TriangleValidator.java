package ru.gmail.gasimov.task3.validator;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import ru.gmail.gasimov.task3.entity.Point;
import ru.gmail.gasimov.task3.exception.ShapeException;
import ru.gmail.gasimov.task3.util.TriangleUtil;

import java.util.regex.Pattern;



public class TriangleValidator {
    private static Logger logger = LogManager.getLogger();
    public static final String PARAMS_PATTERN = "\\s*\\d*\\s*\\d*\\s*\\d*\\s*\\d*\\s*\\d*\\s*\\d*\\s*";

    public static boolean validateString(String paramsString) {
        if (paramsString == null) {
            logger.error("String cannot be null");
            return false;
        }

        return Pattern.matches(PARAMS_PATTERN, paramsString);
    }

    public static boolean isTriangle(Point x, Point y, Point z) throws ShapeException {
        if (x == null || y == null || z == null) {
            throw new ShapeException("Point cannot be null");
        }

        boolean validateOnTriangle = isValidateOnTriangle(x, y, z);
        return validateOnTriangle;
    }

    private static boolean isValidateOnTriangle(Point x, Point y, Point z) {
        double firstSide = TriangleUtil.findSide(x, y);
        double secondSide = TriangleUtil.findSide(y, z);
        double thirdSide = TriangleUtil.findSide(z, x);

        if (firstSide + secondSide > thirdSide) {
            if (secondSide + thirdSide > firstSide) {
                if (thirdSide + firstSide > secondSide){
                    return true;
                }
            }
        }

        return false;
    }
}
