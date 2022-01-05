package controller;

import model.lotto.LottoRank;
import model.lotto.RandomLotto;
import model.lotto.result.LottoResult;
import model.lotto.number.LottoNumber;
import view.UserInput;
import view.UserOutput;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class LottoController {
    private static final int FIRST_INDEX_TO_PRESENT = 2;
    private static final int LAST_INDEX_TO_PRESENT = LottoRank.values().length;

    public static void run() {
        List<RandomLotto> lottos = SellLottoController.buyLottos(UserInput.getMoney());
        UserOutput.printLotto(getLottoNumbers(lottos));
        LottoResult lottoResult = MatchLottoController.matchingResult(lottos);
        UserOutput.printHistory(getValidLottoResult(FIRST_INDEX_TO_PRESENT, LAST_INDEX_TO_PRESENT), lottoResult.getResult());
        UserOutput.printRevenueRate(lottoResult.getRevenuePercent());
    }

    private static List<List<Integer>> getLottoNumbers(List<RandomLotto> lottos) {
        List<List<Integer>> numbers = new ArrayList<>();
        for (RandomLotto lotto : lottos) {
            numbers.add(getLottoNumber(lotto));
        }
        return numbers;
    }

    private static List<Integer> getLottoNumber(RandomLotto lotto) {
        return lotto
                .getLotto()
                .getNumbers()
                .stream()
                .map(LottoNumber::convertToInt)
                .collect(Collectors.toList());
    }

    private static List<LottoRank> getValidLottoResult(int startIndex, int finishIndex) {
        return Arrays.asList(LottoRank.values()).subList(startIndex, finishIndex);
    }
}
