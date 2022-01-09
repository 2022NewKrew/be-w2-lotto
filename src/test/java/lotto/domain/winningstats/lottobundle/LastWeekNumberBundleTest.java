package lotto.domain.winningstats.lottobundle;

import lotto.domain.winningstats.lottobundle.LastWeekNumberBundle;
import lotto.domain.winningstats.lottobundle.lottoticket.Lotto;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class LastWeekNumberBundleTest {

    Lotto lastWeekWinLotto = new Lotto("1,2,3,4,5,6");
    int bonusBall = 7;

    LastWeekNumberBundle lastWeekNumberBundel = new LastWeekNumberBundle(lastWeekWinLotto,bonusBall);

    @Test
    void getBonusBall() {
        assertEquals(lastWeekNumberBundel.getBonusBall(),7);
    }

    @Test
    void addOneIfContains() {
        assertEquals(lastWeekNumberBundel.addOneIfContains(1),1);
        assertEquals(lastWeekNumberBundel.addOneIfContains(2),1);
        assertEquals(lastWeekNumberBundel.addOneIfContains(7),0);
    }
}