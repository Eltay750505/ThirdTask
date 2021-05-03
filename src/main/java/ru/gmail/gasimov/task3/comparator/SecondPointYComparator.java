package ru.gmail.gasimov.task3.comparator;

import ru.gmail.gasimov.task3.entity.Triangle;

import java.util.Comparator;

public class SecondPointYComparator implements Comparator<Triangle> {
    @Override
    public int compare(Triangle o1, Triangle o2) {
        double firstX = o1.getSecondPoint().getY();
        double secondX = o2.getSecondPoint().getY();
        int result = Double.compare(firstX, secondX);
        return result;
    }
}
