package lotto.domain;

import lotto.input.InputInformation;
import lotto.view.PrintInformation;

import java.util.Map;

public class LottoController {

    private final Money money;
    private final Customer customer;

    public LottoController() {
        money = new Money(InputInformation.inputMoney());
        customer = new Customer(money);
    }

    public void lottoGameStart() {
        buyTickets();
        WinTicket winTicket = initiateLastWeekWinTickets();
        run(winTicket);
    }

    private void buyTickets() {
        int count = InputInformation.inputDirectTicketsCount();
        customer.buyTickets(new DirectTicketsGenerator(InputInformation.inputAllTicketsNumbers(count)), count);
        customer.buyAllTickets(new RandomTicketsGenerator());
        PrintInformation.printAllTickets(customer, count);
    }

    private WinTicket initiateLastWeekWinTickets() {
        return new WinTicket(InputInformation.inputWinNumbers(), InputInformation.inputBonusNumber());
    }

    private void run(WinTicket winTicket) {
        Map<Rank, Integer> results = customer.calculateRankResult(winTicket);
        PrintInformation.printRankStatistics(results);
        PrintInformation.printEarningRewardRate(Money.calculateEarningRewardRate(money, results));
    }
}
