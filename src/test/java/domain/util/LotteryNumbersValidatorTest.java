package domain.util;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static domain.util.LotteryConfigs.*;
import static org.junit.jupiter.api.Assertions.*;

class LotteryNumbersValidatorTest {

    @Test
    @DisplayName("로또 번호 자릿수는 LotteryConfigs.NUMBERS_LENGTH와 같아야 합니다.")
    void Given_AListOfIntegersNotOfNumbersLength_When_ValidateLotteryNumbers_ThenRaiseIllegalArgumentException() {
        // Given
        List<Integer> shorterNumbers = IntStream.range(0, NUMBERS_LENGTH -1).boxed().collect(Collectors.toList());
        List<Integer> longerNumbers = IntStream.range(0, NUMBERS_LENGTH + 1).boxed().collect(Collectors.toList());

        // When
        Exception exceptionForShorterNumbers = assertThrows(IllegalArgumentException.class, () -> {
            LotteryNumbersValidator.validate(shorterNumbers);
        });
        Exception exceptionForLongerNumbers = assertThrows(IllegalArgumentException.class, () -> {
            LotteryNumbersValidator.validate(longerNumbers);
        });

        // Then
        // !!!에러 메지시 하드 코딩되어 있음!!!
        String expectedMessage = "로또 번호 " + shorterNumbers + "는 " + NUMBERS_LENGTH + "자리가 아닙니다.";
        String actualMessage = exceptionForShorterNumbers.getMessage();
        assertTrue(actualMessage.contains(expectedMessage));

        expectedMessage = "로또 번호 " + longerNumbers + "는 " + NUMBERS_LENGTH + "자리가 아닙니다.";
        actualMessage = exceptionForLongerNumbers.getMessage();
        assertTrue(actualMessage.contains(expectedMessage));
    }

    @Test
    @DisplayName("로또 번호는 LotteryConfigs.NUMBERS_DOMAIN 안에 있어야 합니다.")
    void Given_AListOfIntegersNotInNumbersDomain_When_ValidateLotteryNumbers_ThenRaiseIllegalArgumentException() {
        // Given
        // Assumes NUMBERS_DOMAIN to be a single interval
        // Both bound is tested
        List<Integer> outOfBoundNumbers = IntStream.range(NUMBER_DOMAIN_START - 1, NUMBERS_LENGTH - 1).boxed().collect(Collectors.toList());
        outOfBoundNumbers.add(NUMBER_DOMAIN_END + 1);

        // When
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            LotteryNumbersValidator.validate(outOfBoundNumbers);
        });

        // Then
        // !!!에러 메지시 하드 코딩되어 있음!!!
        String partialExpectedMessage = " 는 로또 번호 범위(";
        String actualMessage = exception.getMessage();
        assertTrue(actualMessage.contains(partialExpectedMessage));
    }

    @Test
    @DisplayName("로또 번호는 중복이 없어야 합니다.")
    void Given_AListOfIntegerWithRepetition_When_ValidateLotteryNumbers_ThenRaiseIllegalArgumentException() {
        // Given
        List<Integer> repeatedNumbers = IntStream.range(NUMBER_DOMAIN_START, NUMBER_DOMAIN_START + NUMBERS_LENGTH - 1).boxed().collect(Collectors.toList());
        repeatedNumbers.add(NUMBER_DOMAIN_START);

        // When
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            LotteryNumbersValidator.validate(repeatedNumbers);
        });

        // Then
        // !!!에러 메지시 하드 코딩되어 있음!!!
        String expectedMessage = "로또 번호 " + repeatedNumbers + "에 중복이 있습니다.";
        String actualMessage = exception.getMessage();
        assertTrue(actualMessage.contains(expectedMessage));
    }
}