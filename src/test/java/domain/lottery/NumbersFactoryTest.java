package domain.lottery;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

class NumbersFactoryTest {

    @Test
    @DisplayName("로또 번호 자리수 검증이 작동해야 합니다.")
    void givenListOfIntegers_whenMakingLotteryNumbers_thenValidateNumberOfIntegers() {
        // Given
        List<Integer> invalidNumbers = List.of(1, 2, 3, 4, 5, 6, 7);
        NumbersFactory numbersFactory = new NumbersFactory();

        // When
        IllegalArgumentException thrown = assertThrows(
                IllegalArgumentException.class,
                () -> numbersFactory.getValidatedNumbers(invalidNumbers),
                "로또 번호가 자릿수에 맞지 않는데 exception이 발생하지 않았다."
        );

        // Then
        assertTrue(thrown.getMessage().contains("자리"));
    }
}