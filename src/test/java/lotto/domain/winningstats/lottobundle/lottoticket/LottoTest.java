package lotto.domain.winningstats.lottobundle.lottoticket;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class LottoTest {

    @Test
    void getLottoNumberList() {

        Lotto lotto = new Lotto();

        assertEquals(lotto.getLottoNumberList().size(),6);
        for(Integer lottoNumber : lotto.getLottoNumberList()) {
            assertEquals((lottoNumber > 0 && lottoNumber < 46), true);
            assertEquals(lottoNumber<=0,false);
            assertEquals(lottoNumber>=46,false);
        }
    }

    @Test
    void printLotto() {
        Lotto lotto = new Lotto();

        List<Integer> lottoNumberList = List.of(1,2,3,4,5,6);

        assertEquals(lotto.printLotto().charAt(0),'[');
        assertEquals(lotto.printLotto().charAt(lotto.printLotto().length()-1),']');
    }
}