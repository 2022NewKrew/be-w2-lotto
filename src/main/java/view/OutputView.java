package view;

import domain.Lotto;

import java.util.List;

public class OutputView {

    public static void printAutuLottos(List<Lotto> autuLottos) {
        for (Lotto autoLotto : autuLottos) {
            System.out.println(autoLotto.getLotto());
        }
    }
}
