package controller;

import model.lotto.Lotto;
import model.lotto.number.LottoNumber;
import model.lotto.result.LottoResult;
import view.UserInput;

import java.util.List;

public class MatchLottoController {

    public static LottoResult matchingResult(List<Lotto> lottos) {
        Lotto winingLotto = Lotto.getDefinedLotto(UserInput.getWinningLotto());
        LottoNumber bonusNumber = new LottoNumber(UserInput.getBonusBall());
        if (winingLotto.contain(bonusNumber)) {
            throw new IllegalArgumentException("보너스볼은 당첨번호와 겹치면 안됩니다.");
        }
        return new LottoResult(lottos, winingLotto, bonusNumber);
    }
}
