package domain;

import domain.lottonumber.BasicNumber;
import domain.lottonumber.BonusNumber;
import domain.lottonumber.LottoNumber;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class LottoNumberTest {

    @Test
    void success() {
        LottoNumber lotto = new BasicNumber(1);
        BasicNumber basic = new BasicNumber(1);
        BonusNumber bonus = new BonusNumber(1);

        assertTrue(lotto.equals(basic));
        assertTrue(basic.equals(lotto));
        assertTrue(basic.equals(bonus)); // 성공이 맞나요 1
        assertTrue(bonus.equals(basic)); // 성공이 맞나요 2
        assertTrue(bonus.equals(lotto));
        assertTrue(lotto.equals(bonus));
    }

    @Test
    void throw_NullPointerException() {
        LottoNumber lotto_basic = new BasicNumber(1);
        assertFalse(lotto_basic.equals(null));
    }

    @Test
    void throw_ClassCastException() {
        LottoNumber lotto_basic = new BasicNumber(1);
        Integer num = 1;
        assertFalse(lotto_basic.equals(num));
    }
}
