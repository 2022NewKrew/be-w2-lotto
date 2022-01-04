package lotto;

import lotto.com.kakao.LottoBundle;
import lotto.com.kakao.WinningStats;
import lotto.view.ConsoleInputView;
import lotto.view.ConsoleOutputView;

import java.util.List;

public class Main {
    public static void main(String[] args) {
            int lottoPurchaseMoney = ConsoleInputView.getLottoPurchaseMoney();
            LottoBundle lottoBundle = new LottoBundle(lottoPurchaseMoney);
            ConsoleOutputView.printLottoCount(lottoBundle.getCount());
            ConsoleOutputView.printLottoBundle(lottoBundle);
            List<Integer> lastWeekLottoNumberList = ConsoleInputView.getLastWeekLottoNumberList();
            WinningStats winningStats = new WinningStats(lottoBundle,lastWeekLottoNumberList,lottoPurchaseMoney);
            ConsoleOutputView.printWinningStats(winningStats);
    }
}
