package ru.gmail.gasimov.task3.util;

import ru.gmail.gasimov.task3.entity.Point;
import ru.gmail.gasimov.task3.entity.Triangle;
import ru.gmail.gasimov.task3.entity.TriangleType;

public class TriangleUtil {
    public static TriangleType findTriangleType(Triangle triangle) {
        double firstSide = TriangleUtil.findSide(triangle.getFirstPoint(), triangle.getSecondPoint());
        double secondSide = TriangleUtil.findSide(triangle.getFirstPoint(), triangle.getThirdPoint());
        double thirdSide = TriangleUtil.findSide(triangle.getSecondPoint(), triangle.getThirdPoint());

        if (firstSide == secondSide || firstSide == thirdSide || secondSide == thirdSide) {
            if (firstSide == secondSide && secondSide == thirdSide && thirdSide == firstSide) {
                return TriangleType.EQUILATERAL;
            } else {
                return TriangleType.ISOSCELES;
            }
        }

        if ((Math.pow(thirdSide, 2) == (Math.pow(firstSide, 2) + Math.pow(secondSide, 2))) ||
                (Math.pow(secondSide, 2) == (Math.pow(thirdSide, 2) + Math.pow(firstSide, 2))) ||
                (Math.pow(firstSide, 2) == (Math.pow(secondSide, 2) + Math.pow(thirdSide, 2)))) {
            return TriangleType.RECTANGULAR;
        }

        return TriangleType.ARBITRARY;
    }

    public static double findSide(Point x, Point y) {
        double firstPointPow = Math.pow(x.getX() - y.getX(), 2);
        double secondPointPow = Math.pow(x.getY() - y.getY(), 2);

        double toAbs = Math.sqrt(firstPointPow + secondPointPow);
        double result = Math.abs(toAbs);

        return result;
    }
}
