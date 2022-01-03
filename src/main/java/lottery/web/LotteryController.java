package lottery.web;

import lottery.service.lotteries.LotteryService;
import lottery.web.dto.BudgetDto;
import lottery.web.dto.LotteryListDto;

public class LotteryController {

    private final LotteryService lotteryService = new LotteryService();

    public LotteryListDto buy(BudgetDto budgetDto) {

        return lotteryService.buy(budgetDto);

    }

}
