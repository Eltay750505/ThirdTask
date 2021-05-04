package ru.gmail.gasimov.task3.validator;

import org.junit.Test;

import static junit.framework.TestCase.assertFalse;
import static junit.framework.TestCase.assertTrue;

public class StringValidatorTest {
    private static final String EMPTY_STRING = "";


    @Test
    public void validatorStringFalseTest() {
        boolean expected = StringValidator.validateString(EMPTY_STRING);
        assertFalse(expected);
    }

    @Test
    public void validatorStringNullTest() {
        boolean expected = StringValidator.validateString(null);
        assertFalse(expected);
    }

    @Test
    public void testCorrectString() {
        String testString = "1 2 3 4 5 6";
        boolean isCorrect = StringValidator.validateString(testString);
        assertTrue(isCorrect);
    }

    @Test
    public void testInCorrectString() {
        String testString = "ye qw 13 124 5teq 6 7 5yt-91 ";
        boolean isCorrect = StringValidator.validateString(testString);
        assertFalse(isCorrect);
    }
}