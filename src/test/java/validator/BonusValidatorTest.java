package validator;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.ArrayList;
import java.util.List;

class BonusValidatorTest extends ValidatorTest {
    ValidatorInterface validatorInterface;

    @BeforeEach
    void initialize() {
        List<Integer> winningNumbers = new ArrayList<>();
        winningNumbers.add(1);
        winningNumbers.add(2);
        winningNumbers.add(3);
        winningNumbers.add(4);
        winningNumbers.add(5);
        winningNumbers.add(6);
        validatorInterface = new BonusValidator(winningNumbers);
    }

    @ParameterizedTest
    @ValueSource(strings = {"abcd", "0", "46", "1"})
    @DisplayName("보너스 볼 입력 실패 테스트")
    void ValidateFalseTest(String input) {
        ValidateFalse(validatorInterface, input);
    }

    @Test
    @DisplayName("보너스 볼 입력 성공 테스트")
    void ValidateTrueTest() {
        ValidateTrue(validatorInterface, "10");
    }

}