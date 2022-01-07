package business.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.assertj.core.api.Assertions.assertThatNoException;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class LotteryNumberTest {

    @ParameterizedTest
    @ValueSource(ints = {-1, 0, 46})
    void from_InvalidParam_ThrowsIllegalArgumentsException(int parameter) {
        assertThatIllegalArgumentException().isThrownBy(() -> LotteryNumber.from(parameter));
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 15, 45})
    void from_ValidParam_DoesNotThrowIllegalArgumentsException(int parameter) {
        assertThatNoException().isThrownBy(() -> LotteryNumber.from(parameter));
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 15, 45})
    void from_ValidParam_ReturnsCorrectObject(int parameter) {
        LotteryNumber given = LotteryNumber.from(parameter);
        assertThat(given.getValue()).isEqualTo(parameter);
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 15, 45})
    void equals_ValueIsSame_ReturnsTrue(int parameter) {
        LotteryNumber it = LotteryNumber.from(parameter);
        LotteryNumber that = LotteryNumber.from(parameter);

        assertThat(it.equals(that)).isTrue();
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 15, 44})
    void equals_ValueIsNotSame_ReturnsFalse(int parameter) {
        LotteryNumber it = LotteryNumber.from(parameter);
        LotteryNumber that = LotteryNumber.from(parameter + 1);

        assertThat(it.equals(that)).isFalse();
    }
}
