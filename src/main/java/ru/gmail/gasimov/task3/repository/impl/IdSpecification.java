package ru.gmail.gasimov.task3.repository.impl;

import ru.gmail.gasimov.task3.entity.Triangle;
import ru.gmail.gasimov.task3.repository.Specification;

public class IdSpecification<T> implements Specification<Triangle> {
    private long id;

    public IdSpecification(long id) {
        this.id = id;
    }

    @Override
    public boolean specify(Triangle item) {
        if (item == null) {
            return false;
        }

        return item.getTriangleId() == id;
    }
}
