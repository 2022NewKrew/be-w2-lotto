import controller.LotteryController;
import domain.LotteryGame;
import domain.Result;
import view.InputView;
import view.OutputView;

import java.util.List;
import java.util.Map;

public class Application {
    public static void main(String[] args) {

        int totalPrice = InputView.inputTotalPrice();

        LotteryController lotteryController = new LotteryController(totalPrice);
        LotteryGame lotteryGame = lotteryController.getLotteryGame();

        OutputView.outputLotteryNumbers(lotteryGame);

        List<Integer> winningNumbers = InputView.inputWinningNumbers();

        Map<Integer, Result> results = lotteryController.getResult(winningNumbers);
        long profit = lotteryController.getProfit();

        OutputView.outputResults(results, profit);
    }
}

