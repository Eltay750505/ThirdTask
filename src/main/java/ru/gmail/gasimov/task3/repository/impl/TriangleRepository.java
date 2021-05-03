package ru.gmail.gasimov.task3.repository.impl;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import ru.gmail.gasimov.task3.entity.Triangle;
import ru.gmail.gasimov.task3.repository.Repository;
import ru.gmail.gasimov.task3.repository.Specification;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;


public class TriangleRepository implements Repository<Triangle> {
    private static final TriangleRepository instance = new TriangleRepository();
    private List<Triangle> collection;

    private TriangleRepository() {
        collection = new ArrayList<>();
    }

    public static TriangleRepository getInstance() {
        return instance;
    }

    @Override
    public boolean add(Triangle item) {
        return collection.add(item);
    }

    @Override
    public boolean remove(Triangle item) {
        return collection.remove(item);
    }

    @Override
    public boolean addAll(Collection<? extends Triangle> items) {
        return collection.addAll(items);
    }

    @Override
    public boolean removeAll(Collection<? extends Triangle> items) {
        return collection.removeAll(items);
    }

    @Override
    public Triangle get(int index) {
        return collection.get(index);
    }

    @Override
    public void set(int index, Triangle item) {
        collection.set(index, item);
    }

    @Override
    public void clear() {
        collection.clear();
    }

    @Override
    public List query(Specification specification) {
        List<Triangle> result = new ArrayList<>();

        for (Triangle item : collection) {
            if (specification.specify(item)) {
                result.add(item);
            }
        }

        return result;
    }

    @Override
    public List<Triangle> queryStream(Specification<Triangle> specification) {
        List<Triangle> result = collection.stream()
                .filter(specification::specify)
                .collect(Collectors.toList());
        return result;
    }

    @Override
    public List sort(Comparator<? super Triangle> comparator) {
        List<Triangle> result = collection.stream()
                .sorted(comparator)
                .collect(Collectors.toList());
        return result;
    }
}
