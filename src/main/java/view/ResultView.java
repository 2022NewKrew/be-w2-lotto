package view;

import domain.Lotto;
import enums.Prize;
import java.util.ArrayList;
import java.util.Collections;
import java.util.EnumMap;
import java.util.List;
import java.util.Set;
import messages.GameMessage;

public class ResultView {

    private static void printLotto(Lotto lotto) {
        Set<Integer> numbers = lotto.numbers();
        List<Integer> numbersToList = new ArrayList<>(numbers);

        Collections.sort(numbersToList);
        System.out.print("[");
        for (int i = 0; i < numbersToList.size(); i++) {
            System.out.print(numbersToList.get(i));
            if (i != numbersToList.size() - 1) {
                System.out.print(", ");
            }
        }
        System.out.println("]");
    }

    public static void printLottoList(List<Lotto> lottoList) {
        for (Lotto lotto : lottoList) {
            printLotto(lotto);
        }
    }

    private static void printOneResult(Prize key, int value) {
        if (key.getMatchCount() == 0) {
            return;
        }
        System.out.printf("%d개 일치 (%d원)- %d개\n", key.getMatchCount(), key.getMoney(), value);
    }

    public static void printLottoResult(EnumMap<Prize, Integer> lottoResult) {
        System.out.println(GameMessage.WINNING_STATISTICS.getMessage());
        lottoResult.forEach(ResultView::printOneResult);
    }

    public static void printRateOfReturn(double rateOfReturn) {
        System.out.printf("총 수익률은 %.2f 입니다.", rateOfReturn);
    }
}
