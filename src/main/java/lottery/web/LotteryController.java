package lottery.web;

import lottery.service.lotteries.LotteryService;
import lottery.web.dto.BudgetDto;
import lottery.web.dto.LotteryDto;
import lottery.web.dto.LotteryResultDto;
import lottery.web.dto.LotteryWinningNumberDto;

import java.util.List;

public class LotteryController {

    private final LotteryService lotteryService = new LotteryService();

    public List<LotteryDto> buy(BudgetDto budgetDto) {

        return lotteryService.buy(budgetDto);

    }

    public LotteryResultDto match(LotteryWinningNumberDto winningNumberDto) {

        return lotteryService.match(winningNumberDto);

    }

}
