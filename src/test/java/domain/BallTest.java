package domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;

class BallTest {
    public static final int MIN_LOTTO_NUMBER = 1;
    public static final int MAX_LOTTO_NUMBER = 45;

    @DisplayName("1~45의 범위가 아닌 값 주입 시 에러 발생 검증")
    @Test
    void assertInvalidNumberException() {
        assertThrows(IllegalArgumentException.class, () -> Ball.create(MIN_LOTTO_NUMBER - 1));
        assertThrows(IllegalArgumentException.class, () -> Ball.create(MAX_LOTTO_NUMBER + 1));
    }
}