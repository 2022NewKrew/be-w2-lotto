package lotto.step1.dto.response;

import lotto.step1.model.Lotto;
import lotto.step1.model.LottoResult;

import java.util.EnumSet;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class LottoResultsDTO {
    private final Map<LottoResult, Integer> numOfWinsMap;
    protected final double yield;

    protected LottoResultsDTO(Map<LottoResult, Integer> numOfWinsMap, double yield) {
        this.numOfWinsMap = numOfWinsMap;
        this.yield = yield;
    }

    public Map<LottoResult, Integer> getNumOfWinsMap() {
        return numOfWinsMap;
    }

    public double getYield() {
        return yield;
    }

    public static LottoResultsDTO of(Lotto lotto, EnumSet<LottoResult> baseEntity) {
        final double yield = calcYield(lotto);

        final Map<LottoResult, Integer> numOfWinsMap = new TreeMap<>();
        baseEntity.forEach(lottoResult -> numOfWinsMap.put(lottoResult, 0));

        addLottoResultsToNumOfWinsMap(numOfWinsMap, lotto);

        return new LottoResultsDTO(numOfWinsMap, yield);
    }

    protected static void addLottoResultsToNumOfWinsMap(Map<LottoResult, Integer> numOfWinsMap, Lotto lotto) {
        lotto.getLottoResults().entrySet().stream()
                .filter(LottoResultsDTO::isLessThanFourthPlace)
                .forEach(lottoResult -> numOfWinsMap.put(lottoResult.getKey(), lottoResult.getValue()));
    }

    protected static boolean isLessThanFourthPlace(Map.Entry<LottoResult, Integer> lottoResult) {
        return !(lottoResult.getKey().equals(LottoResult.UNWINNABLE) || lottoResult.getKey().equals(LottoResult.UNIDENTIFIED));
    }

    protected static double calcYield(Lotto lotto) {
        final int prizeMoney = lotto.getPrizeMoney();
        final int purchaseAmount = lotto.getPurchasedLottoNumbersList().size() * 1000;

        double yield = (prizeMoney / (double) purchaseAmount) * 100 - 100;
        yield = Math.round(yield * 100) / 100.0;

        return yield;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("당첨 통계\n---------\n");

        numOfWinsMap.forEach((lottoResult, count) -> appendLottoResult(sb, lottoResult, count));
        sb.append("총 수익률은 ")
                .append(yield)
                .append("%입니다.");

        return sb.toString();
    }

    protected void appendLottoResult(StringBuilder sb, LottoResult lottoResult, int count) {
        sb.append(lottoResult)
                .append(" - ")
                .append(count)
                .append("개")
                .append('\n');
    }
}
