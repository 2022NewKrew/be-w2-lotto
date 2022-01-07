package domain;

import spark.Request;
import util.InputChecker;
import view.LottoView;
import view.LottoWebView;

import java.util.*;

/**
 * Lotto, LottoView, TicketReader 클래스의 메서드를 호출하는 클래스
 * CLI용 메서드와 Web용 메서드가 별도로 오버로딩되어 구현됨
 */
public class LottoController {

    private int money;
    private int manualTicketCount;
    private final Lotto lotto;
    private final LottoView view;
    private final LottoWebView webView;
    private final TicketReader reader;
    private final InputChecker checker;

    public LottoController() {
        lotto = new Lotto();
        view = new LottoView();
        webView = new LottoWebView();
        reader = new TicketReader();
        checker = new InputChecker();
    }

    //for CLI
    public void run() {
        var tickets = buyLotto();
        var rankCount = classifyTicketRank(tickets);
        showResult(rankCount);
    }

    //for CLI
    private List<LottoTicket> buyLotto() {
        inputMoney();
        inputManualTicketCount();
        var tickets = lotto.generateAllLottoTicket(view, checker, money, manualTicketCount);
        view.printPurchaseMessage(manualTicketCount, tickets.size() - manualTicketCount);
        view.printAllTickets(tickets);

        return tickets;
    }

    //for Web
    public List<LottoTicket> buyLotto(Request request) {
        money = inputMoney(request);
        var manualTicketNumberStringList = inputManualTicketNumberStringList(request, "manualNumber");
        return lotto.generateAllLottoTicket(webView, checker, money, manualTicketNumberStringList);
    }


    //for CLI
    private void inputMoney() {
        money = view.inputInt("구입금액을 입력해 주세요.");
        checker.checkMoney(lotto, money);
    }

    //for Web
    private int inputMoney(Request request) {
        int money = webView.inputInt(request, "inputMoney");
        checker.checkMoney(lotto, money);
        return money;
    }

    //for CLI
    private void inputManualTicketCount() {
        manualTicketCount = view.inputInt("수동으로 구매할 로또 수를 입력해 주세요.");
        checker.checkManualTicketCount(lotto, money, manualTicketCount);
    }

    //for Web
    public List<String> inputManualTicketNumberStringList(Request request, String paramName) {
        var manualTicketNumberStringList = webView.inputMultipleLineIntegerList(request, paramName);
        checker.checkManualTicketCount(lotto, money, manualTicketNumberStringList.size());

        return manualTicketNumberStringList;
    }

    //for CLI
    private Map<Rank, Integer> classifyTicketRank(List<LottoTicket> tickets) {
        return reader.classifyTicketRank(lotto, view, checker, tickets);
    }

    //for Web
    public Map<Rank, Integer> classifyTicketRank(List<LottoTicket> tickets, Request request) {
        return reader.classifyTicketRank(lotto, webView, checker, tickets, request);
    }

    //for CLI
    private void showResult(Map<Rank, Integer> rankCount) {
        int totalPrize = calculateTotalPrize(rankCount);
        view.printAllTicketsResult(rankCount);
        view.printEarnRatio(money, totalPrize);
    }

    //for Web
    public List<String> showAllRank(Map<Rank, Integer> rankCount) {
        return webView.printAllTicketsResult(rankCount);
    }

    public int calculateEarnRatio(Map<Rank, Integer> rankCount) {
        int totalPrize = calculateTotalPrize(rankCount);
        return (totalPrize - money) * 100 / money;
    }

    private int calculateTotalPrize(Map<Rank, Integer> rankCount) {
        int prize, ticketCount, totalPrize = 0;
        for (var entry : rankCount.entrySet()) {
            prize = entry.getKey().getWinningMoney();
            ticketCount = entry.getValue();
            totalPrize += prize * ticketCount;
        }

        return totalPrize;
    }
}
