package ru.gmail.gasimov.task3.init;

import ru.gmail.gasimov.task3.entity.Triangle;
import ru.gmail.gasimov.task3.entity.TriangleParameter;
import ru.gmail.gasimov.task3.exception.TriangleException;
import ru.gmail.gasimov.task3.service.CalculationService;
import ru.gmail.gasimov.task3.service.impl.CalculationServiceImpl;
import ru.gmail.gasimov.task3.warehouse.TriangleWarehouse;
import ru.gmail.gasimov.task3.warehouse.impl.TriangleWarehouseImpl;

public class WarehouseInitializer {
    public void addParametersToWarehouseAndInit(Triangle triangle) throws TriangleException {
        TriangleWarehouse warehouse = TriangleWarehouseImpl.getInstance();
        CalculationService service = new CalculationServiceImpl();
        double perimeter = service.findPerimeter(triangle);
        double area = service.findArea(triangle);
        TriangleParameter triangleParameter = new TriangleParameter(area, perimeter);
        warehouse.put(triangle.getTriangleId(), triangleParameter);
    }
}
