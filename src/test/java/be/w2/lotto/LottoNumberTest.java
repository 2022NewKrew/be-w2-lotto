package be.w2.lotto;

import be.w2.lotto.Domain.LottoNumber;
import be.w2.lotto.Domain.LottoNumbers;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class LottoNumberTest {

    @Test
    @DisplayName("LottoNumber_생성_범위_초과해서_실패하기")
    void over_test() {
        assertThrows(IllegalArgumentException.class, () -> {
            new LottoNumber(46);
        });
    }

    @Test
    @DisplayName("LottoNumber_생성_범위_미만으로_실패")
    void under_test() {
        assertThrows(IllegalArgumentException.class, () -> {
            new LottoNumber(0);
        });
    }

    @Test
    @DisplayName("보너스_전호_중복_실패")
    void listContainsNumberFailTest() {
        LottoNumbers lottoNumbers = LottoNumbers.getInstanceByIntList(Arrays.asList(1, 2, 3, 4, 5, 6));
        assertThrows(IllegalArgumentException.class, () -> {
            new LottoNumber(lottoNumbers, 6);
        });
    }


}
