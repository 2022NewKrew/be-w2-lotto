package view;

import domain.Lotto;
import domain.Player;
import dto.LottosResult;

import java.util.List;
import java.util.stream.Collectors;

public class ConsoleOutputView {

    public static String printLottoPlayer(Player player) {
        List<Lotto> lottoList = player.getLottoList();
        for (Lotto lotto : lottoList) {
            System.out.print("[");
            System.out.print(lotto.getNumberList().stream().map(Object::toString).collect(Collectors.joining(",")));
            System.out.println("]");
        }
        System.out.printf("수동으로 %d장, 자동으로 %d개를 구매했습니다.\n",player.getPayManualCount(),player.getPayAutoCount());
        return null;
    }

    public static String printMatchResult(LottosResult lottosResult) {
        System.out.println("당첨 통계");
        System.out.println("----------");
        for(String message : lottosResult.getMessage())
        {
            System.out.println(message);
        }
        System.out.println("총 수익률은 " + lottosResult.getTotalRateOfReturn() + "%입니다.");
        return null;
    }

}
