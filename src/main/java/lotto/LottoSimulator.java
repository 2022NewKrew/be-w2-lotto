package lotto;

import lotto.domain.*;
import lotto.view.PurchaseInfoScanner;
import lotto.view.PurchaseResultPrinter;
import lotto.view.WinningInfoScanner;
import lotto.view.WinningResultPrinter;
import org.jetbrains.annotations.NotNull;

import java.util.List;

public class LottoSimulator {
    public static final int LOTTO_PRICE = 1000;
    public static final String SEPARATOR = ",";

    private final long purchaseAmount;

    public LottoSimulator(long purchaseAmount) {
        this.purchaseAmount = purchaseAmount;
    }

    public static void main(String[] args) {
        LottoSimulator lottoSimulator = new LottoSimulator(new PurchaseInfoScanner().getPurchaseAmount());

        PurchasedLotto purchasedLotto = new PurchasedLotto(lottoSimulator.purchaseLotto());
        lottoSimulator.printPurchase(purchasedLotto);
        WinningInfoScanner winningInfoScanner = new WinningInfoScanner();
        WinningLotto winningLotto = new WinningLotto(winningInfoScanner.getWinningDigits(), winningInfoScanner.getWinningBonusDigit());
        WinningResult winningResult = new WinningResult(purchasedLotto.getPurchasedResult(winningLotto));
        double yield = lottoSimulator.getSimulationYield(winningResult);
        lottoSimulator.printWinning(winningResult, yield);
    }

    private List<Lotto> purchaseLotto() {
        LottoAutoGenerator lottoAutoGenerator = new LottoAutoGenerator();
        return lottoAutoGenerator.getRandomLottos(purchaseAmount / LOTTO_PRICE);
    }

    private void printPurchase(PurchasedLotto purchasedLotto) {
        PurchaseResultPrinter purchaseResultPrinter = new PurchaseResultPrinter();
        purchaseResultPrinter.printPurchaseResult(purchasedLotto);
    }

    private double getSimulationYield(@NotNull WinningResult winningResult) {
        long totalReward = winningResult.getWinningResult().stream().mapToLong(LottoResult::getReward).sum();
        return (double) (totalReward - this.purchaseAmount) / this.purchaseAmount * 100;
    }

    private void printWinning(WinningResult winningResult, double yield) {
        WinningResultPrinter winningResultPrinter = new WinningResultPrinter();
        winningResultPrinter.printWinningResultPrinter(winningResult);
        winningResultPrinter.printWinningYield(yield);
    }
}
