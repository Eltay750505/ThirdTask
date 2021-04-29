package ru.gmail.gasimov.task3.warehouse;

import ru.gmail.gasimov.task3.entity.TriangleParameter;
import ru.gmail.gasimov.task3.exception.TriangleException;

public interface TriangleWarehouse {
    void put(Long triangleId, TriangleParameter newParameters) throws TriangleException;

    TriangleParameter remove(Long triangleId);

    TriangleParameter get(Long triangleId) throws TriangleException;

}
