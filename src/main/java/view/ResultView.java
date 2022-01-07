package view;

import domain.Lotto;
import domain.LottoNumber;
import enums.Prize;
import java.util.EnumMap;
import java.util.List;
import java.util.Set;
import messages.GameMessage;

public class ResultView {

    private static void printLotto(Lotto lotto) {
        Set<LottoNumber> numbers = lotto.numbers();
        // TODO - 배열 형식으로 출력
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
