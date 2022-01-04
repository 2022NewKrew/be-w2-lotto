package controller;

import model.lotto.Lotto;
import model.lotto.RandomLotto;
import view.UserInput;
import view.UserOutput;

import java.util.ArrayList;
import java.util.List;

public class SellLottoController {

    public static List<Lotto> buyLottos() {
        long numberOfLotto = calculateNumberOfLotto(UserInput.getMoney());
        UserOutput.printBuyMessage(numberOfLotto);

        List<Lotto> lottos = new ArrayList<>();
        for (long i = 0; i < numberOfLotto; i++) {
            lottos.add(buyLotto());
        }
        return lottos;
    }

    private static Lotto buyLotto() {
        return new RandomLotto();
    }

    private static long calculateNumberOfLotto(long money){
        return money / Lotto.LOTTO_PRICE;
    }
}
