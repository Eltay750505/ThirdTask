package ru.gmail.gasimov.task3.init;

import ru.gmail.gasimov.task3.entity.Triangle;
import ru.gmail.gasimov.task3.repository.Repository;
import ru.gmail.gasimov.task3.repository.impl.TriangleRepository;

public class RepositoryInitializer {
    public void addTriangleToRepositoryAndInit(Triangle triangle) {
        Repository<Triangle> repository = TriangleRepository.getInstance();
        repository.add(triangle);
    }
}
