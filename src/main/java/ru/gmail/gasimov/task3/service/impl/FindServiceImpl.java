package ru.gmail.gasimov.task3.service.impl;

import ru.gmail.gasimov.task3.entity.Point;
import ru.gmail.gasimov.task3.entity.Triangle;
import ru.gmail.gasimov.task3.entity.TriangleType;
import ru.gmail.gasimov.task3.service.FindService;

public class FindServiceImpl implements FindService {
    @Override
    public TriangleType findTriangleType(Triangle triangle) {
        double firstSide = findSide(triangle.getFirstPoint(), triangle.getSecondPoint());
        double secondSide = findSide(triangle.getFirstPoint(), triangle.getThirdPoint());
        double thirdSide = findSide(triangle.getSecondPoint(), triangle.getThirdPoint());

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

    @Override
    public double[] findSides(Triangle triangle) {
        int sideCount = 3;
        double[] sides = new double[sideCount];
        Point firstPoint = triangle.getFirstPoint();
        Point secondPoint = triangle.getSecondPoint();
        Point thirdPoint = triangle.getThirdPoint();

        double firstSide = findSide(firstPoint, secondPoint);
        double secondSide = findSide(secondPoint, thirdPoint);
        double thirdSide = findSide(thirdPoint, firstPoint);

        sides[0] = firstSide;
        sides[1] = secondSide;
        sides[2] = thirdSide;

        return sides;
    }

    @Override
    public double findSide(Point x, Point y) {
        double firstPointPow = Math.pow(x.getX() - y.getX(), 2);
        double secondPointPow = Math.pow(x.getY() - y.getY(), 2);

        double toAbs = Math.sqrt(firstPointPow + secondPointPow);
        double result = Math.abs(toAbs);

        return result;
    }
}
