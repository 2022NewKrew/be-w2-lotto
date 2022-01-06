package lotto.view;

import java.math.BigDecimal;
import java.util.StringJoiner;
import lotto.domain.Lotto;
import lotto.domain.LottoResult;
import lotto.domain.Lottos;
import lotto.domain.Reward;

public class OutputView {

    private static final String NEW_LINE = System.lineSeparator();

    private OutputView() {
    }

    public static void printLottoCount(int manualPurchase, int autoPurchase) {
        System.out.printf("수동으로 %d장, 자동으로 %d개를 구매했습니다.%s",
            manualPurchase,
            autoPurchase,
            NEW_LINE);
    }

    public static void printLottos(Lottos lottos) {
        for (Lotto lotto : lottos.getLottos()) {
            StringJoiner stringJoiner = new StringJoiner(", ", "[", "]");
            for (Integer number : lotto.getNumbers()) {
                stringJoiner.add(String.valueOf(number));
            }
            System.out.println(stringJoiner);
        }
        System.out.println();
    }

    public static void printLottoResult(LottoResult lottoResult) {
        System.out.println("당첨통계");
        System.out.println("---------");
        Reward[] rewards = Reward.values();

        for (int i = rewards.length - 2; i >= 0; i--) {
            System.out.printf("%d개 일치%s(%d원)- %d개%s",
                rewards[i].getMatchCount(),
                rewards[i].getBonusMatch() ? ", 보너스 볼 일치" : " ",
                rewards[i].getRewardPrize(),
                lottoResult.get(rewards[i]),
                NEW_LINE);
        }
    }

    public static void printProfit(BigDecimal profit) {
        System.out.printf("총 수익률은 %.2f%%입니다.", profit.doubleValue());
        System.out.println();
    }
}
