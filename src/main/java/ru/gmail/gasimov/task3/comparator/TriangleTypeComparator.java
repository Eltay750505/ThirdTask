package ru.gmail.gasimov.task3.comparator;

import ru.gmail.gasimov.task3.entity.Triangle;

import java.util.Comparator;

public class TriangleTypeComparator implements Comparator<Triangle> {
    @Override
    public int compare(Triangle o1, Triangle o2) {
        String firstType = o1.getTriangleType().toString().toLowerCase();
        String secondType = o2.getTriangleType().toString().toLowerCase();
        int compare = firstType.compareTo(secondType);
        return compare;
    }
}
