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

    public static void printLottoResults(double earningRate) {
        System.out.println("당첨 통계");
        System.out.println("---------");
        for (Rank rank : Rank.values()) {
            System.out.println(rank.getResultString());
        }

        System.out.printf("총 수익률은 %s%%입니다.", earningRate);
    }
}
