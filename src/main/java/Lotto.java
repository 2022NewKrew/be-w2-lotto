import domain.Lottery;
import domain.LotteryFactory;
import domain.Result;
import domain.WinningLottery;
import view.ConsoleInputView;
import view.ConsoleOutputView;
import view.InputView;
import view.OutputView;

import java.util.List;

public class Lotto {
    public static void main(String[] args) {
        InputView inputView = new ConsoleInputView();
        OutputView outputView = new ConsoleOutputView();

        long lotteryBoughtPrice = inputView.getLotteryBoughtPrice();
        List<Lottery> lotteries = LotteryFactory.buildLotteries(lotteryBoughtPrice);
        outputView.printBoughtLotteries(lotteries);

        WinningLottery winningLottery = new WinningLottery(inputView.getResult());
        Result result = new Result(lotteryBoughtPrice);
        result.add(winningLottery.checkRank(lotteries));

        outputView.printResult(result);
    }
}
