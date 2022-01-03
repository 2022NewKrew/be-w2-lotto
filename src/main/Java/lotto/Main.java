package lotto;

import lotto.com.kakao.LottoBundle;
import lotto.controller.ConsoleInput;
import lotto.view.ConsoleOutput;

public class Main {
    public static void main(String[] args) {
            int lottoPurchaseMoney = ConsoleInput.getLottoPurchaseMoney();
            LottoBundle lottoBundle = new LottoBundle(lottoPurchaseMoney);
            ConsoleOutput.printLottoCount(lottoBundle.getCount());
            ConsoleOutput.printLottoBundle(lottoBundle);
            ConsoleInput.getLastWeekLottoNumbers();
    }
}
