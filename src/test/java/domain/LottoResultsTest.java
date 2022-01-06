package domain;

import org.junit.jupiter.api.Test;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class LottoResultsTest {

    @Test
    void 없는_등수로_결과를_가져오면_0을_반환한다() {
        LottoResults lottoResults = new LottoResults(Map.of());
        assertEquals(0, lottoResults.getCountBy(LottoResult.FIRST));
    }

    @Test
    void 해당_등수의_결과_가져오기() {
        LottoResults lottoResults = new LottoResults(Map.of(LottoResult.FIRST, 1L));
        assertEquals(1, lottoResults.getCountBy(LottoResult.FIRST));
    }

}