package lotto.view;

import lotto.domain.*;

import java.util.Arrays;
import java.util.List;

public final class OutputView {
    private OutputView() { }

    public static void drawPurchaseLotto(PurchaseLotto purchaseLotto) {
        StringBuilder sb = new StringBuilder();

        final List<Lotto> lottos = purchaseLotto.getLottos();
        sb.append(String.format(OutputViewMessage.OUTPUT_PURCHASE_COUNT.getMessage(), lottos.size()));

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

        sb.append(OutputViewMessage.OUTPUT_TITLE.getMessage())
                .append(OutputViewMessage.OUTPUT_DIVIDING_LINE.getMessage())
                .append(getRankResult(Rank.THREE_MATCH, lottoResult.getMatchCount(Rank.THREE_MATCH)))
                .append(getRankResult(Rank.FOUR_MATCH, lottoResult.getMatchCount(Rank.FOUR_MATCH)))
                .append(getRankResult(Rank.FIVE_MATCH, lottoResult.getMatchCount(Rank.FIVE_MATCH)))
                .append(getBonusBallResult(Rank.BONUS_MATCH, lottoResult.getMatchCount(Rank.BONUS_MATCH)))
                .append(getRankResult(Rank.SIX_MATCH, lottoResult.getMatchCount(Rank.SIX_MATCH)))
                .append(getTotalRateOfReturn(lottoResult));

        System.out.println(sb);
    }

    private static String getRankResult(Rank rank, int matchCount) {
        return String.format(
                OutputViewMessage.OUTPUT_MATCHES.getMessage(),
                rank.getMatchCount(),
                rank.getWinningMoney(),
                matchCount
        );
    }

    private static String getBonusBallResult(Rank rank, int matchCount) {
        return String.format(
                OutputViewMessage.OUTPUT_BONUS_BALL_MATCH.getMessage(),
                rank.getWinningMoney(),
                matchCount
        );
    }

    private static String getTotalRateOfReturn(LottoResult lottoResult) {
        return String.format(
                OutputViewMessage.OUTPUT_TOTAL_RATE_OF_RETURN.getMessage(),
                lottoResult.getTotalRateOfReturn()
        );
    }
}
