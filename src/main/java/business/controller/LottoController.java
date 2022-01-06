package business.controller;

import business.domain.LotteryCount;
import business.domain.LotteryMachine;
import business.domain.LotteryNumber;
import business.domain.LotteryNumbers;
import business.domain.LotteryResult;
import business.domain.LotteryTicket;
import business.domain.Money;
import business.domain.Statistics;
import business.exception.ExceptionHandler;
import ui.view.ConsoleInputView;
import ui.view.ConsoleOutputView;
import ui.view.InputView;
import ui.view.OutputView;

public class LottoController {

    public static void run() {
        InputView inputView = new ConsoleInputView();
        OutputView outputView = new ConsoleOutputView();
        ExceptionHandler exceptionHandler = new ExceptionHandler();

        try {
            Money lotteryBoughtPrice = new Money(inputView.getBudget());

            LotteryCount lotteryCount = lotteryBoughtPrice.calculateMaxLotteryCount();

            LotteryCount manualBoughtCount = new LotteryCount(
                inputView.getManualIssueLotteryCount(lotteryCount.getValue()));
            LotteryCount randomBoughtCount = LotteryCount.sub(lotteryCount, manualBoughtCount);

            LotteryTicket manualBoughtLotteries = LotteryMachine.issueManualLotteryTicket(
                inputView.getManualIssueLotteriesNumbers(manualBoughtCount.getValue()));
            LotteryTicket autoBoughtLotteries = LotteryMachine.issueRandomLotteryTicket(
                randomBoughtCount);

            outputView.printLotteryTickets(manualBoughtLotteries, autoBoughtLotteries);

            LotteryTicket total = LotteryTicket.union(manualBoughtLotteries, autoBoughtLotteries);

            LotteryResult lotteryResult = new LotteryResult(
                LotteryNumbers.from(inputView.getLotteryResultNumbers()),
                LotteryNumber.from(inputView.getLotteryResultBonusNumber()));

            Statistics statistics = Statistics.of(lotteryBoughtPrice, total, lotteryResult);
            outputView.printStatistics(statistics);
        } catch (RuntimeException exception) {
            exceptionHandler.handle(exception);
        }
    }
}
