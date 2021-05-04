package ru.gmail.gasimov.task3.main;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import ru.gmail.gasimov.task3.entity.Triangle;
import ru.gmail.gasimov.task3.entity.TriangleParameter;
import ru.gmail.gasimov.task3.exception.TriangleException;
import ru.gmail.gasimov.task3.factory.TriangleFactory;
import ru.gmail.gasimov.task3.init.RepositoryInit;
import ru.gmail.gasimov.task3.init.WarehouseInit;
import ru.gmail.gasimov.task3.observer.impl.TriangleObserverImpl;
import ru.gmail.gasimov.task3.parser.TriangleParser;
import ru.gmail.gasimov.task3.reader.TriangleReader;
import ru.gmail.gasimov.task3.repository.Repository;
import ru.gmail.gasimov.task3.repository.impl.TriangleRepository;
import ru.gmail.gasimov.task3.service.CalculationService;
import ru.gmail.gasimov.task3.service.impl.CalculationServiceImpl;
import ru.gmail.gasimov.task3.warehouse.TriangleWarehouse;
import ru.gmail.gasimov.task3.warehouse.impl.TriangleWarehouseImpl;

import java.util.ArrayList;
import java.util.List;


public class MainForInit {
    private static final Logger LOGGER = LogManager.getLogger();

    public static void main(String[] args) throws TriangleException {
        String pathName = "src\\main\\resources\\data\\numbers.txt";
        TriangleReader triangleReader = new TriangleReader();
        String[] stringsFromFile = triangleReader.readCorrectStringsFromFile(pathName);

        TriangleParser triangleParser = new TriangleParser();
        List<Triangle> triangles = new ArrayList<>();

        for (int i = 0; i < stringsFromFile.length; i++) {
            double[] parsedString = triangleParser.parseString(stringsFromFile[i]);
            Triangle triangleFromDoubleArray = TriangleFactory.createTriangleFromDoubleArray(parsedString);
            triangleFromDoubleArray.attachObserver(new TriangleObserverImpl());
            triangles.add(triangleFromDoubleArray);
        }

        RepositoryInit repositoryInit = new RepositoryInit();
        WarehouseInit warehouseInit = new WarehouseInit();

        repositoryInit.addTriangleToRepositoryAndInit(triangles.get(0));
        warehouseInit.addParametersToWarehouseAndInit(triangles.get(0));

        Repository repository = TriangleRepository.getInstance();
        TriangleWarehouse triangleWarehouse = TriangleWarehouseImpl.getInstance();
        CalculationService calculationService = new CalculationServiceImpl();

        for (int i = 1; i < 4; i++) {
            repository.add(triangles.get(i));
            double perimeter = calculationService.findPerimeter(triangles.get(i));
            double area = calculationService.findArea(triangles.get(i));
            TriangleParameter triangleParameter = new TriangleParameter(area, perimeter);
            long id = triangles.get(i).getTriangleId();
            triangleWarehouse.put(id, triangleParameter);
            LOGGER.log(Level.INFO, triangles.get(i));
        }

        for (int i = 0; i < triangles.size(); i++) {
            long triangleId = triangles.get(i).getTriangleId();
            TriangleParameter triangleParameter = triangleWarehouse.get(triangleId);
            LOGGER.log(Level.INFO, triangleParameter);
        }

    }
}
