package domain;

import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

class LottoResultTest {


    @Test
    void 없는_등수를_가져오면_옵셔널을_반환한다() {
        assertEquals(Optional.empty(), LottoResult.getLottoResultType(123));
    }

    @Test
    void 매칭되어야할_숫자에_해당하는_등수_가져오기() {
        assertEquals(LottoResult.FIRST, LottoResult.getLottoResultType(6).get());
    }
}