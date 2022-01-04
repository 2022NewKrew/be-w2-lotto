package view;

import domain.Lotto;
import messages.GameMessage;

import java.util.List;
import java.util.Map;

public class ResultView {

    public static void printLottoList(List<Lotto> lottoList) {
        // TODO - 예쁘게 List로 출력하도록 변경
        lottoList.forEach(System.out::println);
    }

    public static void printLottoResult(Map<Integer, Integer> lottoResult) {
        System.out.println(GameMessage.WINNING_STATISTICS.getMessage());
        // TODO - 금액 포함 출력
        lottoResult.forEach((key, value) -> System.out.println(key + "개 일치 - " + value + "개"));
    }

    public static void printRateOfReturn(double rateOfReturn) {
        System.out.printf("총 수익률은 %.2f 입니다.", rateOfReturn);
    }
}
