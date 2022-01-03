package lottery.service.lotteries;

import lottery.domain.LotteryRepository;
import lottery.web.dto.BudgetDto;
import lottery.web.dto.LotteryListDto;

import java.util.ArrayList;

public class LotteryService {

    private final LotteryRepository lotteryRepository = new LotteryRepository();

    public LotteryListDto buy(BudgetDto budgetDto) {

        ArrayList<Integer> lotteries = lotteryRepository.buy(budgetDto.getAmount());

        return new LotteryListDto(lotteries);

    }
}
