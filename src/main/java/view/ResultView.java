package view;

import domain.Lotto;
import domain.Prize;
import messages.GameMessage;

import java.util.EnumMap;
import java.util.List;

public class ResultView {

    public static void printLottoList(List<Lotto> lottoList) {
        // TODO - 예쁘게 List로 출력하도록 변경
        // TODO - toString으로 하면 된다 - 오버라이드
        lottoList.forEach(System.out::println);
    }

    public static void printLottoResult(EnumMap<Prize, Integer> lottoResult) {
        System.out.println(GameMessage.WINNING_STATISTICS.getMessage());
        // TODO - 금액 포함 출력
        lottoResult.forEach((key, value) -> System.out.printf("%d개 일치 (%d원)- %d개", key.getMatchCount(), key.getMoney(), value));
    }

    public static void printRateOfReturn(double rateOfReturn) {
        System.out.printf("총 수익률은 %.2f 입니다.", rateOfReturn);
    }
}
