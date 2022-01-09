package lotto;

import lotto.result.LottoRank;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.stream.Collectors;

class LottoRankTest {

    @Test
    void valueOf() {
        LottoRank lottoRank = LottoRank.valueOf(5, true);
        System.out.println(lottoRank);
    }

    @Test
    void values() {
        LottoRank lottoRank = LottoRank.valueOf(5, true);
        System.out.println(lottoRank.getWinningMoney());
        System.out.println(Arrays.stream(LottoRank.values()).collect(Collectors.toList()));
    }

}