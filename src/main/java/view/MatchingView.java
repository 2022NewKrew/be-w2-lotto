package view;

import domain.Prize;

import java.util.EnumMap;

import static domain.Prize.SECOND_PRIZE;

public class MatchingView {

    public void PrintMatchResult(EnumMap<Prize, Long> matchingMap, int payPrice)
    {
        System.out.println("당첨 통계");
        System.out.println("----------");
        matchingMap.forEach((k,v)->
                System.out.println(k==SECOND_PRIZE ?
                        String.format("%d개 일치, 보너스 볼 일치(%d원) - %d개", k.getMatchingNumber(), k.getPrizeMoney(), v):
                        String.format("%d개 일치 (%d원)- %d개", k.getMatchingNumber(), k.getPrizeMoney(), v)
                ));
        long sum = matchingMap.entrySet().stream().map(e -> e.getKey().getPrizeMoney() * e.getValue()).mapToLong(Long::longValue).sum();
        System.out.println("총 수익률은 " + (sum - payPrice)/(double)payPrice*100 + "%입니다.");
    }
}
