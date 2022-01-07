package controller;

import model.lotto.Lotto;
import model.lotto.LottoRecipe;
import view.UserInput;
import view.UserOutput;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class SellLottoController {

    public static List<Lotto> buyLottos(int money) {
        List<Lotto> lottos = new ArrayList<>();
        LottoRecipe lottoRecipe = new LottoRecipe(UserInput.getNumberOfManualLotto(), calculateNumberOfLotto(money));

        lottos.addAll(buyLottosByManual(lottoRecipe.getNumberOfManualLotto()));
        lottos.addAll(buyLottosByAuto(lottoRecipe.getNumberOfRandomLotto()));

        UserOutput.printBuyMessage(lottoRecipe.getNumberOfManualLotto(), lottoRecipe.getNumberOfRandomLotto());
        return lottos;
    }

    private static List<Lotto> buyLottosByAuto(int numberOfRandomLotto) {
        return IntStream
                .range(0, numberOfRandomLotto)
                .mapToObj(index -> Lotto.getRandomLotto())
                .collect(Collectors.toList());
    }

    private static List<Lotto> buyLottosByManual(int numberOfManualLotto) {
        return UserInput
                .getManualLotto(numberOfManualLotto)
                .stream()
                .map(SellLottoController::getLottoByManual)
                .collect(Collectors.toList());
    }

    private static Lotto getLottoByManual(List<Integer> numbers) {
        return Lotto.getDefinedLotto(numbers);
    }

    private static int calculateNumberOfLotto(int money) {
        return money / Lotto.LOTTO_PRICE;
    }
}
