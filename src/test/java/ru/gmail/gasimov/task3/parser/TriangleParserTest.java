package ru.gmail.gasimov.task3.parser;

import junit.framework.TestCase;
import org.testng.annotations.Test;
import ru.gmail.gasimov.task3.exception.TriangleException;

import static org.testng.Assert.assertThrows;
import static org.testng.internal.junit.ArrayAsserts.assertArrayEquals;


public class TriangleParserTest extends TestCase {
    private static final TriangleParser triangleParser;
    private static final String WRONG_STRING = "124 244 -4";
    private static final String CORRECT_STRING = "1 2 3 4 5 6";
    private static final double[] actualArray = {1, 2, 3, 4, 5, 6};


    static {
        triangleParser = new TriangleParser();
    }

    @Test()
    public void testParseTriangleException() {
        assertThrows(TriangleException.class, () -> triangleParser.parseString(WRONG_STRING));
    }

    @Test
    public void testParser() throws TriangleException {
        double[] parsedString = triangleParser.parseString(CORRECT_STRING);
        assertArrayEquals(actualArray, parsedString, 0.001);
    }
}