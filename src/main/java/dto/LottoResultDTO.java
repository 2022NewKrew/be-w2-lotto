package dto;

import service.lotto.LottoBundle;
import service.lotto.LottoResult;

import java.util.ArrayList;
import java.util.EnumSet;
import java.util.List;
import java.util.Map;

public class LottoResultDTO {
    private final Map<service.lotto.LottoResult, Integer> numOfWinsMap;
    private final double yield;

    private LottoResultDTO(Map<service.lotto.LottoResult, Integer> numOfWinsMap, double yield) {
        this.numOfWinsMap = numOfWinsMap;
        this.yield = yield;
    }

    public static LottoResultDTO of(LottoBundle lottoBundle) {
        final int prizeMoney = lottoBundle.getPrizeMoney();
        final int purchaseAmount = lottoBundle.getLottoBundle().size() * 1000;

        final double yield = ((prizeMoney - purchaseAmount) / (double) purchaseAmount) * 100;

        return new LottoResultDTO(lottoBundle.getLottoResults(), yield);
    }

    public double getYield() {
        return yield;
    }

    public List<String> buildMessages() {
        final EnumSet<LottoResult> lottoResultEnumSet = LottoResult.getEnumSetRankedPlace();

        List<String> messages = new ArrayList<>();

        lottoResultEnumSet.forEach(lottoResult -> addLottoResultString(messages, lottoResult));
        return messages;
    }

    private void addLottoResultString(List<String> messages, LottoResult lottoResult) {
        final int count = getNumOfWins(lottoResult);

        String sb = lottoResult.toString() +
                " - " +
                count +
                "개\n";
        messages.add(sb);
    }

    @Override
    public String toString() {
        final EnumSet<service.lotto.LottoResult> lottoResultEnumSet = LottoResult.getEnumSetRankedPlace();

        final StringBuilder sb = new StringBuilder("당첨 통계\n---------\n");

        lottoResultEnumSet.forEach(lottoResult -> appendLottoResult(sb, lottoResult));
        sb.append("총 수익률은 ")
                .append(yield)
                .append("%입니다.");

        return sb.toString();
    }

    private void appendLottoResult(StringBuilder sb, LottoResult lottoResult) {
        final int count = getNumOfWins(lottoResult);

        sb.append(lottoResult)
                .append(" - ")
                .append(count)
                .append("개\n");
    }

    private int getNumOfWins(service.lotto.LottoResult lottoResult) {
        final Integer count = numOfWinsMap.get(lottoResult);
        return count == null ? 0 : count;
    }
}
