package ru.gmail.gasimov.task3.reader;

import junit.framework.TestCase;
import org.testng.annotations.Test;
import ru.gmail.gasimov.task3.exception.TriangleException;

import static org.testng.Assert.assertThrows;
import static org.testng.internal.junit.ArrayAsserts.assertArrayEquals;

public class TriangleReaderTest extends TestCase {
    private static final String PATH = "src\\test\\resources\\data\\test.txt";
    private static final String WRONG_PATHNAME = "";
    private static final String[] EXPECTED_ARRAY = {
            "235 3232 3520 3",
            "234"
    };

    private static final TriangleReader triangleReader;

    static {
        triangleReader = new TriangleReader();
    }

    @Test
    public void testReadCorrectStringsFromFile() throws TriangleException {
        String[] actual = triangleReader.readCorrectStringsFromFile(PATH);
        assertArrayEquals(EXPECTED_ARRAY, actual);
    }

    @Test()
    public void testReaderException() {
        assertThrows(TriangleException.class, ()-> triangleReader.readCorrectStringsFromFile(WRONG_PATHNAME));
    }
}