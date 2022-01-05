package com.kakao.io;

import com.kakao.model.LottoWinning;
import com.kakao.model.Lottos;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

class LottoOutputTest {

    @Test
    @DisplayName("null은 출력없이 종료.")
    void printString() {
        LottoOutput.printString(null);
    }

    @Test
    @DisplayName("null은 출력없이 종료")
    void printResult() {
        LottoOutput.printResult(null);
    }

    @Test
    @DisplayName("모든 null 인자에 대해 에러없이 무출력 반응")
    void printLottoWinning() throws Exception {
        Integer money = 10000;
        Lottos lottos = new Lottos(5000);
        List<Integer> winning = new ArrayList<>(
                Arrays.asList(new Integer[]{1,2,3,4,5,6}));
        LottoWinning lottoWinning = new LottoWinning(winning);

        LottoOutput.printLottoWinning(null, lottos, lottoWinning);
        LottoOutput.printLottoWinning(money, null, lottoWinning);
        LottoOutput.printLottoWinning(money, lottos, null);
    }
}