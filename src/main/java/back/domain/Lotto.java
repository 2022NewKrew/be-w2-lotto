package back.domain;

import back.generator.PrizeGenerator;

import java.util.List;

public class Lotto {
    private final List<Integer> lottoSequence;
    private boolean autoCreated;

    public Lotto(List<Integer> lottoSequence) {
        this.lottoSequence = lottoSequence;
    }

    public Lotto(List<Integer> lottoSequence,
                 boolean autoCreated) {
        this.lottoSequence = lottoSequence;
        this.autoCreated = autoCreated;
    }

    public List<Integer> getLottoSequence() {
        return lottoSequence;
    }

    public boolean getAutoCreated() {
        return autoCreated;
    }

    public Prize getResult(WinningLotto winningLotto) {
        int correctNum = (int) lottoSequence.stream()
                .filter(lottoNumber -> winningLotto.getLottoSequence().contains(lottoNumber))
                .count();
        boolean isBonus = lottoSequence.contains(winningLotto.getBonusNumber());

        return PrizeGenerator.generate(correctNum, isBonus);
    }
}
