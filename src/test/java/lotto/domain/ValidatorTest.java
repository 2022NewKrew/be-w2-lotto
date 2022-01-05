package lotto.domain;

import lotto.exception.LottoNumberDuplicateException;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

/**
 * Created by melodist
 * Date: 2022-01-05 005
 * Time: 오후 3:46
 */
class ValidatorTest {

    @Test
    public void 로또_수동_갯수_초과(){
        // given
        int lottoCount = 5;
        int manualLottoCount = 10;

        // when, then
        Assertions.assertThatThrownBy(() ->
            Validator.validateManualLottoCount(lottoCount, manualLottoCount)
        ).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 로또_금액_부족() {
        // given
        int purchaseAmount = 50;

        // when, then
        Assertions.assertThatThrownBy(() ->
            Validator.validatePurchaseAmount(purchaseAmount)
        ).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 로또_갯수_안맞음() {
        // given
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);

        // when, then
        Assertions.assertThatThrownBy(() ->
            Validator.validateLottoNumbersLength(numbers)
        ).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 로또_번호_중복_확인() {
        // given
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 1);

        // when, then
        Assertions.assertThatThrownBy(() ->
            Validator.validateLottoNumberDuplicate(numbers)
        ).isInstanceOf(LottoNumberDuplicateException.class);
    }

    @Test
    void 로또_번호_범위_벗어남() {
        // given
        Integer lottoNumber = 99;

        // when, then
        Assertions.assertThatThrownBy(() ->
            Validator.validateLottoNumberRange(lottoNumber)
        ).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 로또_번호_보너스_중복() {
        // given
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        int bonusBall = 1;

        // when, then
        Assertions.assertThatThrownBy(() ->
            Validator.validateLottoBonusDuplicate(numbers, bonusBall)
        ).isInstanceOf(IllegalArgumentException.class);
    }
}
