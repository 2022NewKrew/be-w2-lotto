package ui.validation;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.assertj.core.api.Assertions.assertThatNoException;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

public class InputValidatorTest {

    private static InputValidator inputValidator;

    @BeforeAll
    static void setup() {
        inputValidator = new InputValidator();
    }

    @ParameterizedTest
    @ValueSource(ints = {-1, 0, 46})
    void validateLotteryNumber_InValidParameter_ThrowsIllegalArgumentsException(int parameter) {
        assertThatIllegalArgumentException().isThrownBy(
            () -> inputValidator.validateLotteryNumber(parameter));
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 15, 45})
    void validateLotteryNumber_ValidParameter_DoesNotThrowIllegalArgumentsException(int parameter) {
        assertThatNoException().isThrownBy(() -> inputValidator.validateLotteryNumber(parameter));
    }

    @ParameterizedTest
    @ValueSource(longs = {-1, 0, 500, (Integer.MAX_VALUE + 1L) * 1_000L})
    void validateBudget_InValidParameter_ThrowsIllegalArgumentsException(long parameter) {
        assertThatIllegalArgumentException().isThrownBy(
            () -> inputValidator.validateBudget(parameter));
    }

    @ParameterizedTest
    @ValueSource(longs = {1_000L, 15_000L, Integer.MAX_VALUE * 1_000L})
    void validateBudget_ValidParameter_DoesNotThrowIllegalArgumentsException(long parameter) {
        assertThatNoException().isThrownBy(() -> inputValidator.validateBudget(parameter));
    }

    @ParameterizedTest
    @CsvSource(value = {"-1:300", "116:115", "301:300"}, delimiter = ':')
    void validateLotteryCount_InValidParameters_ThrowsIllegalArgumentsException(int value,
        int limit) {
        assertThatIllegalArgumentException().isThrownBy(
            () -> inputValidator.validateLotteryCount(value, limit));
    }

    @ParameterizedTest
    @CsvSource(value = {"1:300", "115:116", "299:300"}, delimiter = ':')
    void validateLotteryCount_ValidParameters_DoesNotThrowIllegalArgumentsException(int value,
        int limit) {
        assertThatNoException().isThrownBy(() -> inputValidator.validateLotteryCount(value, limit));
    }

    @ParameterizedTest
    @MethodSource("provideInvalidLotteryNumberSet")
    void validateLotteryNumberSet_InValidParameter_ThrowsIllegalArgumentsException(
        Set<Integer> parameter) {
        assertThatIllegalArgumentException().isThrownBy(
            () -> inputValidator.validateLotteryNumberSet(parameter));
    }

    @ParameterizedTest
    @NullAndEmptySource
    void validateLotteryNumberSet_NullAndEmptyParameter_ThrowsIllegalArgumentsException(
        Set<Integer> parameter) {
        assertThatIllegalArgumentException().isThrownBy(
            () -> inputValidator.validateLotteryNumberSet(parameter));
    }

    @ParameterizedTest
    @MethodSource("provideValidLotteryNumberSet")
    void validateLotteryNumberSet_ValidParameter_DoesNotThrowIllegalArgumentsException(
        Set<Integer> parameter) {
        assertThatNoException().isThrownBy(
            () -> inputValidator.validateLotteryNumberSet(parameter));
    }

    @ParameterizedTest
    @NullAndEmptySource
    void validateLotteryNumberSetList_NullAndEmptyParameter_ThrowsIllegalArgumentsException(
        List<Set<Integer>> parameter) {
        assertThatIllegalArgumentException().isThrownBy(
            () -> inputValidator.validateLotteryNumberSetList(parameter));
    }

    private static Stream<Arguments> provideInvalidLotteryNumberSet() {
        return Stream.of(
            Arguments.of(IntStream.rangeClosed(1, 5).boxed().collect(Collectors.toSet())),
            Arguments.of(IntStream.rangeClosed(1, 7).boxed().collect(Collectors.toSet())),
            Arguments.of(IntStream.rangeClosed(46, 51).boxed().collect(Collectors.toSet())),
            Arguments.of(IntStream.rangeClosed(-1, 5).boxed().collect(Collectors.toSet())),
            Arguments.of(IntStream.rangeClosed(41, 46).boxed().collect(Collectors.toSet())));
    }

    private static Stream<Arguments> provideValidLotteryNumberSet() {
        return Stream.of(
            Arguments.of(IntStream.rangeClosed(1, 6).boxed().collect(Collectors.toSet())),
            Arguments.of(IntStream.rangeClosed(15, 20).boxed().collect(Collectors.toSet())),
            Arguments.of(IntStream.rangeClosed(27, 32).boxed().collect(Collectors.toSet())),
            Arguments.of(IntStream.rangeClosed(36, 41).boxed().collect(Collectors.toSet())),
            Arguments.of(IntStream.rangeClosed(40, 45).boxed().collect(Collectors.toSet())));
    }
}
