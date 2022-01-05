package be.w2.lotto.Domain;

import java.util.List;

public class LottoCalculator {

    private LottoResult lottoResult;

    public LottoCalculator(List<Integer> answersInput, int bonusNumberInput, LottoTickets lottoTickets) {
        LottoNumbers answers = LottoNumbers.getInstanceByIntList(answersInput);
        LottoNumber bonusNumber = new LottoNumber(answers, bonusNumberInput);
        this.lottoResult = lottoTickets.calculateResult(answers, bonusNumber);
    }

    public int benefit() {
        return lottoResult.calculateBenefit();
    }

    public List<List<String>> getStatistics() {
        return lottoResult.getStatistics();
    }


}
