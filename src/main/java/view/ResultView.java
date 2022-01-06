package view;

import domain.Lotto;
import enums.Prize;
import messages.GameMessage;

import java.util.EnumMap;
import java.util.List;

public class ResultView {
    private static void printLotto(Lotto lotto) {
        List<Integer> numbers = lotto.numbers();

        System.out.print("[");
        for (int i = 0; i < numbers.size(); i++) {
            System.out.print(numbers.get(i));
            if (i != numbers.size() - 1)
                System.out.print(", ");
        }
        System.out.println("]");
    }

    public static void printLottoList(List<Lotto> lottoList) {
        for (Lotto lotto: lottoList) {
            printLotto(lotto);
        }
    }

    public static void printLottoResult(EnumMap<Prize, Integer> lottoResult) {
        System.out.println(GameMessage.WINNING_STATISTICS.getMessage());
        lottoResult.forEach((key, value) -> System.out.printf("%d개 일치 (%d원)- %d개\n", key.getMatchCount(), key.getMoney(), value));
    }

    public static void printRateOfReturn(double rateOfReturn) {
        System.out.printf("총 수익률은 %.2f 입니다.", rateOfReturn);
    }
}
