package domain;

import java.util.List;

public class Lotto {
    public static final int cost = 1000;
    private final List<Integer> lottoSequence;

    public Lotto(List<Integer> lottoSequence){
        this.lottoSequence = lottoSequence;
    }

    public List<Integer> getLottoSequence() {
        return lottoSequence;
    }

    public Prize getResult(WinningLotto winningLotto){
        int correctNum = (int) lottoSequence.stream()
                .filter(lottoNumber -> winningLotto.getLottoSequence().contains(lottoNumber))
                .count();
        boolean isBonus = lottoSequence.contains(winningLotto.getBonusNumber());

        return Prize.createPrize(correctNum, isBonus);
    }
}
