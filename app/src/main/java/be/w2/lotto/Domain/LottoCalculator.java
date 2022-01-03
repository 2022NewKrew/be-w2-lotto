package be.w2.lotto.Domain;

import java.util.List;

public class LottoCalculator {

    private LottoNumbers answers;
    private LottoResult lottoResult;

    public LottoCalculator(List<Integer> answers) {
        this.answers = LottoNumbers.getInstanceByIntList(answers);
        this.lottoResult = new LottoResult();
    }

    public int calculateResult(LottoTickets lottoTickets) {
        for (LottoTicket lottoTicket : lottoTickets) {
            int hit = calculateTicket(lottoTicket);
            lottoResult.add(hit);
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

    public List<List<Integer>> getStatistics() {
        return lottoResult.getStatistics();
    }

    private int calculateContains(LottoTicket lottoTicket, LottoNumber lottoNumber, int amount) {
        if (lottoTicket.contains(lottoNumber))
            return amount + 1;
        return amount;
    }

}
