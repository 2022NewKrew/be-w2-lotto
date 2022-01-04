package controller;

import model.lotto.Lotto;
import model.lottoResult.LottoResult;
import view.UserOutput;

import java.util.List;
import java.util.stream.Collectors;

public class LottoController {

    public static void run() {
        List<Lotto> lottos = SellLottoController.buyLottos();
        UserOutput.printLotto(lottos.stream().map(Lotto::getNumbers).collect(Collectors.toList()));
        LottoResult lottoResult = MatchLottoController.matchingResult(lottos);
        UserOutput.printHistory(lottoResult.getResult());
        UserOutput.printRevenueRate(lottoResult.getTotalEarn());
    }
}
