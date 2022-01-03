package view;

import domain.Lotto;
import domain.LottoRepository;

import java.util.List;

public class OutputView {

    public static void printAutuLottos(LottoRepository autuLottos) {
        for (Lotto autoLotto : autuLottos.getLottos()) {
            System.out.println(autoLotto.getLotto());
        }
    }
}
