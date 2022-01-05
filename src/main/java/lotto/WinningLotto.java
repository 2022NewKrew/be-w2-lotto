package lotto;

import java.util.ArrayList;
import java.util.List;

public class WinningLotto extends Lotto {
    private final LottoBall bonusBall;
    public WinningLotto(List<LottoBall> lottoNumbers, LottoBall bonusBall) {
        this.lottoNumbers = new ArrayList<>();
        this.lottoNumbers.addAll(lottoNumbers);
        this.bonusBall = bonusBall;
    }

    private long countMatch(Lotto lotto) {
        return lotto.lottoNumbers.stream().filter(x -> lottoNumbers.contains(x)).count();
    }

    public Rank getRank(Lotto lotto) {
        long count = countMatch(lotto);
        boolean bonusMatch = lotto.getLottoNumbers().contains(bonusBall);
        if(count == Rank.FIRST.getCountOfMatch()) return Rank.FIRST;
        if(count == Rank.SECOND.getCountOfMatch() && bonusMatch) return Rank.SECOND;
        if(count == Rank.THIRD.getCountOfMatch()) return Rank.THIRD;
        if(count == Rank.FOURTH.getCountOfMatch()) return Rank.FOURTH;
        if(count == Rank.FIFTH.getCountOfMatch()) return Rank.FIFTH;
        return Rank.NOTHING;
    }
}
