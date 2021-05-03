package ru.gmail.gasimov.task3.comparator;

import ru.gmail.gasimov.task3.entity.Triangle;

import java.util.Comparator;

public class ThirdPointXComparator implements Comparator<Triangle> {
    @Override
    public int compare(Triangle o1, Triangle o2) {
        double firstX = o1.getThirdPoint().getX();
        double secondX = o2.getThirdPoint().getX();
        int result = Double.compare(firstX, secondX);
        return result;
    }
}
