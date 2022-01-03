package lotto.view;

import lotto.domain.Rank;
import lotto.domain.Lotto;

import java.util.List;

public class OutputView {

    private static final String NEWLINE = "\n";

    private OutputView() {}

    public static void printLottos(List<Lotto> lottoList) {
        System.out.println(lottoList.size() + "개를 구매했습니다.");
        StringBuilder sb = new StringBuilder();
        for (Lotto lotto : lottoList) {
            sb.append(lotto.numberListToString());
            sb.append(NEWLINE);
        }
        System.out.println(sb);
    }

    public static void printLottoResults(int purchaseAmount, int prizeAmount) {
        System.out.println("당첨 통계");
        System.out.println("---------");
        for (int i = 0; i < 4; i++) {
            Rank rank = Rank.values()[i];
            System.out.printf("%s개 일치 (%s원)- %s개%n",
                    rank.getMatchingNumber(),
                    rank.getPrizeAmount(),
                    rank.getWinnerCount());
        }
        System.out.printf("총 수익률은 %s%%입니다.", prizeAmount / purchaseAmount * 100);
    }
}
