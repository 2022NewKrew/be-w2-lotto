package lotto.view;

import lotto.domain.Customer;
import lotto.domain.Rank;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

public class PrintInformation {

    private static final String STATISTICS_FORMAT_1 = "개 일치";
    private static final String STATISTICS_FORMAT_2 = "원)- ";
    private static final String STATISTICS_FORMAT_3 = "개";
    private static final String STATISTICS_FORMAT_4 = "[";
    private static final String STATISTICS_FORMAT_5 = "]";
    private static final String STATISTICS_FORMAT_6 = ", 보너스 볼 일치 (";
    private static final String STATISTICS_FORMAT = "당첨 통계\n---------";
    private static final String PREFIX_TICKET_PURCHASE_MESSAGE = "수동으로 ";
    private static final String MIDDLE_TICKET_PURCHASE_MESSAGE = "장, 자동으로 ";
    private static final String SUFFIX_TICKET_PURCHASE_MESSAGE = "개를 구매했습니다.";
    private static final String PREFIX_EARNING_RATE_MESSAGE = "총 수익률은 ";
    private static final String SUFFIX_EARNING_RATE_MESSAGE = "%입니다.";

    public static void printRankStatistics(Map<Rank, Integer> ranks) {
        System.out.println(STATISTICS_FORMAT);
        List<String> statisticsView = new ArrayList<>();
        ranks.forEach((rank, count) -> {
            String bonus = " (";
            if(rank == Rank.SECOND)
                bonus = STATISTICS_FORMAT_6;
            statisticsView.add(rank.getCountOfMatch() + STATISTICS_FORMAT_1 + bonus + rank.getReward() + STATISTICS_FORMAT_2 + count + STATISTICS_FORMAT_3);
        });
        Collections.sort(statisticsView);
        statisticsView.forEach(System.out::println);
    }

    public static void printAllTickets(Customer customer, int directCount) {
        int autoCount = customer.getTickets().size() - directCount;
        System.out.println(PREFIX_TICKET_PURCHASE_MESSAGE + directCount + MIDDLE_TICKET_PURCHASE_MESSAGE + autoCount + SUFFIX_TICKET_PURCHASE_MESSAGE);
        customer.getTickets().forEach(ticket -> {
            System.out.print(STATISTICS_FORMAT_4);
            ticket.getTicketNumbers().getTicketNumbers().forEach(ticketNumber -> {
                System.out.print(ticketNumber.getNumber() + " ");
            });
            System.out.println(STATISTICS_FORMAT_5);
        });
    }

    public static void printEarningRewardRate(int calculateEarningRewardRate) {
        System.out.println(PREFIX_EARNING_RATE_MESSAGE + calculateEarningRewardRate + SUFFIX_EARNING_RATE_MESSAGE);
    }
}
