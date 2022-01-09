package domain.Generator;

import domain.Lotto;


public abstract class LottoGenerator {
    protected static final int NUM_OF_LOTTO = 6;

    public abstract Lotto generateLotto();

}
