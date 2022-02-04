package dto;

import constant.Rank;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;

public class LottoResultDto {
    private final Map<Rank, Integer> result = new LinkedHashMap<>();
    private long winRate;

    public LottoResultDto() {
        Arrays.stream(Rank.values())
                .forEach(rank -> result.put(rank, 0));
    }

    public void increase(Rank rank) {
        Integer value = result.get(rank);
        result.replace(rank, value + 1);
    }

    public void setWinRate(long winRate) {
        this.winRate = winRate;
    }

    public String toString() {
        StringBuilder result = new StringBuilder();
        result.append("\n당첨 통계\n---------\n");

        for (Rank rank : this.result.keySet()) {
            result.append(rank.getMatch());
            result.append(rank != Rank.SECOND ? "개 일치 (" : "개 일치, 보너스 볼 일치(");
            result.append(rank.getReward());
            result.append("원)- ");
            result.append(this.result.get(rank));
            result.append("개\n");
        }
        result.append("총 수익률은 ");
        result.append(winRate);
        result.append("%입니다.");

        return result.toString();
    }
}
