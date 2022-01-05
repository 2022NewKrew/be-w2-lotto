package lotto;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.stream.Collectors;

class LottoResultTest {

    @Test
    void valueOf() {
        LottoResult lottoResult = LottoResult.valueOf(5, true);
        System.out.println(lottoResult);
    }

    @Test
    void values() {
        LottoResult lottoResult = LottoResult.valueOf(5, true);
        System.out.println(lottoResult.getWinningMoney());
        System.out.println(Arrays.stream(LottoResult.values()).collect(Collectors.toList()));
    }

}