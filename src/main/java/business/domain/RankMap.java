package business.domain;

import java.util.Collections;
import java.util.EnumMap;
import java.util.Map;

public class RankMap {

    private final Map<Rank, Integer> rankMap;

    private RankMap(Map<Rank, Integer> rankMap) {
        if (!isRankMapValid(rankMap)) {
            throw new IllegalArgumentException("등수 별 당첨 개수 정보를 생성할 수 없습니다.");
        }
        this.rankMap = Collections.unmodifiableMap(rankMap);
    }

    public static RankMap of(LotteryResult lotteryResult, LotteryTicket lotteryTicket) {
        Map<Rank, Integer> rankMap = new EnumMap<>(Rank.class);
        for (Rank rank : Rank.values()) {
            rankMap.put(rank, lotteryTicket.calculateRankBy(lotteryResult).getCountOf(rank));
        }
        return new RankMap(rankMap);
    }

    public int getCountOf(Rank rank) {
        return this.rankMap.get(rank);
    }

    private boolean isRankMapValid(Map<Rank, Integer> rankMap) {
        return rankMap != null;
    }

    public Money getTotalPrize() {
        Money money = new Money(0);
        for (Rank rank : Rank.values()) {
            money = Money.add(money, rank.getPrize().multiply(this.getCountOf(rank)));
        }
        return money;
    }
}
