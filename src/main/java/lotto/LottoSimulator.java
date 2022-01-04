package lotto;

import lotto.domain.*;
import lotto.view.LottoInputScanner;
import lotto.view.LottoOutputPrinter;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

import java.util.List;

public class LottoSimulator {
    public static final int LOTTO_PRICE = 1000;
    public static final String SEPARATOR = ",";

    private final LottoInputScanner lottoInputScanner;
    private final LottoOutputPrinter lottoOutputPrinter;

    public LottoSimulator(LottoInputScanner lottoInputScanner, LottoOutputPrinter lottoOutputPrinter) {
        this.lottoInputScanner = lottoInputScanner;
        this.lottoOutputPrinter = lottoOutputPrinter;
    }

    public static void main(String[] args) {
        LottoSimulator lottoSimulator = new LottoSimulator(new LottoInputScanner(), new LottoOutputPrinter());
        lottoSimulator.start();
    }

    private void start() {
        long purchaseAmount = getPurchaseAmount();
        PurchasedLotto purchasedLotto = purchaseLotto(purchaseAmount);
        WinningLotto winningLotto = getWinningInfo();
        printWinningStat(purchaseAmount, purchasedLotto, winningLotto);
    }

    private long getPurchaseAmount() {
        try {
            return lottoInputScanner.getPurchaseAmount();
        } catch (IllegalArgumentException iae) {
            System.out.println(iae.getMessage());
            return getPurchaseAmount();
        }
    }

    @Contract("_ -> new")
    private @NotNull PurchasedLotto purchaseLotto(long purchaseAmount) {
        LottoAutoGenerator lottoAutoGenerator = new LottoAutoGenerator();
        List<Lotto> purchasedLottoList = lottoAutoGenerator.getRandomLottos(purchaseAmount / LOTTO_PRICE);
        lottoOutputPrinter.printPurchaseResult(purchasedLottoList);
        return new PurchasedLotto(purchasedLottoList);
    }

    @Contract(" -> new")
    private @NotNull WinningLotto getWinningInfo() {
        List<Integer> winningDigitList = getWinningDigitList();
        int bonusDigit = getBonusDigit(winningDigitList);
        return new WinningLotto(winningDigitList, bonusDigit);
    }

    private List<Integer> getWinningDigitList() {
        try {
            return lottoInputScanner.getWinningDigits();
        } catch (IllegalArgumentException iae) {
            System.out.println(iae.getMessage());
            return getWinningDigitList();
        }
    }

    private int getBonusDigit(List<Integer> winningDigitList) {
        try {
            return lottoInputScanner.getWinningBonusDigit(winningDigitList);
        } catch (IllegalArgumentException iae) {
            System.out.println(iae.getMessage());
            return getBonusDigit(winningDigitList);
        }
    }

    private double getSimulationYield(long purchaseAmount, @NotNull WinningResult winningResult) {
        long totalReward = winningResult.getWinningResult().stream().mapToLong(LottoResult::getReward).sum();
        return (double) (totalReward - purchaseAmount) / purchaseAmount * 100;
    }

    private void printWinningStat(long purchaseAmount, @NotNull PurchasedLotto purchasedLotto, WinningLotto winningLotto) {
        WinningResult winningResult = new WinningResult(purchasedLotto.getPurchasedResult(winningLotto));
        double yield = getSimulationYield(purchaseAmount, winningResult);
        lottoOutputPrinter.printWinningResultPrinter(winningResult);
        lottoOutputPrinter.printWinningYield(yield);
    }
}
