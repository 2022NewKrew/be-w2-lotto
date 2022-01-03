package lottoStage1;

import lottoStage1.domain.Lotto;
import lottoStage1.domain.Number;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class LottoNumbersTest {

    @Test
    @DisplayName("랜덤 숫자 6개를 뽑는다")
    void create() {
        Lotto lotto = Lotto.generate();

        List<Number> lottoNumbers = lotto.getLottoNumbers();
        assertEquals(6, lottoNumbers.size());
    }
}