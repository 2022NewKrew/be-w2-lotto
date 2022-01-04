package lotto;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LottoTest {

    @Test
    void isNumbers() {
        Lotto lotto = new Lotto();
        assertFalse(lotto.isNumbers());
    }

    @Test
    void generateNumbers() {
        Lotto lotto = new Lotto();
        lotto.generateNumbers();
        assertTrue(lotto.isNumbers());
        System.out.println(lotto.getNumbers().toString());
    }
}