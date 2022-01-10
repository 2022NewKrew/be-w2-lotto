package lottogame.view;

import lottogame.domain.*;
import lottogame.dto.Statistics;

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

    public static void print(RateOfReturn rateOfReturn) {
        print(String.format("총 수익률은 %d%%입니다.", rateOfReturn.getRateOfReturn()));
    }
}
