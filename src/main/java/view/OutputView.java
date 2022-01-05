package view;

import domain.Lotto;
import domain.LottoRepository;

public class OutputView {

    public static void printAutoLottos(LottoRepository autuLottos) {
        for (Lotto autoLotto : autuLottos.getLottos()) {
            System.out.println(autoLotto.getLotto());
        }
    }
}
