package ru.gmail.gasimov.task3.observer;

public interface TriangleObservable {
    void attachObserver(TriangleObserver triangleObserver);
    void detachObserver();
    void notifyObserver();
}
