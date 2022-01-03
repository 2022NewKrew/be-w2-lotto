package domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LottoResultsTest {

    LottoResults lottoResults;

    @BeforeEach
    void setUp() {
        lottoResults = new LottoResults();
    }

    @Test
    void 없는_등수로_결과를_가져오면_0을_반환한다() {
        assertEquals(0, lottoResults.getCountBy(LottoResult.FIRST));
    }

    @Test
    void 해당_등수의_결과_가져오기() {
        lottoResults.addLottoResult(LottoResult.FIRST);
        assertEquals(1, lottoResults.getCountBy(LottoResult.FIRST));
    }

}