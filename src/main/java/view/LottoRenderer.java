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

        System.out.println("당첨 통계");
        System.out.println("----------");
        for (Prize prize : Prize.getTypeList()) {
            Long prizeCount = totalResultMap.getOrDefault(prize, 0L);
            System.out.print(getResultString(prize, prizeCount));
        }
    }

    private static String getResultString(Prize prize, long prizeCount) {
        if (prize.isMatchedBonus()) {
            return String.format("%s개 일치, 보너스 볼 일치(%s원)- %s개\n", prize.getMatchedNum(), prize.getPrizeMoney(), prizeCount);
        }
        return String.format("%s개 일치 (%s원)- %s개\n", prize.getMatchedNum(), prize.getPrizeMoney(), prizeCount);
    }

    public static void renderEarningRatio(LottoTotalResult lottoTotalResult) {
        System.out.printf("총 수익률은 %.2f%%입니다.%n", lottoTotalResult.getEarningRatio());
    }

}
