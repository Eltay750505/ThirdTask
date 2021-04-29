package ru.gmail.gasimov.task3.repository.impl;

import ru.gmail.gasimov.task3.entity.Triangle;
import ru.gmail.gasimov.task3.repository.Specification;
import ru.gmail.gasimov.task3.service.CalculationService;
import ru.gmail.gasimov.task3.service.impl.CalculationServiceImpl;

public class TriangleAreaSpecification implements Specification<Triangle> {
    private double minArea;
    private double maxArea;

    public TriangleAreaSpecification(double minArea, double maxArea) {
        this.minArea = minArea;
        this.maxArea = maxArea;
    }


    @Override
    public boolean specify(Triangle item) {
        CalculationService calculationService = new CalculationServiceImpl();
        double area = calculationService.findArea(item);
        boolean isSpecified = (area >= minArea && area <= maxArea);
        return isSpecified;
    }
}
