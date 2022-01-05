package domain;

import util.InputChecker;
import view.LottoView;

import java.util.*;

/*
 ** Lotto, LottoView, TicketReader 클래스의 메서드를 호출하는 클래스
 */
public class LottoController {

    private int money;
    private int manualTicketCount;
    private int totalPrize;
    private List<LottoTicket> tickets;
    private Map<Rank, Integer> rankCount;
    private Lotto lotto;
    private LottoView view;
    private TicketReader reader;
    private InputChecker checker;

    public LottoController() {
        lotto = new Lotto();
        view = new LottoView();
        reader = new TicketReader();
        checker = new InputChecker();
    }

    public void run() {
        buyLotto();
        classifyTicketRank();
        showResult();
    }

    private void buyLotto() {
        inputMoney();
        inputManualTicketCount();
        tickets = lotto.generateAllLottoTicket(view, checker, money, manualTicketCount);
        view.printPurchaseMessage(manualTicketCount, tickets.size() - manualTicketCount);
        view.printAllTickets(tickets);
    }

    private void inputMoney() {
        money = view.inputInt("구입금액을 입력해 주세요.");
        checker.checkMoney(lotto, money);
    }

    private void inputManualTicketCount() {
        manualTicketCount = view.inputInt("수동으로 구매할 로또 수를 입력해 주세요.");
        checker.checkManualTicketCount(lotto, money, manualTicketCount);
    }

    private void classifyTicketRank() {
        rankCount = reader.classifyTicketRank(lotto, view, checker, tickets);
    }

    private void showResult() {
        totalPrize = calculateTotalPrize();
        view.printAllTicketsResult(rankCount);
        view.printEarnRatio(money, totalPrize);
    }

    private int calculateTotalPrize() {
        int prize, ticketCount, totalPrize = 0;
        for (var entry : rankCount.entrySet()) {
            prize = entry.getKey().getWinningMoney();
            ticketCount = entry.getValue();
            totalPrize += prize * ticketCount;
        }

        return totalPrize;
    }
}
