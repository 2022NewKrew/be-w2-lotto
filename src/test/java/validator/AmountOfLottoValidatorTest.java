package validator;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class AmountOfLottoValidatorTest extends ValidatorTest {
    ValidatorInterface validatorInterface;

    @BeforeEach
    void initialize() {
        validatorInterface = new AmountOfLottoValidator();
    }

    @ParameterizedTest
    @ValueSource(strings = {"abcd", "1234"})
    @DisplayName("로또 금액 입력 실패 테스트")
    void ValidateFalseTest(String input) {
        ValidateFalse(validatorInterface, input);
    }

    @Test
    @DisplayName("로또 금액 입력 성공 테스트")
    void ValidateTrueTest() {
        ValidateTrue(validatorInterface, "14000");
    }

}