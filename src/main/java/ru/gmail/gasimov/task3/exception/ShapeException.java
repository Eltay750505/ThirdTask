package ru.gmail.gasimov.task3.exception;

public class ShapeException extends Exception{
    public ShapeException() {
    }

    public ShapeException(String message) {
        super(message);
    }

    public ShapeException(String message, Throwable cause) {
        super(message, cause);
    }

    public ShapeException(Throwable cause) {
        super(cause);
    }
}
