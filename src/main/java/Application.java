import controller.LotteryGameController;
import domain.LotteryGame;
import domain.Rank;
import view.InputView;
import view.OutputView;

import java.util.List;
import java.util.Map;

public class Application {
    public static void main(String[] args) {

        int totalPrice = InputView.inputTotalPrice();
        LotteryGameController lotteryGameController = new LotteryGameController(totalPrice);

        int numberOfManual = InputView.inputNumberOfManual();
        lotteryGameController.setManualLottery(numberOfManual);

        List<List<Integer>> manualLotteries = InputView.inputManualLotteries();
        lotteryGameController.startLotteryGame(manualLotteries);

        LotteryGame lotteryGame = lotteryGameController.getLotteryGame();
        OutputView.outputLotteryNumbers(lotteryGame);

        List<Integer> winningNumbers = InputView.inputWinningNumbers();
        int bonusNumber = InputView.inputBonusNumber();
        Map<Rank, Integer> results = lotteryGameController.getResult(winningNumbers, bonusNumber);
        long profit = lotteryGameController.getProfit(results);
        OutputView.outputResults(results, profit);
    }
}
