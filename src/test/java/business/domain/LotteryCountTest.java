package business.domain;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.assertj.core.api.Assertions.assertThatNoException;

public class LotteryCountTest {

    @ParameterizedTest
    @ValueSource(ints = {-1, -2, Integer.MIN_VALUE})
    void constructor_InvalidParam_ThrowsIllegalArgumentsException(int parameter) {
        assertThatIllegalArgumentException().isThrownBy(() -> new LotteryCount(parameter));
    }

    @ParameterizedTest
    @ValueSource(ints = {0, 1, Integer.MAX_VALUE})
    void constructor_ValidParam_DoesNotThrowIllegalArgumentsException(int parameter) {
        assertThatNoException().isThrownBy(() -> new LotteryCount(parameter));
    }

    @ParameterizedTest
    @ValueSource(ints = {0, 1, Integer.MAX_VALUE})
    void constructor_ValidParam_ReturnsCorrectObject(int parameter) {
        LotteryCount given = new LotteryCount(parameter);
        assertThat(given.getValue()).isEqualTo(parameter);
    }

    @ParameterizedTest
    @ValueSource(ints = {0, 1, Integer.MAX_VALUE})
    void equals_ValueIsSame_ReturnsTrue(int parameter) {
        LotteryCount it = new LotteryCount(parameter);
        LotteryCount that = new LotteryCount(parameter);

        assertThat(it.equals(that)).isTrue();
    }

    @ParameterizedTest
    @ValueSource(ints = {0, 1, Integer.MAX_VALUE - 1})
    void equals_ValueIsNotSame_ReturnsFalse(int parameter) {
        LotteryCount it = new LotteryCount(parameter);
        LotteryCount that = new LotteryCount(parameter + 1);

        assertThat(it.equals(that)).isFalse();
    }

    @ParameterizedTest
    @ValueSource(ints = {0, 1, Integer.MAX_VALUE - 2})
    void sub_ValidParameters_ReturnsCorrectObject(int parameter) {
        LotteryCount it = new LotteryCount(parameter + 2);
        LotteryCount that = new LotteryCount(parameter);

        LotteryCount actual = LotteryCount.sub(it, that);
        LotteryCount expected = new LotteryCount(2);

        assertThat(actual).isEqualTo(expected);
    }

    @ParameterizedTest
    @ValueSource(ints = {0, 1, Integer.MAX_VALUE - 2})
    void sub_InValidParameters_ThrowsIllegalArgumentsException(int parameter) {
        LotteryCount it = new LotteryCount(parameter);
        LotteryCount that = new LotteryCount(parameter + 2);

        assertThatIllegalArgumentException().isThrownBy(() -> LotteryCount.sub(it, that));
    }
}
