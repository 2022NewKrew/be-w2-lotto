package lotto;

import lotto.domain.*;
import lotto.view.LottoInputScanner;
import lotto.view.LottoOutputPrinter;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;

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

        long numOfManualLottos = getNumOfManualLotto();
        List<String> manualLottoList = lottoInputScanner.getManualLottoNumberStringList(numOfManualLottos);
        PurchaseInfo purchasedInfo = new PurchaseInfo(purchaseAmount, numOfManualLottos, manualLottoList);
        PurchasedLottos purchasedLottos = purchaseLotto(purchasedInfo);
        WinningLotto winningLotto = getWinningInfo();
        printWinningStat(purchaseAmount, purchasedLottos, winningLotto);
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

    private @NotNull PurchasedLottos purchaseLotto(@NotNull PurchaseInfo purchaseInfo) {
        try {
            long numOfManualLottos = purchaseInfo.getNumOfManualLottos();
            List<Lotto> purchasedLottoList = getPurchasedLottoList(purchaseInfo);
            lottoOutputPrinter.printPurchaseResult(numOfManualLottos, purchasedLottoList);
            return new PurchasedLottos(purchasedLottoList);
        } catch (IllegalArgumentException iae) {
            lottoOutputPrinter.printDescription(iae.getMessage());
            return purchaseLotto(purchaseInfo);
        }
    }

    private List<Lotto> getPurchasedLottoList(PurchaseInfo purchaseInfo) throws IllegalArgumentException {
        LottoGenerator manualLottoGenerator = new ManualLottoGenerator(purchaseInfo.getManualLottoList());
        LottoGenerator autoLottoGenerator = new AutoLottoGenerator(purchaseInfo.getNumOfAutoLottos());
        List<Lotto> purchasedLottoList = new ArrayList<>();
        purchasedLottoList.addAll(manualLottoGenerator.generate());
        purchasedLottoList.addAll(autoLottoGenerator.generate());

        return purchasedLottoList;
    }

    private @NotNull WinningLotto getWinningInfo() {
        lottoOutputPrinter.printDescription("\n지난주 당첨 정보를 입력해 주세요.\n");
        try {
            List<LottoNumber> winningLottoNumberList = lottoInputScanner.getWinningLottoNumberList();
            LottoNumber bonusNumber = lottoInputScanner.getBonusNumber();
            return new WinningLotto(new Lotto(winningLottoNumberList), bonusNumber);
        } catch (IllegalArgumentException iae) {
            lottoOutputPrinter.printDescription(iae.getMessage());
            return getWinningInfo();
        }
    }

    private void printWinningStat(long purchaseAmount, @NotNull PurchasedLottos purchasedLottos, WinningLotto winningLotto) {
        WinningResult winningResult = WinningResult.winningResultOf(winningLotto, purchasedLottos);
        double yield = winningResult.getYield(purchaseAmount);
        lottoOutputPrinter.printWinningResultPrinter(winningResult);
        lottoOutputPrinter.printWinningYield(yield);
    }
}
