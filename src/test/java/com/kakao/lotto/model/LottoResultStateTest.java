package com.kakao.lotto.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class LottoResultStateTest {

    @Test
    @DisplayName("정답 매치가 정상적으로 되는지 판단")
    void isIncludedCurrentState() {
        LottoNumber firstTest1 = new LottoNumber(new int[]{1,2,3,4,5,6});
        LottoNumber firstTest2 = new LottoNumber(new int[]{4,2,5,1,6,3});

        assertThat(LottoResultState.calcMatchResult(firstTest1, firstTest2, 10)).isEqualTo(LottoResultState.FIRST);

        LottoNumber secondTest1 = new LottoNumber(new int[]{1,2,3,4,5,6});
        LottoNumber secondTest2 = new LottoNumber(new int[]{4,2,5,1,6,10});

        assertThat(LottoResultState.calcMatchResult(secondTest1, secondTest2, 10)).isEqualTo(LottoResultState.SECOND);

        LottoNumber thirdTest1 = new LottoNumber(new int[]{1,2,3,4,5,6});
        LottoNumber thirdTest2 = new LottoNumber(new int[]{4,14,5,1,6,3});

        assertThat(LottoResultState.calcMatchResult(thirdTest1, thirdTest2, 10)).isEqualTo(LottoResultState.THIRD);


        LottoNumber fourthTest1 = new LottoNumber(new int[]{1,2,3,4,5,6});
        LottoNumber fourthTest2 = new LottoNumber(new int[]{4,13,5,42,6,3});

        assertThat(LottoResultState.calcMatchResult(fourthTest1, fourthTest2, 10)).isEqualTo(LottoResultState.FOURTH);

        LottoNumber fifthTest1 = new LottoNumber(new int[]{1,2,3,4,5,6});
        LottoNumber fifthTest2 = new LottoNumber(new int[]{7,2,22,1,42,3});

        assertThat(LottoResultState.calcMatchResult(fifthTest1, fifthTest2, 10)).isEqualTo(LottoResultState.FIFTH);

    }
}