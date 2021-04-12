package ru.gmail.gasimov.task3.warehouse.impl;

import ru.gmail.gasimov.task3.entity.TriangleParameter;
import ru.gmail.gasimov.task3.exception.ShapeException;
import ru.gmail.gasimov.task3.warehouse.TriangleWarehouse;

import java.util.HashMap;
import java.util.Map;

public class TriangleWarehouseImpl implements TriangleWarehouse {
    private static TriangleWarehouse instance = null;
    private Map<Long, TriangleParameter> map;

    private TriangleWarehouseImpl() {
        map = new HashMap<>();
    }

    public static TriangleWarehouse getInstance(){
        if (instance == null) {
            instance = new TriangleWarehouseImpl();
        }

        return instance;
    }

    @Override
    public void put(Long triangleId, TriangleParameter newParameter) throws ShapeException {
        if (triangleId == null) {
            throw new ShapeException("Id cannot be null");
        }

        if (newParameter == null) {
            throw new ShapeException("Triangle parameters cannot be null");
        }

        map.put(triangleId, newParameter);
    }
}
