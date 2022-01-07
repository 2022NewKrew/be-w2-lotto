package business.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.assertj.core.api.Assertions.assertThatNoException;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class MatchCountTest {

    @ParameterizedTest
    @ValueSource(ints = {-1, 7})
    void from_InvalidParam_ThrowsIllegalArgumentsException(int parameter) {
        assertThatIllegalArgumentException().isThrownBy(() -> MatchCount.from(parameter));
    }

    @ParameterizedTest
    @ValueSource(ints = {0, 1, 2, 3, 4, 5, 6})
    void from_ValidParam_DoesNotThrowIllegalArgumentsException(int parameter) {
        assertThatNoException().isThrownBy(() -> MatchCount.from(parameter));
    }

    @ParameterizedTest
    @ValueSource(ints = {0, 1, 2, 3, 4, 5, 6})
    void from_ValidParam_ReturnsCorrectObject(int parameter) {
        MatchCount given = MatchCount.from(parameter);
        assertThat(given.getValue()).isEqualTo(parameter);
    }

    @ParameterizedTest
    @ValueSource(ints = {0, 1, 2, 3, 4, 5, 6})
    void equals_ValueIsSame_ReturnsTrue(int parameter) {
        MatchCount it = MatchCount.from(parameter);
        MatchCount that = MatchCount.from(parameter);

        assertThat(it.equals(that)).isTrue();
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3, 4, 5, 6})
    void equals_ValueIsNotSame_ReturnsFalse(int parameter) {
        MatchCount it = MatchCount.from(parameter);
        MatchCount that = MatchCount.from(parameter - 1);

        assertThat(it.equals(that)).isFalse();
    }
}
