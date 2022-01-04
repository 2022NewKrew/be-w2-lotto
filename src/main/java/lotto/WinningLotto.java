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

    private int countMatch(Lotto lotto) {
        int count = 0;
        for (LottoBall number: lotto.lottoNumbers) {
            if(lottoNumbers.contains(number)) {
                count++;
            }
        }
        return count;
    }

    public int checkMatchResult(Lotto lotto) {
        int count = countMatch(lotto);
        boolean bonusMatch = lotto.getLottoNumbers().contains(bonusBall);
        switch(count) {
            case 6: return 1;
            case 5: if(bonusMatch) {
                        return 2;
                    }
                    return 3;
            case 4: return 4;
            case 3: return 5;
            default: return 0;
        }
    }
}
