package lotto.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.LongStream;

import static lotto.view.IOView.*;

public class LottoGameManager {

    public static void run() {
        long purchaseAmount = inputPurchaseAmount();
        List<Lotto> purchasedLottoList = purchaseLotto(purchaseAmount);
        printLottoList(purchasedLottoList, purchaseAmount);

        List<Integer> winningNumbers = inputWinningNumber();
        int bonusNumber = inputBonusNumber();
        LottoGame lottoGame = new LottoGame(purchasedLottoList, winningNumbers, bonusNumber);
        lottoGame.makeResult();

        printLottoResult(lottoGame);
    }

    private static List<Lotto> purchaseLotto(long purchaseAmount) {
        List<Lotto> randomLottoList = purchaseRandomLotto(purchaseAmount);

        return new ArrayList<>(randomLottoList);
    }



    private static List<Lotto> purchaseRandomLotto(long purchaseAmount) {
        List<Lotto> lottoList = new ArrayList<>();
        LongStream.range(0L, purchaseAmount)
                .forEach(i -> {
                    Lotto newLotto = Lotto.createRandomLotto();
                    lottoList.add(newLotto);
                });

        return lottoList;
    }
}
