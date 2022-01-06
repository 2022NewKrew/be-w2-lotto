package lotto.domain;

import lotto.input.InputInformation;
import lotto.view.PrintInformation;

import java.util.Map;

public class LottoController {

    public static void lottoGameStart() {
        initiateGame();
    }

    private static void initiateGame() {
        // 돈 입력
        Integer amount = InputInformation.inputMoney();
        Money spent = new Money(amount);
        Customer customer = new Customer(spent);

        // 티켓 구매
        int count = InputInformation.inputDirectTicketsCount();
        customer.buyTickets(new DirectTicketsGenerator(InputInformation.inputAllTicketsNumbers(count)), count);
        customer.buyAllTickets(new RandomTicketsGenerator());
        PrintInformation.printAllTickets(customer, count);

        // 당첨번호 및 보너스 번호 세팅
        //TicketNumbers winTicketNumbers = new TicketNumbers(InputInformation.inputWinNumbers());
        //TicketNumber bonusNumber = new TicketNumber(InputInformation.inputBonusNumber());
        WinTicket winTicket = new WinTicket(InputInformation.inputWinNumbers(), InputInformation.inputBonusNumber());

        // 계산 실행
        run(customer, winTicket, spent);
    }

    private static void run(Customer customer, WinTicket winTicket, Money spent) {
        Map<Rank, Integer> results = customer.calculateRankResult(winTicket);
        PrintInformation.printRankStatistics(results);
        PrintInformation.printEarningRewardRate(Money.calculateEarningRewardRate(spent, results));
    }
}
