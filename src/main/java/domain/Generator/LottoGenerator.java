package domain.Generator;

import domain.Lotto;

import java.util.List;

public abstract class LottoGenerator {
    protected static final int NUM_OF_LOTTO = 6;
    private List<Integer> lottoBox;

    public abstract Lotto generateLotto();

}
