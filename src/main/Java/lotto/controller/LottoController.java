package lotto.controller;

import lotto.domain.winningstats.WinningStats;
import lotto.domain.winningstats.lastweeknumberBundle.LastWeekLottoNumberList;
import lotto.domain.winningstats.lottobundle.LottoBundle;
import lotto.domain.winningstats.lottobundle.LottoList;
import lotto.view.ConsoleInputView;
import lotto.view.ConsoleOutputView;

public class LottoController {

    public LottoController() {
    }

    public LottoBundle purchaseLottoBundleInView() {
        int lottoPurchaseMoney = ConsoleInputView.getLottoPurchaseMoney();
        LottoBundle lottoBundle = new LottoBundle(
                lottoPurchaseMoney,
                purchaseManualLotto()
        );
        printLottoBundle(lottoBundle);
        return lottoBundle;
    }
    private String purchaseManualLotto(){
        long manualLottoCount = ConsoleInputView.getManualCount();
        return ConsoleInputView.getManualLottoNumbers(manualLottoCount);
    }

    public void printLottoBundle(LottoBundle lottoBundle) {
        ConsoleOutputView.printLottoCount(lottoBundle.getAutoCount(),lottoBundle.getManualLottoCount());
        ConsoleOutputView.printLottoBundle(lottoBundle);
    }

    public LastWeekLottoNumberList getLastWeekLottoNumberList() {
        String lastWeekLottoNumbers = ConsoleInputView.getLastWeekLottoNumbers();
        return new LastWeekLottoNumberList(lastWeekLottoNumbers);
    }

    public WinningStats constructWinningStats(LottoBundle lottoBundle) {
        LastWeekLottoNumberList lastWeekLottoNumberList = getLastWeekLottoNumberList();
        int bonusBall = getBonusBall();
        return new WinningStats(lottoBundle, lastWeekLottoNumberList, bonusBall);
    }

    public void printWinningStats(WinningStats winningStats) {
        ConsoleOutputView.printWinningStats(winningStats);
    }

    public int getBonusBall() {
        String bonusBall = ConsoleInputView.getBonusBall();
        return Integer.parseInt(bonusBall);
    }
}
