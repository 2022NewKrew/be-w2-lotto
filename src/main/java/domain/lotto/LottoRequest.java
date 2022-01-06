package domain.lotto;

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
