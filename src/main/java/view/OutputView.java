package view;

import domain.Lotto;
import domain.LottoRankMatch;
import domain.LottoRepository;

public class OutputView {
    private static final String STATISTICS = "당첨 통계";
    private static final String DASH = "-----------";

    public static void printAutoLottos(LottoRepository autuLottos) {
        for (Lotto autoLotto : autuLottos.getLottos()) {
            System.out.println(autoLotto.getLotto());
        }
    }

    public static void printProfit(LottoRankMatch lottoRankMatch, double profitRate) {
        System.out.println();
        System.out.println(STATISTICS);
        System.out.println(DASH);
    }
}
