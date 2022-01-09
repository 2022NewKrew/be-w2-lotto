package lotto.domain;

import lotto.constant.Rank;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class RankCollection {
    private final List<Rank> rankCollection;

    public RankCollection(List<Rank> rankCollection) {
        this.rankCollection = rankCollection;
    }

    public static RankCollection of(LottoCollection lottoCollection, WinningLotto winningLotto) {
        List<Rank> rankCollection = new ArrayList<>();
        for (Lotto lotto : lottoCollection.getLottoCollection()) {
            Rank rank = winningLotto.getWinningLottoRank(lotto);
            if(!rainCheck(rank)) {
                rankCollection.add(rank);
            }
        }
        return new RankCollection(rankCollection);
    }

    private static boolean rainCheck(Rank rank) {
        return rank == Rank.RAIN_CHECK;
    }

    public List<Rank> getRankCollection() {
        return Collections.unmodifiableList(rankCollection);
    }
}
