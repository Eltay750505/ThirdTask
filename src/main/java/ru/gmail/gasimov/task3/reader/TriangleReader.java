package ru.gmail.gasimov.task3.reader;

import ru.gmail.gasimov.task3.exception.ShapeException;
import ru.gmail.gasimov.task3.validator.TriangleValidator;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.InvalidPathException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class TriangleReader {
    public String[] readCorrectStringsFromFile(String filePath) throws ShapeException {
        try {
            Path path = Paths.get(filePath);

            try (Stream<String> stream = Files.lines(path)) {
                String[] validStrings = stream.filter(TriangleValidator::validateString)
                        .toArray(String[]::new);

                if (validStrings.length == 0) {
                    throw new ShapeException("There is no correct strings in file : " + filePath);
                }

                return validStrings;
            }
        } catch (InvalidPathException | IOException e) {
            throw new ShapeException("Cannot Open current file: " + filePath, e);
        }
    }
}
