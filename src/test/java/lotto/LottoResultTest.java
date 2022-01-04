package lotto;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;

class LottoResultTest {

    @Test
    void valueOf() {
        LottoResult lottoResult = LottoResult.valueOf(5);
        System.out.println(lottoResult);
    }

    @Test
    void values() {
        LottoResult lottoResult = LottoResult.valueOf(5);
        System.out.println(lottoResult.getWinningMoney());
        System.out.println(Arrays.stream(lottoResult.values()).collect(Collectors.toList()).toString());
    }

}