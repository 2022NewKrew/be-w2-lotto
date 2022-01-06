package business.domain;

import java.util.Collections;
import java.util.List;

public class Ranks {

    private final List<Rank> ranks;

    public Ranks(List<Rank> ranks) {
        if (!isRanksValid(ranks)) {
            throw new IllegalArgumentException("당첨 등수 리스트를 생성할 수 없습니다.");
        }
        this.ranks = Collections.unmodifiableList(ranks);
    }

    private boolean isRanksValid(List<Rank> ranks) {
        return ranks != null;
    }

    public int getCountOf(Rank rank) {
        return Collections.frequency(this.ranks, rank);
    }
}
