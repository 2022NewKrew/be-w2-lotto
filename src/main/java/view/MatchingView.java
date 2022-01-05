package view;

import domain.Matching;
import domain.Prize;

import java.util.EnumMap;
import java.util.List;

import static domain.Prize.SECOND_PRIZE;

public class MatchingView {

    public void PrintMatchResult(Matching matching, int payPrice)
    {
        System.out.println("당첨 통계");
        System.out.println("----------");
        for(Prize prize : Prize.values())
        {
            Long prizeCount = matching.getPrizeCount(prize);
            System.out.println(prize==SECOND_PRIZE ?
                    String.format("%d개 일치, 보너스 볼 일치(%d원) - %d개", prize.getMatchingNumber(), prize.getPrizeMoney(), prizeCount):
                    String.format("%d개 일치 (%d원)- %d개", prize.getMatchingNumber(), prize.getPrizeMoney(), prizeCount)
            );
        }
        long sum = matching.getTotalPrizeSum();
        System.out.println("총 수익률은 " + (sum - payPrice)/(double)payPrice*100 + "%입니다.");
    }
}
