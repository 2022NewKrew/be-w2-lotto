package step1.domain;

import step1.input.InputLottoInform;
import step1.view.LottoPrinter;
import step1.view.ResultPrinter;

import java.util.ArrayList;
import java.util.List;

public class LottoAdmin {

    private static final List<WinRankInform> winRankInforms = new ArrayList<>();
    private static final int THE_FIRST_REWARD = 2000000000;
    private static final int THE_SECOND_REWARD = 1500000;
    private static final int THE_THIRD_REWARD = 50000;
    private static final int THE_FOURTH_REWARD = 5000;
    private static List<Integer> winTicketNumbers;
    private static Customer customer;

    public static void initLotto() {
        initWinRankInform();
        Money money = InputLottoInform.inputMoney();
        customer = new Customer(money);

        LottoPrinter.printTicketCount(customer.buyTickets());
        LottoPrinter.printAllTickets(customer.getAllTickets());

        winTicketNumbers = InputLottoInform.inputWinTicketNumbers();
    }

    public static void LottoResult() {
        for (WinRankInform winRankInform : winRankInforms) {
            winRankInform.findSatisfiedConditionTicket(customer.getAllTickets(), winTicketNumbers);
        }
        ResultPrinter.printWinStats(winRankInforms);
        ResultPrinter.printEarningRate(calculateEarningRate());
    }

    private static void initWinRankInform() {
        winRankInforms.add(new WinRankInform(THE_FOURTH_REWARD, 3));
        winRankInforms.add(new WinRankInform(THE_THIRD_REWARD, 4));
        winRankInforms.add(new WinRankInform(THE_SECOND_REWARD, 5));
        winRankInforms.add(new WinRankInform(THE_FIRST_REWARD, 6));
    }

    private static int calculateEarningRate() {
        int totalSpent = customer.getSpent();
        int totalReward = calculateTotalReward();
        return totalReward * 100 / totalSpent;
    }

    private static int calculateTotalReward() {
        int total = 0;
        for (WinRankInform winRankInform : winRankInforms)
            total += winRankInform.getTotalReward();
        return total;
    }
}
