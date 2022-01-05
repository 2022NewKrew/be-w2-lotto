package com.kakao.model;

import com.kakao.exception.PickedNumberException;
import static org.assertj.core.api.Assertions.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class LottoTest {

    @Test
    @DisplayName("LottoWinning 은 null 이면 0을 반환한다")
    void matchNumberIsWinning() throws PickedNumberException {
        List<Integer> list = new ArrayList<Integer>(
                Arrays.asList(new Integer[]{1,2,3,4,5,6}));
        Lotto lotto = new Lotto(list);

        assertThat(lotto.matchNumberIsWinning(null))
                .isEqualTo(0);
    }

    @Test
    @DisplayName("보너스 볼이 null 이면 false를 반환한다.")
    void matchBonusBall() throws PickedNumberException {
        List<Integer> list = new ArrayList<Integer>(
                Arrays.asList(new Integer[]{1,2,3,4,5,6}));
        Lotto lotto = new Lotto(list);

        assertThat(lotto.matchBonusBall(null))
                .isEqualTo(false);
    }
}