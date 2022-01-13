package lotto.dto;

import lotto.collections.RankMap;

import java.util.Objects;

public class LottoResults {
    RankMap rankMap;
    long earnRate;

    public LottoResults(RankMap rankMap, long earnRate) {
        this.rankMap = rankMap;
        this.earnRate = earnRate;
    }

    public RankMap getRankMap() {
        return this.rankMap;
    }

    public long getEarnRate() {
        return this.earnRate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof LottoResults)) return false;
        LottoResults that = (LottoResults) o;
        return getEarnRate() == that.getEarnRate() && getRankMap().equals(that.getRankMap());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getRankMap(), getEarnRate());
    }

    @Override
    public String toString() {
        return "LottoResults{" +
                "rankMap=" + rankMap +
                ", earnRate=" + earnRate +
                '}';
    }
}
