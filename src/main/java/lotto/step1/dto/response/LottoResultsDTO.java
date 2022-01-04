package lotto.step1.dto.response;

import lotto.step1.model.Lotto;
import lotto.step1.model.LottoResult;

import java.sql.ResultSet;
import java.util.EnumSet;
import java.util.Map;

public class LottoResultsDTO {
    private final Map<LottoResult, Integer> numOfWinsMap;
    protected final double yield;

    protected LottoResultsDTO(Map<LottoResult, Integer> numOfWinsMap, double yield) {
        this.numOfWinsMap = numOfWinsMap;
        this.yield = yield;
    }

    public static LottoResultsDTO of(Lotto lotto) {
        final double yield = calcYield(lotto);

        return new LottoResultsDTO(lotto.getLottoResults(), yield);
    }

    protected static double calcYield(Lotto lotto) {
        final int prizeMoney = lotto.getPrizeMoney();
        final int purchaseAmount = lotto.getPurchasedLottoNumbersList().size() * 1000;

        return (prizeMoney / (double) purchaseAmount) * 100 - 100;
    }

    @Override
    public String toString() {
        final EnumSet<LottoResult> lottoResultSet = getLottoResults();

        final StringBuilder sb = new StringBuilder("당첨 통계\n---------\n");

        lottoResultSet.forEach(lottoResult -> appendLottoResult(sb, lottoResult));
        sb.append("총 수익률은 ")
                .append(yield)
                .append("%입니다.");

        return sb.toString();
    }

    protected void appendLottoResult(StringBuilder sb, LottoResult lottoResult) {
        final int count = getNumOfWins(lottoResult);

        sb.append(lottoResult)
                .append(" - ")
                .append(count)
                .append("개")
                .append('\n');
    }

    private int getNumOfWins(LottoResult lottoResult) {
        final Integer count = numOfWinsMap.get(lottoResult);
        return count == null ? 0 : count;
    }

    public EnumSet<LottoResult> getLottoResults() {
        return LottoResult.getEnumSetFirstToFourthPlace();
    }
}
