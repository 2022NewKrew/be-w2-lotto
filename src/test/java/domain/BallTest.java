package domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BallTest {
    public static final int MAX_LOTTO_NUMBER = 45;

    @DisplayName("1~45의 범위가 아닌 값 주입 시 에러 발생 검증")
    @Test
    void assertInvalidNumberException() {
        assertThrows(IllegalArgumentException.class, () -> new Ball(MAX_LOTTO_NUMBER + 1));
    }
}