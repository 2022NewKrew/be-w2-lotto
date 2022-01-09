package lotto.domain;

import lotto.input.InputInformation;
import lotto.view.PrintInformation;

import java.util.ArrayList;
import java.util.List;

public class LottoController {

    public LottoController() {
    }

    public void lottoGameStart(int price) {
        Amount totalAmount = initiateTotalAmount(price);
        Tickets tickets = initiateTickets(totalAmount);
        WinTicket winTicket = initiateLastWeekWinTickets();
        int reward = run(tickets, winTicket);
        calculateEarningRate(totalAmount, price, reward);
    }

    private Amount initiateTotalAmount(int price) {
        Money money = new Money(InputInformation.inputMoney());
        return money.calculateTotalAmount(price);
    }

    private Tickets initiateTickets(Amount totalAmount) {
        int count = InputInformation.inputDirectTicketsCount();
        Amount manualAmount = new Amount(count);
        Amount autoAmount = totalAmount.subtractAmount(manualAmount);

        InputInformation.inputTicketNumbersMessage();
        List<Ticket> inputTickets = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            inputTickets.add(new Ticket(InputInformation.inputTicketNumbers()));
        }
        inputTickets.addAll(autoAmount.changeToTickets(new RandomTicketsGenerator()));

        PrintInformation.printAllTickets(manualAmount, autoAmount, inputTickets);
        return new Tickets(inputTickets);
    }

    private WinTicket initiateLastWeekWinTickets() {
        return new WinTicket(InputInformation.inputWinNumbers(), InputInformation.inputBonusNumber());
    }

    private int run(Tickets tickets, WinTicket winTicket) {
        Results results = new Results(tickets.winRankStatistics(winTicket));
        PrintInformation.printRankStatistics(results.getRankToCount());
        return results.calculateReward();
    }

    private void calculateEarningRate(Amount totalAmount, int price, int reward) {
        int spent = totalAmount.getAmount() * price;
        System.out.println("reward : " + reward);
        System.out.println("spent : " + spent);
        int earningRate = (reward - spent) * 100 / spent;
        PrintInformation.printEarningRewardRate(earningRate);
    }
}
