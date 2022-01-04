package lotto.view;

import lotto.domain.LottoRank;
import lotto.domain.LottoTicket;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class OutputView {

    public void printLotteries(List<LottoTicket> lotteries) {
        System.out.printf("%d개를 구매했습니다.\n", lotteries.size());
        System.out.println(lotteries.stream().map(LottoTicket::toString).collect(Collectors.joining("\n")));
    }

    public void printErrorMessage(Exception e) {
        System.err.println(e.getMessage() + "\n");
    }

    public void printResult(Map<LottoRank, Integer> resultCounts, int earnRate) {
        System.out.println("당첨 통계");
        System.out.println("---------");
        for (LottoRank result : LottoRank.values()) {
            System.out.printf("%s - %d개\n", result.toString(), resultCounts.get(result));
        }
        System.out.printf("총 수익률은 %d%%입니다.", earnRate);
    }
}
