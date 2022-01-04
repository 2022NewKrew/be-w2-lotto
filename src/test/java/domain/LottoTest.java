package domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LottoTest {
    Lotto lotto;

    @Test
    void testRangeValidIn10000Tries() {
        int MIN_VALUE = 1;
        int MAX_VALUE = 45;
        boolean minExist = false;
        boolean maxExist = false;
        int numOfTries = 0;
        do {
            lotto = Lotto.generateRandomly();
            minExist |= lotto.getNumbers().contains(MIN_VALUE);
            maxExist |= lotto.getNumbers().contains(MAX_VALUE);
            numOfTries += 1;
        } while (!minExist || !maxExist && numOfTries < 10000);
        assertTrue(numOfTries < 10000);
    }
}