package controller.type;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PositiveIntegerTest {

    @Test
    void testParseSuccessfully() {
        int number = PositiveInteger.parse("5");
        assertEquals(number, 5);
    }

    @Test
    void testRemoveWhiteSpace() {
        int number = PositiveInteger.parse("  3  ");
        assertEquals(number, 3);
    }

    @Test
    void testInvalidStringThrowException() {
        assertThrows(IllegalArgumentException.class, () -> {
            PositiveInteger.parse("a");
        });
    }

    @Test
    void testNegativeIntegerThrowException() {
        assertThrows(IllegalArgumentException.class, () -> {
            PositiveInteger.parse("-5");
        });
    }

    @Test
    void testZeroThrowException() {
        assertThrows(IllegalArgumentException.class, () -> {
            PositiveInteger.parse("0");
        });
    }
}
