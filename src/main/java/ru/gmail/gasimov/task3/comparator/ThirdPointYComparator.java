package ru.gmail.gasimov.task3.comparator;

import ru.gmail.gasimov.task3.entity.Triangle;

import java.util.Comparator;

public class ThirdPointYComparator implements Comparator<Triangle> {
    @Override
    public int compare(Triangle o1, Triangle o2) {
        double firstX = o1.getThirdPoint().getY();
        double secondX = o2.getThirdPoint().getY();
        int result = Double.compare(firstX, secondX);
        return result;
    }
}
