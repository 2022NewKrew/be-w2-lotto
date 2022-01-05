package validator;

import exception.LottoException;

import static org.assertj.core.api.Assertions.assertThat;

public abstract class ValidatorTest {
    public ValidatorTest() {

    }

    void ValidateFalse(ValidatorInterface validatorInterface, String input) {
        boolean exception = false;
        try {
            validatorInterface.validateData(input);
        } catch (LottoException lottoException) {
            exception = true;
        }
        assertThat(exception).isTrue();
    }

    void ValidateTrue(ValidatorInterface validatorInterface, String input) {
        boolean exception = false;
        try {
            validatorInterface.validateData(input);
        } catch (LottoException lottoException) {
            exception = true;
        }
        assertThat(exception).isFalse();
    }
}
