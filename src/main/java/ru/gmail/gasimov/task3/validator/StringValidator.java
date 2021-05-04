package ru.gmail.gasimov.task3.validator;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.regex.Pattern;

public class StringValidator {
    private static Logger logger = LogManager.getLogger();
    private static final String PARAMS_PATTERN = "\\s*\\d*\\s*\\d*\\s*\\d*\\s*\\d*\\s*\\d*\\s*\\d*\\s*";

    public static boolean validateString(String paramsString) {
        if (paramsString == null || paramsString.equals("")) {
            logger.error("String cannot be empty");
            return false;
        }

        return Pattern.matches(PARAMS_PATTERN, paramsString);
    }
}
