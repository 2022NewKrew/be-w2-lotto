package view;

import domain.lotto.Lotto;
import domain.lotto.LottoResult;

import java.util.List;

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

    public static void renderResult(LottoResult lottoResult) {
        System.out.println("당첨 통계");
        System.out.println("----------");
        System.out.println("3개 일치 (5000원)- " + lottoResult.getFourthPrizeCount() + "개");
        System.out.println("4개 일치 (50000원)- " + lottoResult.getThirdPrizeCount() + "개");
        System.out.println("5개 일치 (1500000원)- " + lottoResult.getSecondPrizeCount() + "개");
        System.out.println("6개 일치 (2000000000원)- " + lottoResult.getFirstPrizeCount() + "개");
    }

    public static void renderEarningRatio(LottoResult lottoResult) {
        System.out.println("총 수익률은 " + lottoResult.getEarningRatio() + "%입니다.");
    }
}
