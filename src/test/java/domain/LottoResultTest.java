package domain;

import domain.lottonumber.BasicNumber;
import domain.lottonumber.BonusNumber;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

class LottoResultTest {


    @Test
    void 없는_등수를_가져오면_옵셔널을_반환한다() {
        LottoMatchResultDto lottoMatchResultDto = new LottoMatchResultDto(List.of());
        assertEquals(Optional.empty(), LottoResult.getLottoResultType(lottoMatchResultDto));

    }

    @Test
    void 매칭되어야할_숫자에_해당하는_등수_가져오기() {
        LottoMatchResultDto lottoMatchResultDto = new LottoMatchResultDto(List.of(new BasicNumber(1), new BasicNumber(2), new BasicNumber(3),
                new BasicNumber(4), new BasicNumber(5), new BasicNumber(6)));
        assertEquals(LottoResult.FIRST, LottoResult.getLottoResultType(lottoMatchResultDto).get());

    }

    @Test
    void 당첨번호중_5개가_맞고_보너스번호가_맞으면_2등이다() {
        LottoMatchResultDto lottoMatchResultDto = new LottoMatchResultDto(List.of(new BasicNumber(1), new BasicNumber(2), new BasicNumber(3),
                new BasicNumber(4), new BasicNumber(5), new BonusNumber(6)));
        assertEquals(LottoResult.SECOND, LottoResult.getLottoResultType(lottoMatchResultDto).get());
    }

    @Test
    void 당첨번호중_5개가_맞고_보너스번호가_맞지않으면_3등이다() {
        LottoMatchResultDto lottoMatchResultDto = new LottoMatchResultDto(List.of(new BasicNumber(1), new BasicNumber(2), new BasicNumber(3),
                new BasicNumber(4), new BasicNumber(5)));
        assertEquals(LottoResult.THIRD, LottoResult.getLottoResultType(lottoMatchResultDto).get());
    }
}