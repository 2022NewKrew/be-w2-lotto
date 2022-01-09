package lotto.domain.winningstats.lottobundle;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LottoListTest {
    LottoList lottoList = new LottoList(3);

    @Test
    void printLottoList() {
    }

    @Test
    void size() {
        assertEquals(lottoList.size(),3);
    }

    @Test
    void getIterator() {
    }

    @Test
    void concat() {
        LottoList otherLottoList = new LottoList("1,2,3,4,5,6" + System.lineSeparator() + "2,3,4,5,6,7");
        LottoList newLottoList = lottoList.concat(otherLottoList);
        assertEquals(newLottoList.size(),5);
    }
}