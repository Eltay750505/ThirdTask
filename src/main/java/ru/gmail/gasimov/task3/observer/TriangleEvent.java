package ru.gmail.gasimov.task3.observer;

import ru.gmail.gasimov.task3.entity.Triangle;

import java.util.EventObject;

public class TriangleEvent extends EventObject {

    public TriangleEvent(Triangle source) {
        super(source);
    }

    @Override
    public Triangle getSource() {
        return (Triangle) super.getSource();
    }
}
