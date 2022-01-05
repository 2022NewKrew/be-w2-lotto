package com.chanminkim.w2.view;

import com.chanminkim.w2.model.Lotto;
import com.chanminkim.w2.model.WinningState;
import com.chanminkim.w2.model.WinningStatistics;
import com.google.common.collect.Range;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class OutputView {
    public void printPurchasedLottoList(List<Lotto> manualLottoList, List<Lotto> randomLottoList) {
        List<Lotto> wholeLottoList = Stream.of(manualLottoList, randomLottoList)
                .flatMap(Collection::stream)
                .collect(Collectors.toList());
        System.out.printf("수동으로 %d장, 자동으로 %d개를 구매했습니다.%n", manualLottoList.size(), randomLottoList.size());
        for (Lotto lotto : wholeLottoList) {
            System.out.println(lotto);
        }
        System.out.println();
    }

    public void printWinningStatistics(WinningStatistics statistics) {
        System.out.println();
        System.out.println("당첨 통계");
        System.out.println("---------");
        printMatchedList(statistics);
        System.out.printf("총 수익률은 %.2f%% 입니다.%n", statistics.calculateEarningPercentage());
    }

    private void printMatchedList(WinningStatistics statistics) {
        for (Map.Entry<WinningState, Integer> entry : statistics.getCountMap().entrySet()) {
            WinningState state = entry.getKey();
            int count = entry.getValue();
            String rangeString = buildRangeString(state.getMatchedCountRange());
            String bonusString = ", 보너스 볼 일치";
            System.out.printf("%s개 일치%s(%d원) - %d개%n",
                    rangeString,
                    state.isCountingBonus() ? bonusString : "",
                    state.getPrizeMoney(),
                    count);
        }
    }

    private String buildRangeString(Range<Integer> range) {
        return Objects.equals(range.lowerEndpoint(), range.upperEndpoint())
                ? range.lowerEndpoint().toString()
                : String.format("%d~%d", range.lowerEndpoint(), range.upperEndpoint());
    }
}
