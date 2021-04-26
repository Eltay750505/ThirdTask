package ru.gmail.gasimov.task3.parser;

import ru.gmail.gasimov.task3.exception.ShapeException;

public class TriangleParser {
    public static final String COORDINATE_SEPARATOR = "\\s+";

    public double[] parseTriangle(String correctString) throws ShapeException {
        String[] coordinatesFromTxt = correctString.trim()
                .split(COORDINATE_SEPARATOR);

        if (coordinatesFromTxt.length == 0) {
            throw new ShapeException("Dont have coordinates in this file");
        }

        if (coordinatesFromTxt.length != 6) {
            throw new ShapeException("Wrong amount of coordinates : " + correctString);
        }

        double firstValueX = Double.parseDouble(coordinatesFromTxt[0]);
        double firstValueY = Double.parseDouble(coordinatesFromTxt[1]);
        double secondValueX = Double.parseDouble(coordinatesFromTxt[2]);
        double secondValueY = Double.parseDouble(coordinatesFromTxt[3]);
        double thirdValueX = Double.parseDouble(coordinatesFromTxt[4]);
        double thirdValueY = Double.parseDouble(coordinatesFromTxt[5]);

        double[] resultArray = {firstValueX, firstValueY, secondValueX, secondValueY, thirdValueX, thirdValueY};
        return resultArray;

    }
}
