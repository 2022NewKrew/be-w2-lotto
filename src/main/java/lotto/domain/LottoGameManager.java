package lotto.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.LongStream;

import static lotto.view.IOView.*;

public class LottoGameManager {

    public static void run() {
        long totalPurchaseAmount = inputTotalPurchaseAmount();
        long manualAmount = inputManualAmount(totalPurchaseAmount);
        List<Lotto> purchasedLottoList = purchaseLotto(totalPurchaseAmount, manualAmount);
        printLottoList(purchasedLottoList, totalPurchaseAmount, manualAmount);

        List<Integer> winningNumbers = inputWinningNumber();
        int bonusNumber = inputBonusNumber(winningNumbers);
        LottoGame lottoGame = new LottoGame(purchasedLottoList, winningNumbers, bonusNumber);
        lottoGame.makeResult();

        printLottoResult(lottoGame);
    }

    private static List<Lotto> purchaseLotto(long purchaseAmount, long manualAmount) {
        List<Lotto> randomLottoList = purchaseRandomLotto(purchaseAmount - manualAmount);
        List<Lotto> manualLottoList = purchaseManualLotto(manualAmount);

        List<Lotto> resultLottoList = new ArrayList<>();
        resultLottoList.addAll(manualLottoList);
        resultLottoList.addAll(randomLottoList);

        return resultLottoList;
    }

    private static List<Lotto> purchaseManualLotto(long manualAmount) {
        List<List<Integer>> manualLottoNumbers = inputManualLottoNumbers(manualAmount);

        return manualLottoNumbers.stream()
                    .map(Lotto::new)
                    .collect(Collectors.toList());
    }


    private static List<Lotto> purchaseRandomLotto(long randomAmount) {
        return LongStream.range(0L, randomAmount)
                .mapToObj(i -> Lotto.createRandomLotto())
                .collect(Collectors.toList());
    }
}
