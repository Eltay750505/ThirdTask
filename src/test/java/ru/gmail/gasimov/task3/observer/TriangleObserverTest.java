package ru.gmail.gasimov.task3.observer;

import junit.framework.TestCase;
import org.testng.annotations.Test;
import ru.gmail.gasimov.task3.entity.Point;
import ru.gmail.gasimov.task3.entity.Triangle;
import ru.gmail.gasimov.task3.entity.TriangleParameter;
import ru.gmail.gasimov.task3.exception.TriangleException;
import ru.gmail.gasimov.task3.init.RepositoryInit;
import ru.gmail.gasimov.task3.init.WarehouseInit;
import ru.gmail.gasimov.task3.observer.impl.TriangleObserverImpl;
import ru.gmail.gasimov.task3.repository.Repository;
import ru.gmail.gasimov.task3.repository.impl.TriangleRepository;
import ru.gmail.gasimov.task3.service.CalculationService;
import ru.gmail.gasimov.task3.service.impl.CalculationServiceImpl;
import ru.gmail.gasimov.task3.warehouse.TriangleWarehouse;
import ru.gmail.gasimov.task3.warehouse.impl.TriangleWarehouseImpl;

import static org.testng.Assert.assertNotEquals;

public class TriangleObserverTest extends TestCase {
    private static final Point[][] testPoints = {
            {
                    new Point(2, 1),
                    new Point(6, 1),
                    new Point(2, 4)
            },
            {
                    new Point(2, 1),
                    new Point(3, 3),
                    new Point(0, 1)
            }
    };
    private static Triangle testTriangle = new Triangle(testPoints[0][0], testPoints[0][1], testPoints[0][2]);

    static {
        testTriangle.attachObserver(new TriangleObserverImpl());
    }

    @Test
    public void testParametersChanged() throws TriangleException {
        RepositoryInit repositoryInit = new RepositoryInit();
        WarehouseInit warehouseInit = new WarehouseInit();
        CalculationService calculationService = new CalculationServiceImpl();

        repositoryInit.addTriangleToRepositoryAndInit(testTriangle);
        warehouseInit.addParametersToWarehouseAndInit(testTriangle);
        Repository<Triangle> repository = TriangleRepository.getInstance();
        TriangleWarehouse triangleWarehouse = TriangleWarehouseImpl.getInstance();

        double oldPerimeter = calculationService.findPerimeter(testTriangle);

        testTriangle.setFirstPoint(testPoints[1][0]);
        testTriangle.setSecondPoint(testPoints[1][1]);
        testTriangle.setThirdPoint(testPoints[1][2]);

        TriangleParameter triangleParameter = triangleWarehouse.get(testTriangle.getTriangleId());

        double actualPerimeter = triangleParameter.getPerimeter();

        assertNotEquals(oldPerimeter, actualPerimeter);
    }
}