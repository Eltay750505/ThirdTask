package ru.gmail.gasimov.task3.repository;

import java.util.Collection;
import java.util.Comparator;
import java.util.List;

public interface Repository<T> {
    boolean add(T item);
    boolean remove(T item);
    boolean addAll(Collection<? extends T> items);
    boolean removeAll(Collection<? extends T> items);
    T get(int index);
    void set(int index, T item);
    void clear();
    List<T> query(Specification<T> specification);
    List<T> queryStream(Specification<T> specification);
    List<T> sort(Comparator<? super T> comparator);
}
