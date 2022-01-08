package lotto.domain.winningstats.lastweeknumberBundle;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class LastWeekNumberBundleTest {

    LastWeekLottoNumberList lastWeekLottoNumberList = new LastWeekLottoNumberList("1,2,3,4,5,6");
    int bonusBall = 7;

    LastWeekNumberBundle lastWeekNumber = new LastWeekNumberBundle(lastWeekLottoNumberList,bonusBall);

    @Test
    void getBonusBall() {
        assertEquals(lastWeekNumber.getBonusBall(),7);
    }

    @Test
    void addOneIfContains() {
        assertEquals(lastWeekNumber.addOneIfContains(1),1);
        assertEquals(lastWeekNumber.addOneIfContains(2),1);
        assertEquals(lastWeekNumber.addOneIfContains(7),0);
    }
}