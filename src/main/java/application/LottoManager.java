package application;

import domain.Lotto;
import domain.Purchase;
import domain.WinningLotto;
import view.LottoGuidePrinter;
import view.LottoScanner;

import java.util.ArrayList;
import java.util.List;

public class LottoManager {

    public static void run() {
        Purchase purchase = inputPurchaseInformation();

        List<Lotto> manualGeneratedLotto = purchaseManualGeneratedLotto(purchase.getManualGeneratedLottoQuantity());

        LottoGuidePrinter.alertPurchaseQuantity(purchase);

        List<Lotto> autoGeneratedLotto = purchaseAutoGeneratedLotto(purchase.getAutoGeneratedLottoQuantity());

        List<Lotto> purchasedLottoList = new ArrayList<>();
        purchasedLottoList.addAll(manualGeneratedLotto);
        purchasedLottoList.addAll(autoGeneratedLotto);

        WinningLotto winningLotto = inputWinnningLotto();
        LottoResultManager resultManager = new LottoResultManager(winningLotto, purchasedLottoList);
        LottoGuidePrinter.printLottoResult(purchase.getAmount(), resultManager.getMatchingResult(), resultManager.getTotalPrizeMoney());
    }

    private static Purchase inputPurchaseInformation() {
        LottoGuidePrinter.requestPurchaseAmountInput();
        int amount = LottoScanner.getPurchaseQuantity();
        int purchaseableQuantity = Purchase.purchaseableQuantity(amount);

        LottoGuidePrinter.requestManualPurchaseQuantity();
        int manualPurchaseQuantity = LottoScanner.getManualPurchaseQuantity(purchaseableQuantity);

        return new Purchase(amount, purchaseableQuantity - manualPurchaseQuantity, manualPurchaseQuantity);
    }

    private static List<Lotto> purchaseManualGeneratedLotto(int quantity) {
        if (quantity == 0) {
            return null;
        }

        LottoGuidePrinter.requestManualPurchaseLottoList();
        List<List<Integer>> manualGeneratedLottoNumbers = LottoScanner.getManualGeneratedLottoStrString(quantity);

        return new ManualGeneratedLottoPurchaser(manualGeneratedLottoNumbers).generateLotto();
    }

    private static List<Lotto> purchaseAutoGeneratedLotto(int quantity) {
        LottoPurchaser lottoPurchaser = new AutoGeneratedLottoPurchaser(quantity);
        List<Lotto> lottoList = lottoPurchaser.generateLotto();

        LottoGuidePrinter.printLottoList(lottoList);
        return lottoList;
    }

    private static WinningLotto inputWinnningLotto() {
        LottoGuidePrinter.requestLottoNumberInput();
        List<Integer> winningLottoNumbers = LottoScanner.getLottoNumbers();

        LottoGuidePrinter.requestBonusBallInput();
        int bonusBall = LottoScanner.getBonusBall(winningLottoNumbers);

        return LottoFactory.createWinningLotto(winningLottoNumbers, bonusBall);
    }
}
