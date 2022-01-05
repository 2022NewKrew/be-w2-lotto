package lotto;

import lotto.domain.*;
import lotto.view.LottoInputScanner;
import lotto.view.LottoOutputPrinter;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.LongStream;

public class LottoSimulator {
    public static final long LOTTO_PRICE = 1000;
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

        long numOfManualLotto = getNumOfManualLotto();
        PurchaseInfo purchasedInfo = new PurchaseInfo(numOfManualLotto, purchaseAmount / LOTTO_PRICE - numOfManualLotto);
        List<Lotto> manualLottoList = getManualLotto(purchasedInfo.getNumOfManualLottos());
        PurchasedLotto purchasedLotto = purchaseLotto(purchasedInfo, manualLottoList);
        WinningLotto winningLotto = getWinningInfo();
        printWinningStat(purchaseAmount, purchasedLotto, winningLotto);
    }

    private long getPurchaseAmount() {
        try {
            return lottoInputScanner.getPurchaseAmount();
        } catch (NumberFormatException nfe) {
            lottoOutputPrinter.printDescription("숫자만 입력가능합니다.");
            return getPurchaseAmount();
        } catch (InputMismatchException ime) {
            lottoOutputPrinter.printDescription(ime.getMessage());
            return getPurchaseAmount();
        }
    }

    private List<Lotto> getManualLotto(long numOfManualLottos) {
        lottoOutputPrinter.printDescription("\n수동으로 구매할 번호를 입력해 주세요.\n");
        try {
            return LongStream.range(0, numOfManualLottos)
                    .mapToObj(i -> new Lotto(lottoInputScanner.getDigits()))
                    .collect(Collectors.toList());
        } catch (IllegalArgumentException iae) {
            lottoOutputPrinter.printDescription(iae.getMessage());
            lottoOutputPrinter.printDescription("처음부터 다시 입력바랍니다.");
            return getManualLotto(numOfManualLottos);
        }
    }

    private long getNumOfManualLotto() {
        try {
            return lottoInputScanner.getNumOfManualLottos();
        } catch (NumberFormatException nfe) {
            lottoOutputPrinter.printDescription("숫자만 입력가능합니다.");
            return getNumOfManualLotto();
        } catch (InputMismatchException ime) {
            lottoOutputPrinter.printDescription(ime.getMessage());
            return getNumOfManualLotto();
        }
    }

    @Contract("_, _ -> new")
    private @NotNull PurchasedLotto purchaseLotto(@NotNull PurchaseInfo purchasedInfo, List<Lotto> manualLottoList) {
        LottoAutoGenerator lottoAutoGenerator = new LottoAutoGenerator();
        List<Lotto> purchasedLottoList = new ArrayList<>(manualLottoList);

        purchasedLottoList.addAll(lottoAutoGenerator.getRandomLottos(purchasedInfo.getNumOfAutoLottos()));
        lottoOutputPrinter.printPurchaseResult(purchasedInfo.getNumOfManualLottos(), purchasedLottoList);

        return new PurchasedLotto(purchasedLottoList);
    }

    private @NotNull WinningLotto getWinningInfo() {
        lottoOutputPrinter.printDescription("\n지난주 당첨 정보를 입력해 주세요.\n");
        try {
            List<Integer> winningDigitList = lottoInputScanner.getDigits();
            int bonusDigit = lottoInputScanner.getWinningBonusDigit();
            return new WinningLotto(winningDigitList, bonusDigit);
        } catch (IllegalArgumentException iae) {
            lottoOutputPrinter.printDescription(iae.getMessage());
            return getWinningInfo();
        }
    }

    private void printWinningStat(long purchaseAmount, @NotNull PurchasedLotto purchasedLotto, WinningLotto winningLotto) {
        WinningResult winningResult = new WinningResult(purchasedLotto.getPurchasedResult(winningLotto));
        double yield = getSimulationYield(purchaseAmount, winningResult);
        lottoOutputPrinter.printWinningResultPrinter(winningResult);
        lottoOutputPrinter.printWinningYield(yield);
    }

    private double getSimulationYield(long purchaseAmount, @NotNull WinningResult winningResult) {
        long totalReward = winningResult.getWinningResult().stream().mapToLong(LottoResult::getReward).sum();
        return (double) (totalReward - purchaseAmount) / purchaseAmount * 100;
    }
}
