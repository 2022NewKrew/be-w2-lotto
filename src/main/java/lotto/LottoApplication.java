package lotto;

import lotto.controller.LottoController;

public class LottoApplication {
    public static void main(String[] args) {
        LottoController lc = new LottoController();
        lc.buyLotto();
        lc.checkLotto();
    }
}
