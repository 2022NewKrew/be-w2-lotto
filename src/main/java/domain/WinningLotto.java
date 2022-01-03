package domain;

import java.util.List;

public class WinningLotto {
    private final List<Integer> lottoSequence;

    public WinningLotto(List<Integer> lottoSequence){
        this.lottoSequence = lottoSequence;
    }

    public List<Integer> getLottoSequence() {
        return lottoSequence;
    }
}
