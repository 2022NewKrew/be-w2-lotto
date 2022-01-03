package lotto.view;

import lotto.domain.Lotto;

public class LottoInput {
    public int enterMoney() {
        return 14000;
    }

    public Lotto enterPastWinningLotto() {
        Lotto lotto = new Lotto();
        String lottoString = "1, 2, 3, 4, 5, 6";
        lotto.initialize(lottoString);
        return lotto;
    }
}
