package validator;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class LottoNumberValidatorTest extends ValidatorTest {

    ValidatorInterface validatorInterface;

    @BeforeEach
    void initialize() {
        validatorInterface = new LottoNumberValidator();
    }

    @ParameterizedTest
    @ValueSource(strings = {"1,2,3,4", "0,2,4,6,7,10", "2,4,6,7,10,46"})
    @DisplayName("로또 번호 6개 받기 실패 테스트")
    void ValidateFalseTest(String input) {
        ValidateFalse(validatorInterface, input);
    }

    @Test
    @DisplayName("로또 번호 6개 받기 성공 테스트")
    void ValidateTrueTest() {
        ValidateTrue(validatorInterface, "1,2,3,4,5,6");
    }

}