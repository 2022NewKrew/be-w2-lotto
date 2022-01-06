package controller;

import model.lotto.Lotto;
import model.lotto.result.LottoResult;
import view.UserInput;

import java.util.List;

public class MatchLottoController {

    public static LottoResult matchingResult(List<Lotto> lottos) {
        Lotto winingLotto = Lotto.getDefinedLotto(UserInput.getWinningLotto());
        return new LottoResult(lottos, winingLotto);
    }
}
