package lotto.domain.winningstats.lottobundle.lottoticket;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class LottoTest {

    @Test
    void contains() {

        Lotto lotto = new Lotto("1,2,3,4,5,6");
        assertEquals(lotto.contains(6),true);
    }

    @Test
    void printLotto() {
        Lotto lotto = new Lotto("1,2,3,4,5,6");

        assertEquals(lotto.printLotto().charAt(0),'[');
        assertEquals(lotto.printLotto().charAt(lotto.printLotto().length()-1),']');
    }

    @Test
    void getCorrectCount(){

    }
}