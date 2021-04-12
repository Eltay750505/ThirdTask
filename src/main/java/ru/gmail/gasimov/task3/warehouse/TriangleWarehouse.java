package ru.gmail.gasimov.task3.warehouse;

import ru.gmail.gasimov.task3.entity.TriangleParameter;
import ru.gmail.gasimov.task3.exception.ShapeException;

public interface TriangleWarehouse {
    void put(Long triangleId, TriangleParameter newParameters) throws ShapeException;
}
