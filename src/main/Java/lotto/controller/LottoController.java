package lotto.controller;

import lotto.domain.LottoDTO;
import lotto.domain.winningstats.WinningStats;
import lotto.domain.winningstats.lastweeknumber.LastWeekNumber;
import lotto.domain.winningstats.lottobundle.LottoBundle;
import lotto.view.ConsoleInputView;
import lotto.view.ConsoleOutputView;

import java.util.List;

public class LottoController {

    public LottoController() {
    }

    public LottoBundle purchaseLottoBundleInView() {
        int lottoPurchaseMoney = ConsoleInputView.getLottoPurchaseMoney();
        LottoBundle lottoBundle = new LottoBundle(lottoPurchaseMoney);
        printLottoBundle(lottoBundle);
    }

    public void printLottoBundle(LottoBundle lottoBundle) {
        ConsoleOutputView.printLottoCount(lottoBundle.getCount());
        ConsoleOutputView.printLottoBundle(lottoBundle);
    }

    public List<Integer> getLastWeekLottoNumberList() {
        return LottoDTO.getLastWeekLottoNumberList(ConsoleInputView.getLastWeekLottoNumbers());
    }

    public WinningStats constructWinningStats(LottoBundle lottoBundle) {
        List<Integer> lastWeekLottoNumberList = getLastWeekLottoNumberList();
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
