package lottery.web;

import lottery.service.lotteries.LotteryService;
import lottery.web.dto.*;

import java.util.List;

public class LotteryController {

    private final LotteryService lotteryService = new LotteryService();

    public List<LotteryDto> buy(BudgetDto budgetDto) {

        return lotteryService.buy(budgetDto);

    }

    public List<LotteryDto> buy(BudgetAndManualLotteryDto budgetDto) {

        return lotteryService.buy(budgetDto);

    }

    public LotteryResultDto match(LotteryWinningNumberDto winningNumberDto) {

        return lotteryService.match(winningNumberDto);

    }

    public LotteryResultDto match(LotteryWinningNumberWithBonusDto winningNumberDto) {

        return lotteryService.match(winningNumberDto);

    }

}
