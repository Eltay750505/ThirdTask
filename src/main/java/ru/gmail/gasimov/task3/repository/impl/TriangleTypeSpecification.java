package ru.gmail.gasimov.task3.repository.impl;

import ru.gmail.gasimov.task3.entity.Triangle;
import ru.gmail.gasimov.task3.repository.Specification;

public class TriangleTypeSpecification implements Specification<Triangle> {
    private String substring;

    public TriangleTypeSpecification(String substring) {
        this.substring = substring;
    }

    @Override
    public boolean specify(Triangle item) {
        String triangleType = item.getTriangleType().toString().toLowerCase();
        boolean result = triangleType.contains(substring);
        return result;
    }
}
