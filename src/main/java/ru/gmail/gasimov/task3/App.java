package ru.gmail.gasimov.task3;

import ru.gmail.gasimov.task3.comparator.FirstPointYComparator;
import ru.gmail.gasimov.task3.creator.TriangleCreator;
import ru.gmail.gasimov.task3.entity.Point;
import ru.gmail.gasimov.task3.entity.Triangle;
import ru.gmail.gasimov.task3.entity.TriangleParameter;
import ru.gmail.gasimov.task3.exception.TriangleException;
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


public class App {
    public static void main(String[] args) throws TriangleException {
        TriangleReader triangleReader = new TriangleReader();
        String[] strings = triangleReader.readCorrectStringsFromFile("src\\main\\resources\\data\\numbers.txt");
        TriangleParser triangleParser = new TriangleParser();
        TriangleCreator triangleCreator = new TriangleCreator();
        List<Triangle> triangles = new ArrayList<>();

        for (int i = 0; i < strings.length; i++) {
            double[] doubles = triangleParser.parseTriangle(strings[i]);
            Triangle triangleFromDoubleArray = triangleCreator.createTriangleFromDoubleArray(doubles);
            triangleFromDoubleArray.attachObserver(new TriangleObserverImpl());
            triangles.add(triangleFromDoubleArray);
            System.out.println(triangleFromDoubleArray);
        }

        RepositoryInit repositoryInitializer = new RepositoryInit();
        WarehouseInit warehouseInitializer = new WarehouseInit();
        repositoryInitializer.addTriangleToRepositoryAndInit(triangles.get(0));
        warehouseInitializer.addParametersToWarehouseAndInit(triangles.get(0));

        Repository<Triangle> repository = TriangleRepository.getInstance();
        TriangleWarehouse triangleWarehouse = TriangleWarehouseImpl.getInstance();

        for (int i = 1; i < 4; i++) {
            CalculationService service = new CalculationServiceImpl();
            double perimeter = service.findPerimeter(triangles.get(i));
            double area = service.findArea(triangles.get(i));
            TriangleParameter triangleParameter = new TriangleParameter(area, perimeter);
            triangleWarehouse.put(triangles.get(1).getTriangleId(), triangleParameter);
            //System.out.println(triangleParameter);
        }

        repository.add(triangles.get(1));
        repository.add(triangles.get(2));
        repository.add(triangles.get(3));

        System.out.println(triangleWarehouse.get(triangles.get(0).getTriangleId()));

        repository.get(0).setFirstPoint(new Point(3, 2));

        System.out.println(triangleWarehouse.get(triangles.get(0).getTriangleId()));

        repository.get(0).setFirstPoint(new Point(2, 2));

        System.out.println(triangleWarehouse.get(triangles.get(0).getTriangleId()));

        List<Triangle> sort = repository.sort(new FirstPointYComparator());

        for (int i = 0; i < sort.size(); i++) {
            System.out.println(sort.get(i));
        }

        //Specification typeSpecification = new TriangleTypeSpecification("arbitrary");
        // Specification specification = new TriangleAreaSpecification(4, 12);
        // List query = repository.query(typeSpecification);
        //List query1 = repository.query(specification);


    }
}
