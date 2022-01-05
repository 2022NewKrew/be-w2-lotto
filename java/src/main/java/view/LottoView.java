package view;

import domain.LottoTicket;
import domain.Rank;
import org.apache.commons.lang3.StringUtils;

import java.util.*;
import java.util.stream.Collectors;

public class LottoView {

    private Scanner sc;

    public LottoView() {
        sc = new Scanner(System.in);
    }

    public int inputInt(String msg) {
        System.out.println(msg);
        return Integer.parseInt(sc.nextLine());
    }

    public List<Integer> inputIntegerList(String msg) {
        if (msg.length() > 0) {
            System.out.println(msg);
        }
        return Arrays.stream(sc.nextLine().split(","))
                .map(StringUtils::deleteWhitespace)
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }

    public void printPurchaseMessage(int manualTicketCount, int autoTicketCount) {
        System.out.printf("수동으로 %d개, 자동으로 %d개를 구매했습니다.\n", manualTicketCount, autoTicketCount);
    }

    public void printAllTickets(List<LottoTicket> tickets) {
        tickets.forEach(ticket -> System.out.println(ticket.listToString()));
    }

    public void printAllTicketsResult(Map<Rank, Integer> rankCount) {
        int matchCount, prize, ticketCount;
        System.out.println("당첨 통계\n---------");
        for (var entry : rankCount.entrySet()) {
            matchCount = entry.getKey().getCountOfMatch();
            prize = entry.getKey().getWinningMoney();
            ticketCount = entry.getValue();

            if (matchCount < 0) continue;
            System.out.printf("%d개 일치 (%d원)- %d개\n", matchCount, prize, ticketCount);
        }
    }

    public void printEarnRatio(int money, int totalPrize) {
        System.out.printf("총 수익률은 %d%%입니다.\n", (totalPrize - money) * 100 / money);
    }
}
