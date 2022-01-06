package dto;

import domain.lotto.Lotto;
import domain.lotto.LottoGenerator;
import domain.lotto.LottoValidator;
import domain.lotto.WinningLotto;

import java.util.List;

public class LottoRequest {

    List<Integer> lottoNumbers;

    public LottoRequest(List<Integer> lottoNumbers) {
        this.lottoNumbers = lottoNumbers;
    }

    public Lotto toLotto() {
        return LottoGenerator.generateOneLotto(lottoNumbers);
    }

    public WinningLotto toWinningLotto(int bonusNumber) {
        LottoValidator.validateBonusLottoNumber(lottoNumbers, bonusNumber);
        return LottoGenerator.generateWinningLotto(lottoNumbers, bonusNumber);
    }
}
