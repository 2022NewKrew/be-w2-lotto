package lotto.util;

import lotto.domain.Lotto;
import lotto.domain.LottoCollection;

public class OutputUtil {

    public static void printLottoCollection(LottoCollection lottoCollection) {
        for (Lotto lotto : lottoCollection.getLottoCollection()) {
            System.out.println(lotto);
        }
        System.out.println();
    }
}
