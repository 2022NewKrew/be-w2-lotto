package view;

import domain.Lotto;
import domain.LottoRank;
import domain.LottoRankMatch;
import domain.LottoRepository;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

public class OutputView {
    private static final String NUMBERS_OF_BOUGHT = "수동으로 %d장, 자동으로 %d개를 구매했습니다.";
    private static final String STATISTICS = "당첨 통계";
    private static final String DASH = "-----------";
    private static final String NUM_OF_MATCHED = "%d개 일치%s(%d원)- %d개";
    private static final String SECOND_PRICE_ADDITION_STRING = ", 보너스 볼 일치";
    private static final String TOTAL_PROFIT_RATE = "총 수익률은 %.2f%s 입니다.";

    public static void printAllLottos(LottoRepository allLottos, Integer manualQuantity) {
        System.out.println(String.format("\n" + NUMBERS_OF_BOUGHT, manualQuantity, allLottos.getLottos().size() - manualQuantity));
        for (Lotto autoLotto : allLottos.getLottos()) {
            List<Integer> lottoNumbers = new ArrayList<>(List.copyOf(autoLotto.getLotto()));
            Collections.sort(lottoNumbers);
            System.out.println(lottoNumbers);
        }
    }

    public static void printProfit(LottoRankMatch lottoRankMatch, double profitRate) {
        System.out.println("\n" + STATISTICS);
        System.out.println(DASH);
        for (Map.Entry<LottoRank, Integer> resultIndex : lottoRankMatch.getLottoResult().entrySet()) {
            String haveBonusBall = (resultIndex.getKey().getMoney() == 30_000_000) ? SECOND_PRICE_ADDITION_STRING : " ";
            System.out.println(String.format(NUM_OF_MATCHED, resultIndex.getKey().getCountOfMatch(), haveBonusBall, resultIndex.getKey().getMoney(), resultIndex.getValue()));
        }
        System.out.println(String.format(TOTAL_PROFIT_RATE, profitRate, "%"));
    }
}