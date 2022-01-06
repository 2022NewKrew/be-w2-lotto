package view;

import domain.Lotto;
import domain.Matching;
import domain.Player;
import domain.Prize;

import java.util.List;
import java.util.stream.Collectors;

import static domain.Prize.SECOND_PRIZE;

public class OutputView {

    public static void printLottoList(Player player) {
        List<Lotto> lottoList = player.getLottoList();
        for (Lotto lotto : lottoList) {
            printLottoNumber(lotto.getNumberList());
        }
    }
    private static void printLottoNumber(List<Integer> lottoNumber) {
        System.out.print("[");
        System.out.print(lottoNumber.stream().map(Object::toString).collect(Collectors.joining(",")));
        System.out.println("]");
    }
    public static void printLottoSize(int payAutoCount, int payManualCount)
    {
        System.out.printf("수동으로 %d장, 자동으로 %d개를 구매했습니다.\n",payManualCount,payAutoCount);
    }
    public static void printMatchResult(Matching matching, int payPrice)
    {
        System.out.println("당첨 통계");
        System.out.println("----------");
        for(Prize prize : Prize.values())
        {
            Integer prizeCount = matching.getPrizeCount(prize);
            printMatchNumberResult(prizeCount, prize);
        }
        long sum = matching.getTotalPrizeSum();
        System.out.println("총 수익률은 " + (sum - payPrice)/(double)payPrice*100 + "%입니다.");
    }

    private static void printMatchNumberResult(Integer prizeCount, Prize prize) {
        if(prize == Prize.NO_PRIZE)
            return;
        System.out.println(prize==SECOND_PRIZE ?
                String.format("%d개 일치, 보너스 볼 일치(%d원) - %d개", prize.getMatchingNumber(), prize.getPrizeMoney(), prizeCount):
                String.format("%d개 일치 (%d원)- %d개", prize.getMatchingNumber(), prize.getPrizeMoney(), prizeCount)
        );
    }
}
