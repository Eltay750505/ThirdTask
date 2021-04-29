package ru.gmail.gasimov.task3.warehouse.impl;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import ru.gmail.gasimov.task3.entity.TriangleParameter;
import ru.gmail.gasimov.task3.exception.TriangleException;
import ru.gmail.gasimov.task3.warehouse.TriangleWarehouse;

import java.util.HashMap;
import java.util.Map;

public class TriangleWarehouseImpl implements TriangleWarehouse {
    private static TriangleWarehouse instance = null;
    public static final Logger LOGGER = LogManager.getLogger();
    private Map<Long, TriangleParameter> map;

    private TriangleWarehouseImpl() {
        map = new HashMap<>();
    }

    public static TriangleWarehouse getInstance() {
        if (instance == null) {
            instance = new TriangleWarehouseImpl();
        }

        return instance;
    }

    @Override
    public void put(Long triangleId, TriangleParameter newParameter) throws TriangleException {
        if (triangleId == null) {
            throw new TriangleException("Id cannot be null " + triangleId);
        }

        if (newParameter == null) {
            throw new TriangleException("Triangle parameters cannot be null " + triangleId);
        }

        map.put(triangleId, newParameter);
    }

    @Override
    public TriangleParameter remove(Long triangleId) {
        TriangleParameter parameter = map.remove(triangleId);
        return parameter;
    }

    @Override
    public TriangleParameter get(Long triangleId) throws TriangleException {
        TriangleParameter triangleParameter = map.get(triangleId);
        if (triangleParameter == null) {
            LOGGER.log(Level.ERROR, "Element wasn't found " + triangleId);
            throw new TriangleException("Element wasn't found " + triangleId);
        }
        return triangleParameter;
    }
}
