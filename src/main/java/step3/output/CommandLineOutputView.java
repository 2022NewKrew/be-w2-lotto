package step3.output;

import step3.lotto.LottoConfig;
import step3.lotto.domain.LottoResult;
import step3.lotto.domain.LottoTicket;

import java.util.*;
import java.util.stream.IntStream;

public class CommandLineOutputView implements OutputView {

    @Override
    public void printTickets(List<LottoTicket> lottoTickets) {
        lottoTickets.stream().forEach(System.out::println);
    }


    @Override
    public void printResult(Map<Integer, Integer> results, double profitRate) {
        System.out.printf("당첨 통계\n=========\n");
        IntStream.rangeClosed(LottoConfig.MIN_PRIZE_KEY, LottoConfig.MAX_PRIZE_KEY)
                .forEach(i -> System.out.println(LottoResult.getResult(i).getMessage() + results.getOrDefault(i, 0) + "개"));
        System.out.println("총 수익률은 " + profitRate + "%입니다.");
    }
}