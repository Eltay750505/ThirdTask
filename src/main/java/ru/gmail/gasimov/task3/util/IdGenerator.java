package ru.gmail.gasimov.task3.util;

public class IdGenerator {
    private static long id;

    private IdGenerator() {

    }

    public static long generateId() {
        return ++id;
    }
}
