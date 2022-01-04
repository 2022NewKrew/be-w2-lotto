import domain.*;
import view.ConsoleInputView;
import view.ConsoleOutputView;
import view.InputView;
import view.OutputView;

import java.util.List;

public class Lotto {
    private static final int LOTTERY_NUMBER_START = 1;
    private static final int LOTTERY_NUMBER_END = 45;
    private static final int LOTTERY_NUMBER_COUNT = 6;

    private static final int LOTTERY_UNIT_PRICE = 1000;

    public static void main(String[] args) {
        Rule lotteryRule = new Rule.Builder()
                .lotteryNumberStart(LOTTERY_NUMBER_START)
                .lotteryNumberEnd(LOTTERY_NUMBER_END)
                .lotteryNumberCount(LOTTERY_NUMBER_COUNT)
                .lotteryUnitPrice(LOTTERY_UNIT_PRICE)
                .build();
        InputView inputView = new ConsoleInputView(lotteryRule);
        OutputView outputView = new ConsoleOutputView();

        long lotteryBoughtPrice = inputView.getLotteryBoughtPrice();
        List<Lottery> lotteries = LotteryFactory.buildLotteries(lotteryBoughtPrice, lotteryRule);
        outputView.printBoughtLotteries(lotteries);

        WinningLottery winningLottery = new WinningLottery(inputView.getLotteryNumberList());
        Result result = Result.of(lotteryBoughtPrice, lotteries, winningLottery);

        outputView.printResult(result);
    }
}
