package be.w2.lotto.Domain;

import java.util.List;

public class LottoCalculator {

    private LottoNumbers answers;
    private LottoResult lottoResult;
    private LottoNumber bonusNumber;

    public LottoCalculator(List<Integer> answers, int bonusNumber) {
        this.answers = LottoNumbers.getInstanceByIntList(answers);
        this.lottoResult = new LottoResult();
        this.bonusNumber = new LottoNumber(bonusNumber);
    }

    public int calculateResult(LottoTickets lottoTickets) {
        for (LottoTicket lottoTicket : lottoTickets) {
            int hit = calculateTicket(lottoTicket);
            boolean isBonus = lottoTicket.contains(bonusNumber);
            lottoResult.add(HitCount.valueOf(hit, isBonus));
        }
        return lottoResult.calculateBenefit();
    }

    public int calculateTicket(LottoTicket lottoTicket) {
        int amount = 0;
        for (LottoNumber answer : answers) {
            amount = calculateContains(lottoTicket, answer, amount);
        }

        return amount;
    }

    public List<List<String>> getStatistics() {
        return lottoResult.getStatistics();
    }

    private int calculateContains(LottoTicket lottoTicket, LottoNumber lottoNumber, int amount) {
        if (lottoTicket.contains(lottoNumber))
            return amount + 1;
        return amount;
    }

}
