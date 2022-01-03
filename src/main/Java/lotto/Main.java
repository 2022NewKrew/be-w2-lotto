package lotto;

import lotto.com.kakao.LottoBundle;
import lotto.com.kakao.WinningStats;
import lotto.controller.ConsoleInput;
import lotto.view.ConsoleOutput;

import java.util.List;

public class Main {
    public static void main(String[] args) {
            int lottoPurchaseMoney = ConsoleInput.getLottoPurchaseMoney();
            LottoBundle lottoBundle = new LottoBundle(lottoPurchaseMoney);
            ConsoleOutput.printLottoCount(lottoBundle.getCount());
            ConsoleOutput.printLottoBundle(lottoBundle);
            List<Integer> lastWeekLottoNumberList = ConsoleInput.getLastWeekLottoNumberList();
            WinningStats winningStats = new WinningStats(lottoBundle,lastWeekLottoNumberList,lottoPurchaseMoney);
    }
}
