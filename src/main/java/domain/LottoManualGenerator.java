package domain;

import view.LottoInterface;

public class LottoManualGenerator implements LottoGenerable {
    private final LottoInterface lottoInterface;

    public LottoManualGenerator(LottoInterface lottoInterface) {
        this.lottoInterface = lottoInterface;
    }

    @Override
    public Lotto generate() {
        return new Lotto(lottoInterface.inputNumbers());
    }
}
