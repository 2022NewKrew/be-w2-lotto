package lottogame.view;

import lottogame.domain.lottery.LotteryTickets;
import lottogame.domain.statistics.Statistics;
import lottogame.dto.PurchasedPrice;
import lottogame.dto.WinningNumbers;

import java.util.List;

public class LottoGameView {
    public LottoGameView() {
    }

    public PurchasedPrice inputPurchasedPrice() {
        OutputView.print("구입금액을 입력해 주세요.");
        int input = InputView.inputInteger();
        PurchasedPrice purchasedPrice = new PurchasedPrice();
        purchasedPrice.setPrice(input);
        return purchasedPrice;
    }

    public WinningNumbers inputWinningNumbers() {
        final String DELIMITER = ", ";
        OutputView.print("지난 주 당첨 번호를 입력해 주세요.");
        List<Integer> input = InputView.inputIntegers(DELIMITER);
        WinningNumbers winningNumbers = new WinningNumbers();
        winningNumbers.setNumbers(input);
        return winningNumbers;
    }

    public void printPurchasedTickets(LotteryTickets tickets) {
        OutputView.print(tickets);
    }

    public void printWinningStatistic(Statistics statistics) {
        OutputView.print(statistics);
    }
}
