package ru.gmail.gasimov.task3.comparator;

import ru.gmail.gasimov.task3.entity.Triangle;

import java.util.Comparator;

public class FirstPointXComparator implements Comparator<Triangle> {
    @Override
    public int compare(Triangle o1, Triangle o2) {
        double firstX = o1.getFirstPoint().getX();
        double secondX = o2.getFirstPoint().getX();
        int result = Double.compare(firstX, secondX);
        return result;
    }
}
