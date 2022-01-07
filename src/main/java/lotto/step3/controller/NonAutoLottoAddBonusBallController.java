package lotto.step3.controller;

import lotto.step2.controller.LottoAddBonusBallController;
import lotto.step3.model.NonAutoLottoAddBonusBallGenerator;

public class NonAutoLottoAddBonusBallController extends LottoAddBonusBallController {
    public NonAutoLottoAddBonusBallController() {
        super(new NonAutoLottoAddBonusBallGenerator());
    }
}
