package application;

import domain.Lotto;
import domain.WinningLotto;
import view.LottoScanner;

public class WinningLottoGenerator implements LottoGenerator {
    private WinningLotto winningLotto;

    @Override
    public Lotto getLotto() {
        if (winningLotto == null) {
            winningLotto = new WinningLotto(LottoScanner.getWinningLottoNumbers());
        }
        return winningLotto;
    }
}
