package lottogame.view;

import lottogame.domain.lottery.LotteryTickets;
import lottogame.domain.statistics.Results;
import lottogame.domain.statistics.Statistics;

public class OutputView {
    private OutputView() {
    }

    public static void print() {
        System.out.println();
    }

    public static void print(String message) {
        System.out.println(message);
    }

    public static void print(Object object) {
        System.out.println(object.toString());
    }

    public static void print(LotteryTickets tickets) {
        String numberOfTicket = String.format("%d개를 구매했습니다.", tickets.getCount());
        print(numberOfTicket);
        for (var ticket : tickets.getTickets()) {
            print(ticket);
        }
        print();
    }

    public static void print(Statistics statistics) {
        print("");
        print("당첨 통계");
        print("---------");
        print(statistics.getResults());
        print(statistics.getRateOfReturn());
    }

    public static void print(Results results) {
        for (var result : results.getResults()) {
            print(result);
        }
    }
}
