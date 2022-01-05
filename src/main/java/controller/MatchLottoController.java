package controller;

import model.lotto.DefinedLotto;
import model.lotto.RandomLotto;
import model.lotto.result.LottoResult;
import view.UserInput;

import java.util.List;

public class MatchLottoController {

    public static LottoResult matchingResult(List<RandomLotto> lottos) {
        DefinedLotto winingLotto = new DefinedLotto(UserInput.getWinningLotto());
        return new LottoResult(lottos, winingLotto);
    }
}
