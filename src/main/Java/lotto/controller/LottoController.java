package lotto.controller;

import lotto.domain.LottoDTO;
import lotto.domain.WinningStats;
import lotto.domain.lottobundle.LottoBundle;
import lotto.view.ConsoleInputView;
import lotto.view.ConsoleOutputView;

import java.util.List;

public class LottoController {

    private LottoBundle lottoBundle;
    private WinningStats winningStats;
    private int lottoPurchaseMoney;
    List<Integer> lastWeekLottoNumberList;

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
        this.winningStats = new WinningStats(lottoBundle, lastWeekLottoNumberList, lottoPurchaseMoney);
    }

    public void printWinningStats() {
        ConsoleOutputView.printWinningStats(winningStats);
    }
}
