package lotto;

import lotto.domain.*;
import lotto.view.LottoInputScanner;
import lotto.view.LottoOutputPrinter;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoSimulator {
    public static final int LOTTO_PRICE = 1000;
    public static final String SEPARATOR = ",";
    public static final int NOT_PURCHASE = 0;

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
        if (purchaseAmount == NOT_PURCHASE) {
            return;
        }

        int numOfManualLotto = getNumOfManualLotto();
        List<Lotto> manualLottoList = getManualLotto(numOfManualLotto);
        PurchasedLotto purchasedLotto = purchaseLotto(purchaseAmount, manualLottoList);
        WinningLotto winningLotto = getWinningInfo();
        printWinningStat(purchaseAmount, purchasedLotto, winningLotto);
    }

    private long getPurchaseAmount() {
        try {
            return lottoInputScanner.getPurchaseAmount();
        } catch (NumberFormatException nfe) {
            System.out.println("숫자만 입력가능합니다.");
            return getPurchaseAmount();
        } catch (InputMismatchException ime) {
            System.out.println(ime.getMessage());
            return getPurchaseAmount();
        }
    }

    private List<Lotto> getManualLotto(int numOfManualLotto) {
        lottoOutputPrinter.printDescription("\n수동으로 구매할 번호를 입력해 주세요.\n");
        try {
            return IntStream.range(0, numOfManualLotto)
                    .mapToObj(i -> new Lotto(lottoInputScanner.getDigits()))
                    .collect(Collectors.toList());
        } catch (IllegalArgumentException iae) {
            System.out.println(iae.getMessage());
            System.out.println("처음부터 다시 입력바랍니다.");
            return getManualLotto(numOfManualLotto);
        }
    }

    private int getNumOfManualLotto() {
        try {
            return lottoInputScanner.getNumOfManualLottos();
        } catch (NumberFormatException nfe) {
            System.out.println("숫자만 입력가능합니다.");
            return getNumOfManualLotto();
        } catch (InputMismatchException ime) {
            System.out.println(ime.getMessage());
            return getNumOfManualLotto();
        }
    }

    private @NotNull PurchasedLotto purchaseLotto(long purchaseAmount, List<Lotto> manualLottoList) {
        LottoAutoGenerator lottoAutoGenerator = new LottoAutoGenerator();
        List<Lotto> purchasedLottoList = new ArrayList<>(manualLottoList);
        int numOfManualLottos = manualLottoList.size();
        long purchaseAutoAmount = purchaseAmount - ((long) numOfManualLottos * LOTTO_PRICE);

        purchasedLottoList.addAll(lottoAutoGenerator.getRandomLottos(purchaseAutoAmount / LOTTO_PRICE));
        lottoOutputPrinter.printPurchaseResult(numOfManualLottos, purchasedLottoList);

        return new PurchasedLotto(purchasedLottoList);
    }

    private @NotNull WinningLotto getWinningInfo() {
        lottoOutputPrinter.printDescription("\n지난주 당첨 정보를 입력해 주세요.\n");
        try {
            List<Integer> winningDigitList = lottoInputScanner.getDigits();
            int bonusDigit = lottoInputScanner.getWinningBonusDigit();
            return new WinningLotto(winningDigitList, bonusDigit);
        } catch (IllegalArgumentException iae) {
            System.out.println(iae.getMessage());
            return getWinningInfo();
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
