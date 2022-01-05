package controller;

import model.lotto.Lotto;
import model.lotto.RandomLotto;
import view.UserInput;
import view.UserOutput;

import java.util.ArrayList;
import java.util.List;

public class SellLottoController {

    public static List<RandomLotto> buyLottos(int money) {
        int numberOfLotto = calculateNumberOfLotto(money);
        UserOutput.printBuyMessage(numberOfLotto);

        List<RandomLotto> lottos = new ArrayList<>();
        for (long i = 0; i < numberOfLotto; i++) {
            lottos.add(buyLotto());
        }
        return lottos;
    }

    private static RandomLotto buyLotto() {
        return new RandomLotto();
    }

    private static int calculateNumberOfLotto(int money) {
        return money / Lotto.LOTTO_PRICE;
    }
}
