package application;

import domain.Ball;
import domain.Lotto;
import domain.WinningLotto;
import view.LottoGuidePrinter;
import view.LottoScanner;

import java.util.List;

public class LottoManager {

    public static void run() {
        int quantity = inputPurchaseQuantity();
        List<Lotto> autoGeneratedLotto = purchaseAutoGeneratedLotto(quantity);
        WinningLotto winningLotto = inputWinnningLotto();
        LottoResultManager resultManager = new LottoResultManager(winningLotto, autoGeneratedLotto);
        LottoGuidePrinter.printLottoResult(quantity * Lotto.PRICE, resultManager.getMatchingResult(), resultManager.getTotalPrizeMoney());
    }

    private static int inputPurchaseQuantity() {
        int purchaseQuantity = LottoScanner.getPurchaseQuantity();
        LottoGuidePrinter.alertPurchaseQuantity(purchaseQuantity);
        return purchaseQuantity;
    }

    private static List<Lotto> purchaseAutoGeneratedLotto(int quantity) {
        AutoGeneratedLottoPurchaser lottoPurchaser = new AutoGeneratedLottoPurchaser();
        List<Lotto> lottoList = lottoPurchaser.generateLotto(quantity);
        LottoGuidePrinter.printLottoList(lottoList);
        return lottoList;
    }

    private static WinningLotto inputWinnningLotto() {
        List<Ball> winningLottoNumbers = LottoScanner.getWinningLottoNumbers();
        Ball bonusBall = LottoScanner.getBonusBall(winningLottoNumbers);
        return new WinningLotto(winningLottoNumbers, bonusBall);
    }
}
