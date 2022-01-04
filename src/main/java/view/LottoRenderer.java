package view;

import domain.lotto.Lotto;
import domain.lotto.LottoTotalResult;
import domain.prize.Prize;

import java.util.List;
import java.util.Map;

public class LottoRenderer {

    private static final String NEW_LINE = "\n";

    public static void renderLotto(List<Lotto> lottoList) {
        StringBuilder sb = new StringBuilder();

        sb.append(lottoList.size());
        sb.append("개를 구매했습니다.");
        sb.append(NEW_LINE);

        for (Lotto lotto : lottoList) {
            sb.append(lotto.toString());
            sb.append(NEW_LINE);
        }
        System.out.println(sb);
    }

    public static void renderResult(LottoTotalResult lottoTotalResult) {
        Map<Prize, Long> totalResultMap = lottoTotalResult.getLottoTotalResultMap();
        totalResultMap.keySet().stream().sorted(Prize::compareTo);

        System.out.println("당첨 통계");
        System.out.println("----------");
        totalResultMap.forEach((k, v) ->
                System.out.printf("%s개 일치 (%s원)- %s개\n", k.getMatchedNum(), k.getPrizeMoney(), v));
    }

    public static void renderEarningRatio(LottoTotalResult lottoTotalResult) {
        System.out.println("총 수익률은 " + lottoTotalResult.getEarningRatio() + "%입니다.");
    }
}
