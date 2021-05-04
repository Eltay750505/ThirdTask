package ru.gmail.gasimov.task3.exception;

public class TriangleException extends Exception {
    public TriangleException() {
    }

    public TriangleException(String message) {
        super(message);
    }

    public TriangleException(Throwable cause) {
        super(cause);
    }

    public TriangleException(String message, Throwable cause) {
        super(message, cause);
    }

    public TriangleException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
