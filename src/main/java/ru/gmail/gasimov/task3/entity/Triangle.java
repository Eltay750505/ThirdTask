package ru.gmail.gasimov.task3.entity;


import ru.gmail.gasimov.task3.observer.TriangleEvent;
import ru.gmail.gasimov.task3.observer.TriangleObservable;
import ru.gmail.gasimov.task3.observer.TriangleObserver;
import ru.gmail.gasimov.task3.util.IdGenerator;

import java.util.Objects;

public class Triangle implements TriangleObservable {
    private final long triangleId;
    private Point firstPoint;
    private Point secondPoint;
    private Point thirdPoint;
    private TriangleType triangleType;
    private TriangleObserver triangleObserver;

    {
        this.triangleObserver = null;
        this.triangleId = IdGenerator.generateId();
    }

    public Triangle() {
    }

    public Triangle(Point firstPoint, Point secondPoint, Point thirdPoint) {
        this.firstPoint = firstPoint;
        this.secondPoint = secondPoint;
        this.thirdPoint = thirdPoint;
    }

    public TriangleType getTriangleType() {
        return triangleType;
    }

    public void setTriangleType(TriangleType triangleType) {
        this.triangleType = triangleType;
        notifyObserver();
    }

    public TriangleObserver getTriangleObserver() {
        return triangleObserver;
    }

    public long getTriangleId() {
        return triangleId;
    }

    public Point getFirstPoint() {
        return firstPoint;
    }

    public void setFirstPoint(Point firstPoint) {
        this.firstPoint = firstPoint;
        notifyObserver();
    }

    public Point getSecondPoint() {
        return secondPoint;
    }

    public void setSecondPoint(Point secondPoint) {
        this.secondPoint = secondPoint;
        notifyObserver();
    }

    public Point getThirdPoint() {
        return thirdPoint;
    }

    public void setThirdPoint(Point thirdPoint) {
        this.thirdPoint = thirdPoint;
        notifyObserver();
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
        return triangleId == triangle.triangleId &&
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

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Triangle{");
        sb.append("triangleId=").append(triangleId);
        sb.append(", firstPoint=").append(firstPoint);
        sb.append(", secondPoint=").append(secondPoint);
        sb.append(", thirdPoint=").append(thirdPoint);
        sb.append(", triangleType=").append(triangleType);
        sb.append('}');
        return sb.toString();
    }
}
