package output;

import lotto.LottoConfig;
import lotto.domain.LottoResult;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class ResultCheckerTest {

    @Test
    void getResults() {
    }

    @Test
    void calculateProfitRate() {
        //given
        Map<Integer, Integer> results = new HashMap<>();
        results.put(3, 0);
        results.put(4, 0);
        results.put(5, 0);
        results.put(6, 1);
        results.put(7, 0);

        //when
        long profitRate = ResultChecker.calculateProfitRate(3000, results);

        //then
        Assertions.assertEquals((LottoResult.getResult(6).getPrize() * 100)/3000, profitRate);
    }
}