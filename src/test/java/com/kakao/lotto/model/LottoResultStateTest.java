package com.kakao.lotto.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class LottoResultStateTest {

    @Test
    @DisplayName("정답 매치가 정상적으로 되는지 판단")
    void isIncludedCurrentState() {
        int[] firstTest1 = new int[]{1,2,3,4,5,6};
        int[] firstTest2 = new int[]{4,2,5,1,6,3};
        assertThat(LottoResultState.FIRST.isIncludedCurrentState(firstTest1, firstTest2, 10)).isEqualTo(true);
        assertThat(LottoResultState.SECOND.isIncludedCurrentState(firstTest1, firstTest2, 10)).isEqualTo(false);
        assertThat(LottoResultState.THIRD.isIncludedCurrentState(firstTest1, firstTest2, 10)).isEqualTo(false);
        assertThat(LottoResultState.FOURTH.isIncludedCurrentState(firstTest1, firstTest2, 10)).isEqualTo(false);
        assertThat(LottoResultState.FIFTH.isIncludedCurrentState(firstTest1, firstTest2, 10)).isEqualTo(false);

        int[] secondTest1 = new int[]{1,2,3,4,5,6};
        int[] secondTest2 = new int[]{4,2,5,1,6,10};
        assertThat(LottoResultState.FIRST.isIncludedCurrentState(secondTest1, secondTest2, 10)).isEqualTo(false);
        assertThat(LottoResultState.SECOND.isIncludedCurrentState(secondTest1, secondTest2, 10)).isEqualTo(true);
        // 로직 자체가 2등과 3등은 보너스를 확인해서 판별해서 2등을 확인하는 코드에서는 3등도 true 가 나오는 것이 맞음
        assertThat(LottoResultState.THIRD.isIncludedCurrentState(secondTest1, secondTest2, 10)).isEqualTo(true);
        assertThat(LottoResultState.FOURTH.isIncludedCurrentState(secondTest1, secondTest2, 10)).isEqualTo(false);
        assertThat(LottoResultState.FIFTH.isIncludedCurrentState(secondTest1, secondTest2, 10)).isEqualTo(false);

        int[] thirdTest1 = new int[]{1,2,3,4,5,6};
        int[] thirdTest2 = new int[]{4,14,5,1,6,3};
        assertThat(LottoResultState.FIRST.isIncludedCurrentState(thirdTest1, thirdTest2, 10)).isEqualTo(false);
        assertThat(LottoResultState.SECOND.isIncludedCurrentState(thirdTest1, thirdTest2, 10)).isEqualTo(false);
        assertThat(LottoResultState.THIRD.isIncludedCurrentState(thirdTest1, thirdTest2, 10)).isEqualTo(true);
        assertThat(LottoResultState.FOURTH.isIncludedCurrentState(thirdTest1, thirdTest2, 10)).isEqualTo(false);
        assertThat(LottoResultState.FIFTH.isIncludedCurrentState(thirdTest1, thirdTest2, 10)).isEqualTo(false);

        int[] fourthTest1 = new int[]{1,2,3,4,5,6};
        int[] fourthTest2 = new int[]{4,13,5,42,6,3};
        assertThat(LottoResultState.FIRST.isIncludedCurrentState(fourthTest1, fourthTest2, 10)).isEqualTo(false);
        assertThat(LottoResultState.SECOND.isIncludedCurrentState(fourthTest1, fourthTest2, 10)).isEqualTo(false);
        assertThat(LottoResultState.THIRD.isIncludedCurrentState(fourthTest1, fourthTest2, 10)).isEqualTo(false);
        assertThat(LottoResultState.FOURTH.isIncludedCurrentState(fourthTest1, fourthTest2, 10)).isEqualTo(true);
        assertThat(LottoResultState.FIFTH.isIncludedCurrentState(fourthTest1, fourthTest2, 10)).isEqualTo(false);

        int[] fifthTest1 = new int[]{1,2,3,4,5,6};
        int[] fifthTest2 = new int[]{7,2,22,1,42,3};
        assertThat(LottoResultState.FIRST.isIncludedCurrentState(fifthTest1, fifthTest2, 10)).isEqualTo(false);
        assertThat(LottoResultState.SECOND.isIncludedCurrentState(fifthTest1, fifthTest2, 10)).isEqualTo(false);
        assertThat(LottoResultState.THIRD.isIncludedCurrentState(fifthTest1, fifthTest2, 10)).isEqualTo(false);
        assertThat(LottoResultState.FOURTH.isIncludedCurrentState(fifthTest1, fifthTest2, 10)).isEqualTo(false);
        assertThat(LottoResultState.FIFTH.isIncludedCurrentState(fifthTest1, fifthTest2, 10)).isEqualTo(true);

    }
}