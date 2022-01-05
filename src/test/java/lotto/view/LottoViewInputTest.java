package lotto.view;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

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
    void resultToList() {
        //given
        String stringAry = "1,2,3,4,5";

        //when
        //사용자가 입력한 번호의 로또 객체생성시


        //then
        assertThatThrownBy( () -> {
            LottoViewInput.resultToList("1,2,3,4,5");
        }).isInstanceOf(IllegalArgumentException.class).hasMessageContaining("로또 번호 개수가 올바르지 않습니다.");
    }

    @Test
    void lottoInputResultBonus() {}

}