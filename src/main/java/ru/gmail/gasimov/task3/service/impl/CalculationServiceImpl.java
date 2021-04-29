package ru.gmail.gasimov.task3.service.impl;


import ru.gmail.gasimov.task3.entity.Triangle;
import ru.gmail.gasimov.task3.service.CalculationService;

public class CalculationServiceImpl implements CalculationService {
    @Override
    public double findPerimeter(Triangle triangle) {
        double[] sides = TriangleUtil.findSides(triangle);

        return sides[0] + sides[1] + sides[2];
    }

    @Override
    public double findArea(Triangle triangle) {
        double[] sides = TriangleUtil.findSides(triangle);

        double perimeter = sides[0] + sides[1] + sides[2];

        double halfPerimeter = perimeter / 2;

        double area = Math.sqrt(halfPerimeter * (halfPerimeter - sides[0])
                * (halfPerimeter - sides[1])
                * (halfPerimeter - sides[2]));

        return area;
    }

}
