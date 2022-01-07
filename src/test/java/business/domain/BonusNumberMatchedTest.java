package business.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class BonusNumberMatchedTest {

    @ParameterizedTest
    @ValueSource(booleans = {true, false})
    void from_ValidParam_ReturnsCorrectObject(boolean parameter) {
        BonusNumberMatched given = BonusNumberMatched.from(parameter);
        assertThat(given.getValue()).isEqualTo(parameter);
    }

    @ParameterizedTest
    @ValueSource(booleans = {true, false})
    void equals_ValueIsSame_ReturnsTrue(boolean parameter) {
        BonusNumberMatched it = BonusNumberMatched.from(parameter);
        BonusNumberMatched that = BonusNumberMatched.from(parameter);

        assertThat(it.equals(that)).isTrue();
    }

    @ParameterizedTest
    @ValueSource(booleans = {true, false})
    void equals_ValueIsNotSame_ReturnsFalse(boolean parameter) {
        BonusNumberMatched it = BonusNumberMatched.from(parameter);
        BonusNumberMatched that = BonusNumberMatched.from(!parameter);

        assertThat(it.equals(that)).isFalse();
    }
}
