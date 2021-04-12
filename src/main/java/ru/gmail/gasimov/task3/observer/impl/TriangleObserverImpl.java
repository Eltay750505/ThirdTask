package ru.gmail.gasimov.task3.observer.impl;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import ru.gmail.gasimov.task3.entity.Triangle;
import ru.gmail.gasimov.task3.entity.TriangleParameter;
import ru.gmail.gasimov.task3.exception.ShapeException;
import ru.gmail.gasimov.task3.observer.TriangleEvent;
import ru.gmail.gasimov.task3.observer.TriangleObserver;
import ru.gmail.gasimov.task3.service.CalculationService;
import ru.gmail.gasimov.task3.service.impl.CalculationServiceImpl;
import ru.gmail.gasimov.task3.warehouse.TriangleWarehouse;
import ru.gmail.gasimov.task3.warehouse.impl.TriangleWarehouseImpl;

public class TriangleObserverImpl implements TriangleObserver {
    private static Logger logger = LogManager.getLogger();

    @Override
    public void parametersChanged(TriangleEvent event) {
        Triangle triangle = event.getSource();
        CalculationService service = new CalculationServiceImpl();
        TriangleWarehouse warehouse = TriangleWarehouseImpl.getInstance();

        Long ellipseId = triangle.getShapeId();
        try {
            double perimeter = service.findPerimeter(triangle);
            double area = service.findArea(triangle);
            TriangleParameter newParameters = new TriangleParameter(perimeter, area);
            warehouse.put(ellipseId, newParameters);
        } catch (ShapeException e) {
            logger.error("Warehouse cannot be updated", e.getCause());
        }
    }
}