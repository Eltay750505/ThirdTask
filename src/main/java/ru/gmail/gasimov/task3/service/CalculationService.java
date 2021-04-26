package ru.gmail.gasimov.task3.service;

import ru.gmail.gasimov.task3.entity.Triangle;

public interface CalculationService {
    double findPerimeter(Triangle triangle);

    double findArea(Triangle triangle);

}
