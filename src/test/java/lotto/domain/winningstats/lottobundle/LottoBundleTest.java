package lotto.domain.winningstats.lottobundle;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LottoBundleTest {

    LottoBundle lottoBundle = new LottoBundle(4500);

    @Test
    void getCount() {

        assertEquals(lottoBundle.getCount(), 4);

        LottoBundle lottoBundle2 = new LottoBundle(0);
        assertEquals(lottoBundle2.getCount(), 0);

        LottoBundle lottoBundle3 = new LottoBundle(2000000000);
        assertEquals(lottoBundle3.getCount(), 2000000);
    }

    @Test
    void getLottoList() {
        assertEquals(lottoBundle.getLottoList().size(), 4);
    }

    @Test
    void printLottoBundle() {
    }
}