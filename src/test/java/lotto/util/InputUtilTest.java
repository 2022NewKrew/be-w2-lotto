package lotto.util;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class InputUtilTest {

    // 다른 클래스에서 체크하는 부분 중 겹치는 테스트들도 있는데(예를 들면 구입 금액 자연수 확인, 로또 6개 생성 확인 등)
    // 의존성 안생기게 하려고 입력받는 테스트에도 따로 만들었는데 이렇게 해도 되나요?

    @Test
    @DisplayName("구입 금액 입력이 올바르지 않으면 에러를 발생하는지")
    void test1() {
        InputUtil inputUtil = new InputUtil("4$");
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> inputUtil.inputPrice());
    }

    @Test
    @DisplayName("구입 금액이 자연수가 아니면 에러를 발생하는지")
    void test2() {
        InputUtil inputUtil = new InputUtil("-100");
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> inputUtil.inputPrice());
    }

    @Test
    @DisplayName("당첨 번호 입력 양식이 올바르지 않으면 에러를 발생하는지")
    void test3() {
        InputUtil inputUtil = new InputUtil("1a,2a,3,4,5,6");
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> inputUtil.inputWinningNumbers());
    }

    @Test
    @DisplayName("입력한 숫자가 6개가 아니면 에러를 발생하는지")
    void test4() {
        InputUtil inputUtil = new InputUtil("1,2,3,4,5");
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> inputUtil.inputWinningNumbers());
    }

    @Test
    @DisplayName("입력한 숫자 중 중복되는 값이 있으면 에러를 발생하는지")
    void test5() {
        InputUtil inputUtil = new InputUtil("1,1,2,3,4,5");
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> inputUtil.inputWinningNumbers());
    }

}