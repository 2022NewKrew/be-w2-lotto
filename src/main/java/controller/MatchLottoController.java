package controller;

import model.lotto.Lotto;
import model.lotto.number.LottoNumber;
import model.lotto.result.LottoResult;
import model.lotto.strategy.DefinedGenerateStrategy;
import view.UserInput;

import java.util.List;

public class MatchLottoController {

    public static LottoResult matchingResult(List<Lotto> lottos) {
        Lotto winingLotto = new Lotto(new DefinedGenerateStrategy(UserInput.getWinningLotto()));
        LottoNumber bonusNumber = LottoNumber.valueOf(UserInput.getBonusBall());
        return new LottoResult(lottos, winingLotto, bonusNumber);
    }
}
