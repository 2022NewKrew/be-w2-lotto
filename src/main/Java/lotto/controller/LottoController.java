package lotto.controller;

import lotto.exception.IllegalManualLottoInputException;
import lotto.exception.IllegalPurchaseMoneyException;
import lotto.domain.winningstats.WinningStats;
import lotto.domain.winningstats.lottobundle.LottoBundle;
import lotto.domain.winningstats.lottobundle.lottoticket.Lotto;
import lotto.view.ConsoleInputView;
import lotto.view.ConsoleOutputView;

import java.util.InputMismatchException;

public class LottoController {

    public LottoController() {
    }

    public LottoBundle purchaseLottoBundleInView() {
        final int LOTTO_PRICE = 1000;
        int lottoPurchaseMoney;
        LottoBundle lottoBundle;

        while (true) {
            try {
                lottoPurchaseMoney = ConsoleInputView.getLottoPurchaseMoney(LOTTO_PRICE);
                break;
            } catch (IllegalPurchaseMoneyException e) {
                ConsoleOutputView.printError(e);
                ConsoleOutputView.printReInputMessage();
            }
        }
        while (true) {
            try {
                lottoBundle = new LottoBundle(
                        lottoPurchaseMoney,
                        purchaseManualLotto(),
                        LOTTO_PRICE
                );
                break;
            } catch (IllegalManualLottoInputException e) {
                ConsoleOutputView.printError(e);
                ConsoleOutputView.printReInputMessage();
            }
        }

        printLottoBundle(lottoBundle);
        return lottoBundle;
    }

    private String purchaseManualLotto() throws InputMismatchException{
        long manualLottoCount = ConsoleInputView.getManualCount();
        return ConsoleInputView.getManualLottoNumbers(manualLottoCount);
    }

    public void printLottoBundle(LottoBundle lottoBundle) {
        ConsoleOutputView.printLottoCount(lottoBundle.getAutoCount(), lottoBundle.getManualLottoCount());
        ConsoleOutputView.printLottoBundle(lottoBundle);
    }

    public Lotto getLastWeekWinLotto() {
        String lastWeekLottoNumbers = ConsoleInputView.getLastWeekLottoNumbers();
        return new Lotto(lastWeekLottoNumbers);
    }

    public WinningStats constructWinningStats(LottoBundle lottoBundle) {
        Lotto lastWeekWinLotto = getLastWeekWinLotto();
        int bonusBall = getBonusBall();
        return new WinningStats(lottoBundle, lastWeekWinLotto, bonusBall);
    }

    public void printWinningStats(WinningStats winningStats) {
        ConsoleOutputView.printWinningStats(winningStats);
    }

    public int getBonusBall() {
        String bonusBall = ConsoleInputView.getBonusBall();
        return Integer.parseInt(bonusBall);
    }
}
