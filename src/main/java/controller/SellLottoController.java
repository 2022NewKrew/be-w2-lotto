package controller;

import model.lotto.Lotto;
import view.UserOutput;

import java.util.ArrayList;
import java.util.List;

public class SellLottoController {

    public static List<Lotto> buyLottos(int money) {
        int numberOfLotto = calculateNumberOfLotto(money);
        UserOutput.printBuyMessage(numberOfLotto);

        List<Lotto> lottos = new ArrayList<>();
        for (long i = 0; i < numberOfLotto; i++) {
            lottos.add(buyLotto());
        }
        return lottos;
    }

    private static Lotto buyLotto() {
        return Lotto.getRandomLotto();
    }

    private static int calculateNumberOfLotto(int money) {
        return money / Lotto.LOTTO_PRICE;
    }
}
