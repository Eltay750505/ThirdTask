package ru.gmail.gasimov.task3.reader;

import ru.gmail.gasimov.task3.exception.TriangleException;
import ru.gmail.gasimov.task3.validator.StringValidator;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.InvalidPathException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class TriangleReader {
    public String[] readCorrectStringsFromFile(String filePath) throws TriangleException {
        if (filePath == null || filePath.isEmpty()){
            throw new TriangleException("Passed wrong pathName : " + filePath);
        }
            try {
                Path path = Paths.get(filePath);

                try (Stream<String> stream = Files.lines(path)) {
                    String[] validStrings = stream.filter(StringValidator::validateString)
                            .toArray(String[]::new);

                    if (validStrings.length == 0) {
                        throw new TriangleException("There is no correct strings in file : " + filePath);
                    }

                    return validStrings;
                }
            } catch (InvalidPathException | IOException e) {
                throw new TriangleException("Cannot Open current file: " + filePath, e);
            }
    }
}
