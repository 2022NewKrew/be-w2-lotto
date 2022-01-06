package controller.type;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class PositiveIntegerArrayListTest {

    @Test
    void testParseSuccessfully() {
        ArrayList<Integer> numbers = PositiveIntegerArrayList.parse("1,2,3,4,5,6");
        ArrayList<Integer> answer = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6));
        assertEquals(numbers, answer);
    }

    @Test
    void testRemoveWhiteSpace() {
        ArrayList<Integer> numbers = PositiveIntegerArrayList.parse("  1,2, 3 ,4  ");
        ArrayList<Integer> answer = new ArrayList<>(Arrays.asList(1, 2, 3, 4));
        assertEquals(numbers, answer);
    }

    @Test
    void testInvalidStringThrowException() {
        assertThrows(IllegalArgumentException.class, () -> {
            PositiveIntegerArrayList.parse("1,2,c");
        });
    }

    @Test
    void testNegativeIntegerThrowException() {
        assertThrows(IllegalArgumentException.class, () -> {
            PositiveIntegerArrayList.parse("1,2,3,-4");
        });
    }

    @Test
    void testZeroThrowException() {
        assertThrows(IllegalArgumentException.class, () -> {
            PositiveIntegerArrayList.parse("1,2,0,4");
        });
    }
}
