package lotto;

import java.util.ArrayList;
import java.util.Arrays;

public class RankCount {
    private final ArrayList<Integer> rankCounts;

    public RankCount() {
        rankCounts = new ArrayList<>(Arrays.asList(0,0,0,0,0));
    }

    public void increaseRankCounts(Rank rank) {
        if(rank == Rank.FIRST) increaseRankCounts(0);
        if(rank == Rank.SECOND) increaseRankCounts(1);
        if(rank == Rank.THIRD) increaseRankCounts(2);
        if(rank == Rank.FOURTH) increaseRankCounts(3);
        if(rank == Rank.FIFTH) increaseRankCounts(4);
    }

    public int getFirstCount() {
        return rankCounts.get(0);
    }

    public int getSecondCount() {
        return rankCounts.get(1);
    }

    public int getThirdCount() {
        return rankCounts.get(2);
    }

    public int getFourthCount() {
        return rankCounts.get(3);
    }

    public int getFifthCount() {
        return rankCounts.get(4);
    }

    private void increaseRankCounts(int i) {
        rankCounts.set(i, rankCounts.get(i) + 1);
    }
}
