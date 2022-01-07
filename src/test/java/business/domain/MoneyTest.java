package business.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.assertj.core.api.Assertions.assertThatNoException;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

public class MoneyTest {

    @ParameterizedTest
    @ValueSource(longs = {-(Integer.MAX_VALUE + 1L) * 1_000L, -1L, 1L, 500L,
        (Integer.MAX_VALUE + 1L) * 1_000L})
    void constructor_InvalidParam_ThrowsIllegalArgumentsException(long parameter) {
        assertThatIllegalArgumentException().isThrownBy(() -> new Money(parameter));
    }

    @ParameterizedTest
    @ValueSource(longs = {-Integer.MAX_VALUE * 1_000L, 0L, 1_000L, Integer.MAX_VALUE * 1_000L})
    void constructor_ValidParam_DoesNotThrowIllegalArgumentsException(long parameter) {
        assertThatNoException().isThrownBy(() -> new Money(parameter));
    }

    @ParameterizedTest
    @ValueSource(longs = {-Integer.MAX_VALUE * 1_000L, 0L, 1_000L, Integer.MAX_VALUE * 1_000L})
    void constructor_ValidParam_ReturnsCorrectObject(long parameter) {
        Money given = new Money(parameter);
        assertThat(given.getValue()).isEqualTo(parameter);
    }

    @ParameterizedTest
    @ValueSource(longs = {-Integer.MAX_VALUE * 1_000L, 0L, 1_000L, Integer.MAX_VALUE * 1_000L})
    void equals_ValueIsSame_ReturnsTrue(long parameter) {
        Money it = new Money(parameter);
        Money that = new Money(parameter);

        assertThat(it.equals(that)).isTrue();
    }

    @ParameterizedTest
    @ValueSource(longs = {-Integer.MAX_VALUE * 1_000L, 0L, 1_000L,
        (Integer.MAX_VALUE - 1L) * 1_000L})
    void equals_ValueIsNotSame_ReturnsFalse(long parameter) {
        Money it = new Money(parameter);
        Money that = new Money(parameter + 1_000L);

        assertThat(it.equals(that)).isFalse();
    }

    @ParameterizedTest
    @ValueSource(longs = {-Integer.MAX_VALUE * 1_000L, 0L, 1_000L,
        (Integer.MAX_VALUE - 1L) * 1_000L})
    void add_ValidParameters_ReturnsCorrectObject(long parameter) {
        Money it = new Money(parameter);
        Money that = new Money(1_000L);

        Money actual = Money.add(it, that);
        Money expected = new Money(parameter + 1_000L);

        assertThat(actual).isEqualTo(expected);
    }

    @ParameterizedTest
    @ValueSource(longs = {1_000L, Integer.MAX_VALUE * 1_000L})
    void add_ExpectedValueOverMaximum_ThrowsIllegalArgumentsException(long parameter) {
        Money it = new Money(parameter);
        Money that = new Money(Integer.MAX_VALUE * 1_000L);

        assertThatIllegalArgumentException().isThrownBy(() -> Money.add(it, that));
    }

    @ParameterizedTest
    @ValueSource(longs = {-Integer.MAX_VALUE * 1_000L, -1_000L})
    void add_ExpectedValueBelowMinimum_ThrowsIllegalArgumentsException(long parameter) {
        Money it = new Money(parameter);
        Money that = new Money(-Integer.MAX_VALUE * 1_000L);

        assertThatIllegalArgumentException().isThrownBy(() -> Money.add(it, that));
    }

    @ParameterizedTest
    @CsvSource(value = {"1000:30", "3000:3000"}, delimiter = ':')
    void multiply_ValidParameters_ReturnsCorrectObject(long value, int multiplier) {
        Money given = new Money(value);

        Money actual = given.multiply(multiplier);
        Money expected = new Money(value * multiplier);

        assertThat(actual).isEqualTo(expected);
    }

    @ParameterizedTest
    @CsvSource(value = {"214748364000:100", "2147483647000:2"}, delimiter = ':')
        // (INT_MAX / 10 * 1_000L : 100), (INT_MAX * 1000 : 2)
    void multiply_ExpectedValueOverMaximum_ThrowsIllegalArgumentsException(long value,
        int multiplier) {
        Money given = new Money(value);

        assertThatIllegalArgumentException().isThrownBy(() -> given.multiply(multiplier));
    }

    @ParameterizedTest
    @CsvSource(value = {"-214748364000:100", "-2147483647000:2"}, delimiter = ':')
        // (-INT_MAX / 10 * 1000 : 100), (-INT_MAX * 1000 : 2)
    void multiply_ExpectedValueBelowMinimum_ThrowsIllegalArgumentsException(long value,
        int multiplier) {
        Money given = new Money(value);

        assertThatIllegalArgumentException().isThrownBy(() -> given.multiply(multiplier));
    }

    @ParameterizedTest
    @ValueSource(longs = {0L, 1_000L, Integer.MAX_VALUE * 1_000L})
    void calculateMaxLotteryCount_InvokedByValidObject_ReturnsCorrectObject(long value) {
        Money given = new Money(value);

        LotteryCount actual = given.calculateMaxLotteryCount();
        LotteryCount expected = new LotteryCount((int) (value / 1000));

        assertThat(actual).isEqualTo(expected);
    }

    @ParameterizedTest
    @ValueSource(longs = {-1_000L, -Integer.MAX_VALUE * 1_000L})
    void calculateMaxLotteryCount_InvokedByInValidObject_ThrowsIllegalArgumentsException(
        long value) {
        Money given = new Money(value);

        assertThatIllegalArgumentException().isThrownBy(given::calculateMaxLotteryCount);
    }
}
