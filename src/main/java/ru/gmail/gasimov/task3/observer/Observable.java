package ru.gmail.gasimov.task3.observer;

public interface Observable {
    void attachObserver(TriangleObserver triangleObserver);
    void detachObserver();
    void notifyObserver();
}
