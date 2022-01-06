package domain.util;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static domain.util.LotteryConfigs.NUMBERS_LENGTH;
import static org.junit.jupiter.api.Assertions.*;

class LotteryNumbersValidatorTest {

    @Test
    @DisplayName("로또 번호 자릿수는 LotteryConfigs.NUMBERS_LENGTH와 같아야 합니다.")
    void Given_AListOfIntegersOfLongerThanNUMBERSLENGTH_When_ValidateLotteryNumbers_ThenRaiseIllegalArgumentException() {
        // Given
        List<Integer> longerNumbers = IntStream.range(0, NUMBERS_LENGTH + 1).boxed().collect(Collectors.toList());

        // When
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            LotteryNumbersValidator.validate(longerNumbers);
        });

        // Then
        // !!!에러 메지시 하드 코딩되어 있음!!!
        String expectedMessage = "로또 번호 " + longerNumbers + "는 " + NUMBERS_LENGTH + "자리가 아닙니다.";
        String actualMessage = exception.getMessage();
        assertTrue(actualMessage.contains(expectedMessage));
    }
}