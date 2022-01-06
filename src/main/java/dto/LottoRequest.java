package dto;

import domain.lotto.Lotto;
import domain.lotto.LottoGenerator;

import java.util.List;

public class LottoRequest {

    List<Integer> lottoNumbers;

    public LottoRequest(List<Integer> lottoNumbers) {
        this.lottoNumbers = lottoNumbers;
    }

    public Lotto createLotto() {
        return LottoGenerator.generateOneLotto(lottoNumbers);
    }
}
