package ru.gmail.gasimov.task3.repository;

public interface Specification<T> {
    boolean specify(T item);
}
