package lotto.view;

import lotto.domain.Lotto;
import lotto.domain.LottoResult;
import lotto.domain.PurchaseLotto;

import java.util.Arrays;
import java.util.List;

public final class OutputView {
    private static final String PURCHASE_COUNT = "%d개를 구매했습니다.\n";
    private static final String TITLE = "\n당첨 통계\n";
    private static final String DIVIDING_LINE = "---------\n";
    private static final String THREE_MATCHES = "3개 일치 (5000원) - %d개\n";
    private static final String FOUR_MATCHES = "4개 일치 (50000원) - %d개\n";
    private static final String FIVE_MATCHES = "5개 일치 (1500000원) - %d개\n";
    private static final String SIX_MATCHES = "6개 일치 (2000000000원) - %d개\n";
    private static final String TOTAL_RATE_OF_RETURN = "총 수익률은 %d%%입니다.\n";

    private OutputView() { }

    public static void drawPurchaseLotto(PurchaseLotto purchaseLotto) {
        StringBuilder sb = new StringBuilder();

        final List<Lotto> lottos = purchaseLotto.getLottos();
        sb.append(String.format(PURCHASE_COUNT, lottos.size()));

        for (Lotto lotto : lottos) {
            sb.append(drawLottoNumber(lotto)).append("\n");
        }

        System.out.println(sb);
    }

    private static String drawLottoNumber(Lotto lotto) {
        StringBuilder sb = new StringBuilder();

        final List<Integer> lottoNumbers = lotto.getLottoNumbers();
        sb.append(Arrays.toString(lottoNumbers.toArray()));

        return sb.toString();
    }

    public static void drawStatistics(LottoResult lottoResult) {
        StringBuilder sb = new StringBuilder();

        sb.append(TITLE).append(DIVIDING_LINE)
                .append(String.format(THREE_MATCHES, lottoResult.getMatchCount(0)))
                .append(String.format(FOUR_MATCHES, lottoResult.getMatchCount(1)))
                .append(String.format(FIVE_MATCHES, lottoResult.getMatchCount(2)))
                .append(String.format(SIX_MATCHES, lottoResult.getMatchCount(3)))
                .append(String.format(TOTAL_RATE_OF_RETURN, lottoResult.getTotalRateOfReturn()));

        System.out.println(sb);
    }

}
