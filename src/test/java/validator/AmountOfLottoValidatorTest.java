package validator;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;

class AmountOfLottoValidatorTest {
    ValidatorInterface validatorInterface;

    @BeforeEach
    void initialize(){
        validatorInterface = new AmountOfLottoValidator();
    }

    @ParameterizedTest
    @ValueSource(strings = {"abcd", "1234"})
    @DisplayName("로또 금액 입력 실패 테스트")
    void aolvValidateFalseTest(String input) {
        assertThat(validatorInterface.validateData(input)).isFalse();
    }

    @Test
    @DisplayName("로또 금액 입력 성공 테스트")
    void aolvValidateTrueTest(){
        assertThat(validatorInterface.validateData("14000")).isTrue();
    }

}