package output;

import lotto.LottoConfig;
import lotto.domain.LottoResult;

import java.util.*;
import java.util.stream.IntStream;

public class CommandLineOutputView implements OutputView {

    @Override
    public void printResult(Map<Integer, Integer> results, long profitRate) {
        System.out.printf("당첨 통계\n=========\n");
        IntStream.rangeClosed(LottoConfig.MIN_PRIZE_KEY, LottoConfig.MAX_PRIZE_KEY)
                .forEach(i -> System.out.println(LottoResult.getResult(i).getMessage() + results.get(i) + "개"));
        System.out.println("총 수익률은 " + profitRate + "%입니다.");
    }
}