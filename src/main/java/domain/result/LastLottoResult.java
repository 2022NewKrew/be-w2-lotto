package domain.result;

import domain.lotto.Lotto;
import domain.lotto.Number;

import java.util.List;


public class LastLottoResult {
    private final Lotto lastLottoResult;
    private final Number bonusNumber;

    public LastLottoResult(List<Number> lottoNumbers, Number bonusNumber) {
        lastLottoResult = new Lotto(lottoNumbers);
        this.bonusNumber = bonusNumber;
    }

    //대상이 되는 로또 번호와 결과 로또 번호중 얼마나 번호가 일치하는지 계산
    public int calculateHittingCnt(Lotto targetLotto) {
        return lastLottoResult.compareLotto(targetLotto);
    }

    public int calculateBonusCnt(Lotto targetLotto) {
        return targetLotto.compareLottoWithBonus(bonusNumber);
    }
}
