package lottogame.view;

import lottogame.domain.LotteryTickets;
import lottogame.domain.Statistics;

import java.util.List;

public class LottoGameView {
    public LottoGameView() {
    }

    public int inputPurchaseAmount() {
        OutputView.print("구입금액을 입력해 주세요.");
        return InputView.inputInteger();
    }

    public List<Integer> inputWinningNumbers() {
        final String DELIMITER = ", ";
        OutputView.print("지난 주 당첨 번호를 입력해 주세요.");
        return InputView.inputIntegers(DELIMITER);
    }

    public int inputBonusBall() {
        OutputView.print("보너스 볼을 입력해 주세요.");
        return InputView.inputInteger();
    }

    public void printLotteryTickets(LotteryTickets lotteryTickets) {
        OutputView.print(lotteryTickets);
    }

    public void printWinningStatistic(Statistics statistics, int rateOfReturn) {
        OutputView.print();
        OutputView.print("당첨 통계");
        OutputView.print("---------");
        OutputView.print(statistics);
        OutputView.print(rateOfReturn);
    }
}
