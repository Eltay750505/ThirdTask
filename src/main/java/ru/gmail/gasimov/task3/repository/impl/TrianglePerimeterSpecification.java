package ru.gmail.gasimov.task3.repository.impl;

import ru.gmail.gasimov.task3.entity.Triangle;
import ru.gmail.gasimov.task3.repository.Specification;
import ru.gmail.gasimov.task3.service.CalculationService;
import ru.gmail.gasimov.task3.service.impl.CalculationServiceImpl;

public class TrianglePerimeterSpecification implements Specification<Triangle> {
    private double minPerimeter;
    private double maxPerimeter;

    public TrianglePerimeterSpecification(double minPerimeter, double maxPerimeter) {
        this.minPerimeter = minPerimeter;
        this.maxPerimeter = maxPerimeter;
    }


    @Override
    public boolean specify(Triangle item) {
        CalculationService calculationService = new CalculationServiceImpl();
        double perimeter = calculationService.findPerimeter(item);
        boolean isSpecified = (perimeter >= minPerimeter && perimeter <= maxPerimeter);
        return isSpecified;
    }
}
