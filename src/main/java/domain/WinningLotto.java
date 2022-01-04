package domain;

import java.util.List;

public class WinningLotto {
    private final List<Integer> lottoSequence;
    private final int bonusNumber;

    public WinningLotto(List<Integer> lottoSequence, int bonusNumber){
        this.lottoSequence = lottoSequence;
        this.bonusNumber = bonusNumber;
    }

    public List<Integer> getLottoSequence() {
        return lottoSequence;
    }

    public int getBonusNumber() {
        return bonusNumber;
    }
}
