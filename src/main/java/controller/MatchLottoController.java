package controller;

import model.lotto.DefinedLotto;
import model.lotto.Lotto;
import model.lottoResult.LottoResult;
import view.UserInput;

import java.util.List;

public class MatchLottoController {

    public static LottoResult matchingResult(List<Lotto> lottos) {
        Lotto winingLotto = new DefinedLotto(UserInput.getWinningLotto());
        return new LottoResult(lottos, winingLotto);
    }
}
