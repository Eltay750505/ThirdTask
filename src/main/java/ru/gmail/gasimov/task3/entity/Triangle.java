package ru.gmail.gasimov.task3.entity;


import ru.gmail.gasimov.task3.observer.Observable;
import ru.gmail.gasimov.task3.observer.TriangleEvent;
import ru.gmail.gasimov.task3.observer.TriangleObserver;
import ru.gmail.gasimov.task3.util.IdGenerator;

import java.util.Objects;

public class Triangle implements Observable {
    private final long shapeId;

    private Point firstPoint;
    private Point secondPoint;
    private Point thirdPoint;
    private TriangleType triangleType;
    private TriangleObserver triangleObserver;


    public Triangle() {
    }

    public TriangleType getTriangleType() {
        return triangleType;
    }

    public void setTriangleType(TriangleType triangleType) {
        this.triangleType = triangleType;
    }

    public TriangleObserver getTriangleObserver() {
        return triangleObserver;
    }

    public void setTriangleObserver(TriangleObserver triangleObserver) {
        this.triangleObserver = triangleObserver;
    }

    {
        this.triangleObserver = null;
        this.shapeId = IdGenerator.generateId();
    }

    public long getShapeId() {
        return shapeId;
    }

    public Point getFirstPoint() {
        return firstPoint;
    }

    public void setFirstPoint(Point firstPoint) {
        this.firstPoint = firstPoint;
    }

    public Point getSecondPoint() {
        return secondPoint;
    }

    public void setSecondPoint(Point secondPoint) {
        this.secondPoint = secondPoint;
    }

    public Point getThirdPoint() {
        return thirdPoint;
    }

    public void setThirdPoint(Point thirdPoint) {
        this.thirdPoint = thirdPoint;
    }

    @Override
    public void attachObserver(TriangleObserver triangleObserver) {
        this.triangleObserver = triangleObserver;

    }

    @Override
    public void detachObserver() {
        this.triangleObserver = null;
    }

    @Override
    public void notifyObserver() {
        if (triangleObserver != null) {
            triangleObserver.parametersChanged(new TriangleEvent(this));
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Triangle triangle = (Triangle) o;
        return shapeId == triangle.shapeId &&
                Objects.equals(firstPoint, triangle.firstPoint) &&
                Objects.equals(secondPoint, triangle.secondPoint) &&
                Objects.equals(thirdPoint, triangle.thirdPoint) &&
                Objects.equals(triangleType, triangle.triangleType);
    }

    @Override
    public int hashCode() {
        int prime = 31;
        int result = 1;

        result = result * prime + firstPoint.hashCode();
        result = result * prime + secondPoint.hashCode();
        result = result * prime + thirdPoint.hashCode();
        result = result * prime + triangleType.hashCode();

        return result;
    }
}
