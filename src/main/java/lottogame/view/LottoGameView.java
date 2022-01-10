package lottogame.view;

import lottogame.domain.Amount;
import lottogame.domain.LotteryTickets;
import lottogame.domain.RateOfReturn;
import lottogame.dto.Statistics;

import java.util.ArrayList;
import java.util.List;

public class LottoGameView {
    private static final String DELIMITER = ", ";
    public LottoGameView() {
    }

    public int inputPurchasedPrice() {
        OutputView.print("구입금액을 입력해 주세요.");
        return InputView.inputInteger();
    }

    public int inputManualPurchasedAmount() {
        OutputView.print();
        OutputView.print("수동으로 구매할 로또 수를 입력해 주세요.");
        return InputView.inputInteger();
    }

    public List<List<Integer>> inputManualPurchasedTickets(Amount amount) {
        OutputView.print();
        OutputView.print("수동으로 구매할 번호를 입력해 주세요.");
        List<List<Integer>> manualPurchasedTickets = new ArrayList<>();
        for (int i = 0; i < amount.getAmount(); i++) {
            manualPurchasedTickets.add(InputView.inputIntegers(DELIMITER));
        }
        return manualPurchasedTickets;
    }

    public List<Integer> inputWinningNumbers() {
        OutputView.print("지난 주 당첨 번호를 입력해 주세요.");
        return InputView.inputIntegers(DELIMITER);
    }

    public int inputBonusBall() {
        OutputView.print("보너스 볼을 입력해 주세요.");
        return InputView.inputInteger();
    }

    public void printLotteryTickets(LotteryTickets manualTickets, LotteryTickets autoTickets) {
        OutputView.print();
        OutputView.print(String.format("수동으로 %d개, 자동으로 %d개를 구매했습니다.", manualTickets.getCount(), autoTickets.getCount()));
        OutputView.print(manualTickets);
        OutputView.print(autoTickets);
    }

    public void printWinningStatistic(Statistics statistics, RateOfReturn rateOfReturn) {
        OutputView.print();
        OutputView.print("당첨 통계");
        OutputView.print("---------");
        OutputView.print(statistics);
        OutputView.print(rateOfReturn);
    }
}
