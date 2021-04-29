package ru.gmail.gasimov.task3.service;

import ru.gmail.gasimov.task3.entity.Point;
import ru.gmail.gasimov.task3.entity.Triangle;
import ru.gmail.gasimov.task3.entity.TriangleType;

public interface FindService {
    TriangleType findTriangleType(Triangle triangle);

    double[] findSides(Triangle triangle);

    double findSide(Point x, Point y);
}
