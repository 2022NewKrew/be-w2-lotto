package lotto.domain.winningstats.lottobundle;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LottoBundleTest {

    long lottoPurchaseMoney = 4000;
    int lottoPrice = 1000;
    String manualLottoNumbers = "1,2,3,4,5,6" + System.lineSeparator() + "2,3,4,5,6,7";
    LottoBundle lottoBundle = new LottoBundle(lottoPurchaseMoney,manualLottoNumbers,lottoPrice);
    @Test
    void getCount() {

        assertEquals(lottoBundle.getAutoCount(), 2);

        LottoBundle lottoBundle2 = new LottoBundle(2000,manualLottoNumbers,lottoPrice);
        assertEquals(lottoBundle2.getAutoCount(), 0);

        LottoBundle lottoBundle3 = new LottoBundle(2_000_000_000,manualLottoNumbers,lottoPrice);
        assertEquals(lottoBundle3.getAutoCount(), 2_000_000-2);
    }

    @Test
    void getLottoList() {
        assertEquals(lottoBundle.getLottoList().size(), 4);
    }

    @Test
    void printLottoBundle() {
    }

    @Test
    void getManualLottoCount(){
        assertEquals(lottoBundle.getManualLottoCount(),2);
    }
}