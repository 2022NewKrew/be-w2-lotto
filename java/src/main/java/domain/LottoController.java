package domain;

import view.LottoView;

import java.util.*;

/*
 ** Lotto, LottoView, TicketReader 클래스의 메서드를 호출하는 클래스
 */
public class LottoController {

    private int money;
    private int totalPrize;
    private List<LottoTicket> tickets;
    private Map<Rank, Integer> rankCount;
    private Lotto lotto;
    private LottoView view;
    private TicketReader reader;

    public LottoController() {
        lotto = new Lotto();
        view = new LottoView();
        reader = new TicketReader();
    }

    public void run() {
        buyLotto();
        classifyTicketRank();
        showResult();
    }

    private void buyLotto() {
        inputMoney();
        tickets = lotto.generateAllLottoTicket(money);
        view.printPurchaseMessage(tickets.size());
        view.printAllTickets(tickets);
    }

    private void inputMoney() {
        try {
            money = view.inputInt("구입금액을 입력해 주세요.");
            checkMoney(money);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            inputMoney();
        }
    }

    private void classifyTicketRank() {
        rankCount = reader.classifyTicketRank(lotto, view, tickets);
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

    private void checkMoney(int money) throws IllegalArgumentException {
        if (money < lotto.getTicketPrice()) {
            throw new IllegalArgumentException(String.format("금액은 %d원 이상이어야 합니다.", lotto.getTicketPrice()));
        }

        if (money % lotto.getTicketPrice() != 0) {
            throw new IllegalArgumentException(String.format("금액은 %d원 단위로 입력해야합니다.", lotto.getTicketPrice()));
        }
    }
}
