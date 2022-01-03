package be.w2.lotto.lottos;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class LottoTest {

    @BeforeEach
    void setUp() {
    }

    @Test
    @DisplayName("해당 번호를 포함하고 있는지 확인 -> 포함하지 않음")
    void isContain_notContain() {
        //Given
        int numberWhichIsNotInLotto = 10;
        List<Integer> numbersOfLotto = Arrays.asList(1, 5, 29, 36, 64, 88);
        Lotto lotto = getInstance(numbersOfLotto);

        //When
        boolean result = lotto.isContain(numberWhichIsNotInLotto);

        //Then
        assertFalse(result);
    }

    @Test
    @DisplayName("해당 번호를 포함하고 있는지 확인 -> 포함")
    void isContain_contain() {
        //Given
        int numberWhichIsInLotto = 15;
        List<Integer> numberOfLotto = Arrays.asList(11, numberWhichIsInLotto, 24, 67, 77, 89);
        Lotto lotto = getInstance(numberOfLotto);

        //When
        boolean result = lotto.isContain(numberWhichIsInLotto);

        //Then
        assertTrue(result);
    }

    @Test
    @DisplayName("toString -> check formatting ( 1, 2, 3, 4, 5, 6)")
    void testToString_1to6() {
        //Given
        List<Integer> numberOfLotto = Arrays.asList(1, 2, 3, 4, 5, 6);
        Lotto lotto = getInstance(numberOfLotto);

        String expected = "[1, 2, 3, 4, 5, 6]";

        //When
        String result = lotto.toString();

        //Then
        assertEquals(expected, result);
    }

    public static Lotto getInstance(List<Integer> numbersOfLotto) {
        return new Lotto(numbersOfLotto);
    }
}