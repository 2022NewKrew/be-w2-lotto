package lotto.step5.controller;

import lotto.step3.model.NonAutoLottoAddBonusBallGenerator;
import lotto.step4.controller.LottoGameWebController;
import lotto.step5.repository.H2LottoRepository;

public class LottoGameWebUsingDBController extends LottoGameWebController {
    public LottoGameWebUsingDBController() {
        super(new NonAutoLottoAddBonusBallGenerator(), new H2LottoRepository());
    }
}
