package controller;

import model.lotto.DefinedLottoGenerator;
import model.lotto.Lotto;
import model.lotto.number.LottoNumber;
import model.lotto.result.LottoResult;
import view.UserInput;

import java.util.List;

public class MatchLottoController {

    public static LottoResult matchingResult(List<Lotto> lottos) {
        Lotto winingLotto = new Lotto(DefinedLottoGenerator.generate(UserInput.getWinningLotto()));
        LottoNumber bonusNumber = LottoNumber.valueOf(UserInput.getBonusBall());
        return new LottoResult(lottos, winingLotto, bonusNumber);
    }
}
