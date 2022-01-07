package ui.view;

import business.domain.LotteryNumber;
import business.domain.LotteryNumbers;
import business.domain.LotteryTicket;
import business.domain.Rank;
import business.domain.Statistics;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Iterator;

public class ConsoleOutputView implements OutputView {

    @Override
    public void printLotteryTickets(LotteryTicket manualBoughtLotteryTicket,
        LotteryTicket randomlyBoughtLotteryTicket) {
        StringBuilder outputString = new StringBuilder(
            String.format("수동으로 %d개, 자동으로 %d개를 구매하였습니다.\n", manualBoughtLotteryTicket.getSize(),
                randomlyBoughtLotteryTicket.getSize()));
        manualBoughtLotteryTicket.forEach(
            (lotteryNumbers) -> outputString.append(formatLotteryNumbers(lotteryNumbers))
                .append("\n"));
        randomlyBoughtLotteryTicket.forEach(
            (lotteryNumbers) -> outputString.append(formatLotteryNumbers(lotteryNumbers))
                .append("\n"));
        System.out.println(outputString);
    }

    @Override
    public void printStatistics(Statistics statistics) {
        StringBuilder outputString = new StringBuilder("당첨 통계\n---------\n");
        Arrays.stream(Rank.values()).filter((rank) -> rank != Rank.MISS)
            .sorted(Comparator.reverseOrder()).forEach((rank) -> outputString.append(
                String.format("%s- %d개\n", rank.getDescription(), statistics.getCountOf(rank))));
        outputString.append(String.format("총 수익률은 %.2f%%입니다.\n", statistics.getRateOfYield()));
        System.out.println(outputString);
    }

    private String formatLotteryNumbers(LotteryNumbers lotteryNumbers) {
        Iterator<LotteryNumber> it = lotteryNumbers.iterator();
        if (!it.hasNext()) {
            return "[]";
        }

        StringBuilder sb = new StringBuilder();
        sb.append('[');
        for (; ; ) {
            LotteryNumber e = it.next();
            sb.append(e.getValue());
            if (!it.hasNext()) {
                return sb.append(']').toString();
            }
            sb.append(',').append(' ');
        }
    }
}
