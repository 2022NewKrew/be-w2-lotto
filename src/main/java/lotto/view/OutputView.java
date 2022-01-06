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

    public static void printPurchaseLottoCount(int selfSize, int autoSize) {
        System.out.printf("수동으로 %d장, 자동으로 %d장을 구매했습니다.%s",
            selfSize,
            autoSize,
            NEW_LINE);
    }

    public static void printLottos(Lottos lottos) {
        for (Lotto lotto : lottos.getLottos()) {
            printLotto(lotto);
        }
        System.out.println();
    }

    private static void printLotto(Lotto lotto) {
        StringJoiner stringJoiner = new StringJoiner(", ", "[", "]");
        for (Integer number : lotto.getNumbers()) {
            stringJoiner.add(String.valueOf(number));
        }
        System.out.println(stringJoiner);
    }

    public static void printLottosResult(LottoResult lottoResult) {
        System.out.println("당첨통계");
        System.out.println("---------");

        printLottoResult(lottoResult, Reward.FIFTH);
        printLottoResult(lottoResult, Reward.FOURTH);
        printLottoResult(lottoResult, Reward.THIRD);
        System.out.printf("5개 일치, 보너스 볼 일치(30000000원) - %d개%s", lottoResult.get(Reward.SECOND),
            NEW_LINE);
        printLottoResult(lottoResult, Reward.FIRST);
    }

    private static void printLottoResult(LottoResult lottoResult, Reward reward) {
        System.out.printf("%d개 일치 (%d원)- %d개%s",
            reward.getMatchCount(),
            reward.getRewardPrize(),
            lottoResult.get(reward),
            NEW_LINE);
    }

    public static void printProfit(BigDecimal profit) {
        System.out.printf("총 수익률은 %.2f%%입니다.", profit.doubleValue());
    }
}
