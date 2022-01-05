package lotto.controller;

import lotto.domain.LottoDTO;
import lotto.domain.winningstats.WinningStats;
import lotto.domain.winningstats.lottobundle.LottoBundle;
import lotto.view.ConsoleInputView;
import lotto.view.ConsoleOutputView;

import java.util.List;

public class LottoController {

    private LottoBundle lottoBundle;
    private WinningStats winningStats;
    private int lottoPurchaseMoney;
    List<Integer> lastWeekLottoNumberList;
    private int bonusBall;

    public LottoController() {
    }

    public void purchaseLottoBundleInView() {
        int lottoPurchaseMoney = ConsoleInputView.getLottoPurchaseMoney();
        constructLottoBundle(lottoPurchaseMoney);
    }

    private void constructLottoBundle(int lottoPurchaseMoney) {
        this.lottoPurchaseMoney = lottoPurchaseMoney;
        this.lottoBundle = new LottoBundle(lottoPurchaseMoney);
    }

    public void printLottoBundle() {
        ConsoleOutputView.printLottoCount(lottoBundle.getCount());
        ConsoleOutputView.printLottoBundle(lottoBundle);
    }

    public void getLastWeekLottoNumberList() {
        this.lastWeekLottoNumberList = LottoDTO.getLastWeekLottoNumberList(ConsoleInputView.getLastWeekLottoNumbers());
    }

    public void constructWinningStats() {
        this.winningStats = new WinningStats(lottoBundle, lastWeekLottoNumberList, lottoPurchaseMoney, bonusBall);
    }

    public void printWinningStats() {
        ConsoleOutputView.printWinningStats(winningStats);
    }

    public void getBonusBall() {
        String bonusBall = ConsoleInputView.getBonusBall();
        this.bonusBall = Integer.parseInt(bonusBall);
    }
}
