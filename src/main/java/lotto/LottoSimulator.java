package lotto;

import lotto.domain.*;
import lotto.view.LottoInputScanner;
import lotto.view.LottoOutputPrinter;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

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

        List<Lotto> manualLottoList = getManualLotto();
        PurchasedLotto purchasedLotto = purchaseLotto(purchaseAmount, manualLottoList);
        WinningLotto winningLotto = getWinningInfo();
        printWinningStat(purchaseAmount, purchasedLotto, winningLotto);
    }

    private long getPurchaseAmount() {
        try {
            return lottoInputScanner.getPurchaseAmount();
        } catch (IllegalArgumentException iae) {
            System.out.println("금액을 확인해주십시오.(lotto는 1000원 단위로 구매 가능합니다.)");
            return getPurchaseAmount();
        }
    }

    private List<Lotto> getManualLotto() {
        int numManualLotto = getNumManualLotto();
        List<Lotto> manualLottoList = new ArrayList<>();
        for (int i = 0; i < numManualLotto; i++) {
            manualLottoList.add(new Lotto(getDigitList(i == 0 ? "\n수동으로 구매할 번호를 입력해 주세요.\n" : "")));
        }
        return new ArrayList<>(manualLottoList);
    }

    private int getNumManualLotto() {
        try {
            return lottoInputScanner.getNumManualLottos();
        } catch (IllegalArgumentException iae) {
            System.out.println("구매할 로또 수는 0이상 정수여야 합니다.");
            return getNumManualLotto();
        }
    }

    private List<Integer> getDigitList(String msg) {
        try {
            return lottoInputScanner.getDigits(msg);
        } catch (IllegalArgumentException iae) {
            System.out.println("번호는 1~45사이의 숫자 6개로 중복이 없어야 합니다.");
            return getDigitList(msg);
        }
    }

    private @NotNull PurchasedLotto purchaseLotto(long purchaseAmount, List<Lotto> manualLottoList) {
        LottoAutoGenerator lottoAutoGenerator = new LottoAutoGenerator();
        List<Lotto> purchasedLottoList = new ArrayList<>(manualLottoList);
        int numManualLottos = manualLottoList.size();
        long purchaseAutoAmount = purchaseAmount - ((long) numManualLottos * LOTTO_PRICE);

        purchasedLottoList.addAll(lottoAutoGenerator.getRandomLottos(purchaseAutoAmount / LOTTO_PRICE));
        lottoOutputPrinter.printPurchaseResult(numManualLottos, purchasedLottoList);

        return new PurchasedLotto(purchasedLottoList);
    }

    private @NotNull WinningLotto getWinningInfo() {
        List<Integer> winningDigitList = getDigitList("\n지난주 당첨 정보를 입력해 주세요.\n");
        int bonusDigit = getBonusDigit(winningDigitList);
        return new WinningLotto(winningDigitList, bonusDigit);
    }

    private int getBonusDigit(List<Integer> winningDigitList) {
        try {
            return lottoInputScanner.getWinningBonusDigit(winningDigitList);
        } catch (IllegalArgumentException iae) {
            System.out.println("보너스 숫자는 1~45 사이의 값이며 당첨 번호와 중복될 수 없습니다.");
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
