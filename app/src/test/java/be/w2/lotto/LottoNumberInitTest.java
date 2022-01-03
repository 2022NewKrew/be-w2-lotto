package be.w2.lotto;

import be.w2.lotto.Domain.LottoNumber;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class LottoNumberInitTest {

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


}
