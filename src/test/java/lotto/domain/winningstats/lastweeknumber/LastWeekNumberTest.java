package lotto.domain.winningstats.lastweeknumber;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

class LastWeekNumberTest {

    List<Integer> lastWeekLottoNumberList = List.of(1,2,3,4,5,6);
    int bonusBall = 7;

    LastWeekNumber lastWeekNumber = new LastWeekNumber(lastWeekLottoNumberList,bonusBall);

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