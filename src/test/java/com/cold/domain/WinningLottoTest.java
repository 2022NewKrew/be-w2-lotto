package com.cold.domain;


import java.util.List;
import static org.assertj.core.api.Assertions.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class WinningLottoTest {

    @Test
    @DisplayName("올바른 지난 당첨 번호 유효성 검사 테스트")
    void validateLastWinningNums1() throws Exception {
        //given
        List<Integer> sample = List.of(1, 2, 3, 4, 5, 7);
        Integer bonusBall = 7;
        WinningLotto winningLotto = new WinningLotto(sample, bonusBall);

        //when
        winningLotto.validateLastWinningNums(sample);

        //then
        assertThatNoException();
    }

    @Test
    @DisplayName("지난 당첨 번호 범위 유효성 검사 테스트")
    void validateLastWinningNums2() throws Exception {
        //given
        List<Integer> sample = List.of(1, 2, 3, 4, 5, 46);
        Integer bonusBall = 7;

        //when then
        assertThatIllegalArgumentException().isThrownBy(()->{
                WinningLotto winningLotto = new WinningLotto(sample, bonusBall);})
                .withMessage("당첨 번호 범위 오류");
    }

    @Test
    @DisplayName("지난 당첨 번호 갯수 유효성 검사 테스트1")
    void validateLastWinningNums3() throws Exception {
        //given
        List<Integer> sample = List.of(1, 2, 3, 4, 5, 6,7);
        Integer bonusBall = 7;

        //when then
        assertThatIllegalArgumentException().isThrownBy(()->{
                WinningLotto winningLotto = new WinningLotto(sample, bonusBall);;})
                .withMessage("지난 주 당첨 번호 갯수 오류");
    }
}
