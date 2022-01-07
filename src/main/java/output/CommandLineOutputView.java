package output;

import input.dto.InputInfo;
import lotto.LottoInfo;
import lotto.domain.LottoTicket;

import java.util.*;
import java.util.stream.Collectors;

//상금 클래스 enum 으로 추가
public class CommandLineOutputView implements OutputView {

    @Override
    public void show(InputInfo inputInfo, List<LottoTicket> lottoTickets) {
        Map<Integer, Integer> results = ResultChecker.getResults(lottoTickets, inputInfo.getTarget());

        int purchaseFee = inputInfo.getAmountOfTicket() * 1000;
        Integer profitRate = ResultChecker.calculateProfitRate(purchaseFee, results);
        printResult(results, profitRate);
    }

    private static void printResult(Map<Integer, Integer> results, Integer profitRate) {
        System.out.printf("당첨 통계\n=========\n");
        for (int i = 3; i <= 6; i++) {
            System.out.printf("%d 개 일치 (%d원) - %d개\n",
                    i, LottoInfo.LOTTO_PRIZE.get(i), results.getOrDefault(i, 0));
        }
        System.out.println("총 수익률은 " + profitRate + "%입니다.");
    }


}
