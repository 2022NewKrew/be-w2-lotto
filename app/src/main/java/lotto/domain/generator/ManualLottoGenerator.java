package lotto.domain.generator;

import lotto.domain.Lotto;
import lotto.view.InputView;

public class ManualLottoGenerator implements LottoGenerator {

    @Override
    public Lotto generate() {
        return new Lotto(InputView.inputLottoNumbersManually());  // InputView.. ?
    }
}
