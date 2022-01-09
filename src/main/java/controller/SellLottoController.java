package controller;

import dto.LottoRecipeDto;
import model.lotto.Lotto;
import model.lotto.LottoRecipe;
import model.lotto.strategy.DefinedGenerateStrategy;
import model.lotto.strategy.RandomGenerateStrategy;
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

        UserOutput.printBuyMessage(new LottoRecipeDto(lottoRecipe));
        return lottos;
    }

    private static List<Lotto> buyLottosByAuto(int numberOfRandomLotto) {
        return IntStream
                .range(0, numberOfRandomLotto)
                .mapToObj(index -> new Lotto(new RandomGenerateStrategy()))
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
        return new Lotto(new DefinedGenerateStrategy(numbers));
    }

    private static int calculateNumberOfLotto(int money) {
        return money / Lotto.LOTTO_PRICE;
    }
}
