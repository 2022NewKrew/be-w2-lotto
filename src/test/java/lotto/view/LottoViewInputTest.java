package lotto.view;

import lotto.domain.Lotto;
import lotto.domain.LottoNumber;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static lotto.domain.LottoSetting.*;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

class LottoViewInputTest {

    @Test
    void lottoInputPayment() {
    }


    @Test
    void lottoInputUserMakeCount() {
    }

    @Test
    @DisplayName("6개의_숫자로_이루어진_로또_번호가_아닌_경우_예외_발생")
    void resultToList_1() {
        //given
        String stringAry = "1,2,3,4,5";

        //when
        //사용자가 입력한 번호의 로또 객체생성시


        //then
        assertThatThrownBy( () -> {
            LottoViewInput.resultToList(stringAry);
        }).isInstanceOf(IllegalArgumentException.class).hasMessageContaining("로또 번호 개수가 올바르지 않습니다.");
    }

    @Test
    @DisplayName("로또 번호의 중복이 존재할 경우 예외 발생")
    void resultToList_2() {
        //given
        String stringAry = "1,2,3,4,5,5";

        //when
        //사용자가 입력한 번호의 로또 객체생성시


        //then
        assertThatThrownBy( () -> {
            LottoViewInput.resultToList(stringAry);
        }).isInstanceOf(IllegalArgumentException.class).hasMessageContaining("중복된 번호가 존재합니다.");
    }

    @Test
    @DisplayName("로또 번호의 숫자가 아닌 값이 포함될 때 예외 발생")
    void resultToList_3() {
        //given
        String stringAry = "1,2,3,4,5,a";

        //when
        //사용자가 입력한 번호의 로또 객체생성시

        //then
        assertThatThrownBy( () -> {
            LottoViewInput.resultToList(stringAry);
        }).isInstanceOf(IllegalArgumentException.class).hasMessageContaining("유효하지 않은 로또 값이 입력됌.");
    }

    @Test
    @DisplayName("로또 번호의 숫자 범위가 아닌 값이 포함될 때 예외 발생")
    void resultToList_4() {
        //given
        String stringAry = "1,2,3,4,5,100";

        //when
        //사용자가 입력한 번호의 로또 객체생성시

        //then
        assertThatThrownBy( () -> {
            LottoViewInput.resultToList(stringAry);
        }).isInstanceOf(IllegalArgumentException.class).hasMessageContaining("유효하지 않은 로또 값이 입력됌.");
    }


    @Test
    @DisplayName("보너스 볼과 로또번호가 중복된다면 예외 발생")
    void setLottoResult(){
        //given
        Lotto lotto = new Lotto();
        List<Integer> lottoList = new ArrayList<>(Arrays.asList(1,2,3,4,5,6));
        Integer bonusNumber = 6;


        //when
        //사용자가 입력한 번호의 로또 객체생성시

        //then

        assertThatThrownBy( () -> {
            lotto.setLottoResult(new LottoNumber(lottoList, LOTTO_NOT_AUTO), bonusNumber);
        }).isInstanceOf(IllegalArgumentException.class).hasMessageContaining("보너스 볼이 로또번호와 중복됩니다.");

    }

}