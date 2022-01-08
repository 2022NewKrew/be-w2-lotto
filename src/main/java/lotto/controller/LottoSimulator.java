package lotto.controller;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import lotto.domain.AutoLottoGenerator;
import lotto.domain.Lotto;
import lotto.domain.LottoGenerator;
import lotto.domain.LottoNumber;
import lotto.domain.ManualLottoGenerator;
import lotto.domain.PurchaseInfo;
import lotto.domain.PurchasedLottos;
import lotto.domain.WinningLotto;
import lotto.domain.WinningResult;
import lotto.exception.DuplicationException;
import lotto.exception.IllegalLottoNumberException;
import lotto.exception.NumOfLottoNumbersMismatchException;
import lotto.view.LottoInputScanner;
import lotto.view.LottoInputScannerOnWeb;
import lotto.view.LottoOutputPrinter;
import lotto.view.LottoOutputPrinterOnWeb;
import org.jetbrains.annotations.NotNull;

public class LottoSimulator {

    public static final long LOTTO_PRICE = 1000;
    public static final String SEPARATOR = ",";
    public static final int NOT_PURCHASE = 0;

    private final LottoInputScanner lottoInputScanner;
    private final LottoOutputPrinter lottoOutputPrinter;

    public LottoSimulator(LottoInputScanner lottoInputScanner,
        LottoOutputPrinter lottoOutputPrinter) {
        this.lottoInputScanner = lottoInputScanner;
        this.lottoOutputPrinter = lottoOutputPrinter;
    }

    public void start() {
        long purchaseAmount = getPurchaseAmount();
        if (purchaseAmount == NOT_PURCHASE) {
            return;
        }

        long numOfManualLottos = getNumOfManualLotto();
        try {
            List<String> manualLottoList = lottoInputScanner.getManualLottoNumberStringList(
                numOfManualLottos);
            PurchaseInfo purchasedInfo = new PurchaseInfo(purchaseAmount, numOfManualLottos,
                manualLottoList);
            PurchasedLottos purchasedLottos = purchaseLotto(purchasedInfo);
            WinningLotto winningLotto = getWinningInfo();
            printWinningStat(purchaseAmount, purchasedLottos, winningLotto);
        } catch (IllegalLottoNumberException | DuplicationException | NumOfLottoNumbersMismatchException e) {
            lottoOutputPrinter.printDescription(e.getMessage());
            start();
        }
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

    PurchasedLottos purchaseLotto(@NotNull PurchaseInfo purchaseInfo)
        throws IllegalLottoNumberException, DuplicationException, NumOfLottoNumbersMismatchException {
        long numOfManualLottos = purchaseInfo.getNumOfManualLottos();
        List<Lotto> purchasedLottoList = getPurchasedLottoList(purchaseInfo);
        lottoOutputPrinter.printPurchaseResult(numOfManualLottos, purchasedLottoList);
        return new PurchasedLottos(purchasedLottoList);
    }

    private List<Lotto> getPurchasedLottoList(PurchaseInfo purchaseInfo)
        throws IllegalLottoNumberException, DuplicationException, NumOfLottoNumbersMismatchException {
        LottoGenerator manualLottoGenerator = new ManualLottoGenerator(
            purchaseInfo.getManualLottoList());
        LottoGenerator autoLottoGenerator = new AutoLottoGenerator(
            purchaseInfo.getNumOfAutoLottos());
        List<Lotto> purchasedLottoList = new ArrayList<>();
        purchasedLottoList.addAll(manualLottoGenerator.generate());
        purchasedLottoList.addAll(autoLottoGenerator.generate());

        return purchasedLottoList;
    }

    public @NotNull WinningLotto getWinningInfo() {
        lottoOutputPrinter.printDescription("\n지난주 당첨 정보를 입력해 주세요.\n");
        try {
            List<LottoNumber> winningLottoNumberList = lottoInputScanner.getWinningLottoNumberList();
            LottoNumber bonusNumber = lottoInputScanner.getBonusNumber();
            return new WinningLotto(new Lotto(winningLottoNumberList), bonusNumber);
        } catch (DuplicationException | NumOfLottoNumbersMismatchException | IllegalLottoNumberException e) {
            e.printStackTrace();
            lottoOutputPrinter.printDescription(e.getMessage());
            return getWinningInfo();
        }
    }

    public void printWinningStat(long purchaseAmount, @NotNull PurchasedLottos purchasedLottos,
        WinningLotto winningLotto) {
        WinningResult winningResult = WinningResult.winningResultOf(winningLotto, purchasedLottos);
        double yield = winningResult.getYield(purchaseAmount);
        lottoOutputPrinter.printWinningResultPrinter(winningResult);
        lottoOutputPrinter.printWinningYield(yield);
    }

    public LottoInputScannerOnWeb getLottoInputScanner() {
        return (LottoInputScannerOnWeb) lottoInputScanner;
    }

    public LottoOutputPrinterOnWeb getLottoOutputPrinter() {
        return (LottoOutputPrinterOnWeb) lottoOutputPrinter;
    }
}
