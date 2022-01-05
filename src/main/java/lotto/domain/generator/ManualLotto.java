package lotto.domain.generator;

import lotto.domain.Lotto;

import java.util.List;

public class ManualLotto implements LottoGenerator{
    private final List<Lotto> manualLottoBundle;

    public ManualLotto(List<Lotto> manualLottoBundle) {
        this.manualLottoBundle = manualLottoBundle;
    }

    @Override
    public List<Lotto> generateTickets() {
        return manualLottoBundle;
    }
}