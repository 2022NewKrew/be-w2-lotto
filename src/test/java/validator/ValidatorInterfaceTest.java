package validator;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class ValidatorInterfaceTest {

    ValidatorInterface amountOfLottoValidator, lottoNumberValidator;

    @Test
    @DisplayName("1000의 배수인 자연수인 경우에만 통과")
    void aolvValidateTest() {
        amountOfLottoValidator = new AmountOfLottoValidator();
        assertThat(amountOfLottoValidator.validateData("abcd")).isEqualTo(false);
        assertThat(amountOfLottoValidator.validateData("1234")).isEqualTo(false);
        assertThat(amountOfLottoValidator.validateData("1000")).isEqualTo(true);
    }

    @Test
    @DisplayName("6개의 1~45사이 숫자 받기")
    void lnvValidateTest() {
        lottoNumberValidator = new LottoNumberValidator();
        assertThat(lottoNumberValidator.validateData("1,2,3,4,")).isEqualTo(false);
        assertThat(lottoNumberValidator.validateData("0,2,4,6,8,10")).isEqualTo(false);
        assertThat(lottoNumberValidator.validateData("2,4,6,8,10,46")).isEqualTo(false);
        assertThat(lottoNumberValidator.validateData("1,2,3,4,5,6")).isEqualTo(true);
    }
}