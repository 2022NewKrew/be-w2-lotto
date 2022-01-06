package lottogame.view;

import lottogame.domain.LotteryTicket;
import lottogame.domain.LotteryTickets;
import lottogame.domain.Rank;
import lottogame.domain.Statistics;

import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

public class OutputView {
    private OutputView() {
    }

    public static void print() {
        System.out.println();
    }

    public static void print(String message) {
        System.out.println(message);
    }

    public static void print(LotteryTickets lotteryTickets) {
        List<LotteryTicket> tickets = lotteryTickets.getLotteryTickets();
        print(String.format("%d개를 구매했습니다.", tickets.size()));
        for (var lotteryTicket : tickets) {
            String printNumbers = lotteryTicket
                    .getLotteryNumbers()
                    .getLotteryNumbers()
                    .stream()
                    .map(object -> String.valueOf(object.getLotteryNumber()))
                    .collect(Collectors.joining(", "));

            print("[" + printNumbers + "]");
        }
        print();
    }

    public static void print(Statistics statistics) {
        HashMap<Rank, Integer> result = statistics.getStatistics();
        for (var rank : Rank.values()) {
            print(String.format("%d개 일치 (%d원)- %d개", rank.getNumberOfMatch(), rank.getPrizeMoney(), result.get(rank)));
        }
    }

    public static void print(int rateOfReturn) {
        print(String.format("총 수익률은 %d%%입니다.", rateOfReturn));
    }
}
