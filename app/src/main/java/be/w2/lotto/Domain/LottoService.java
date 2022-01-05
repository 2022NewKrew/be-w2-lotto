package be.w2.lotto.Domain;


import java.util.List;

public class LottoService {

    private LottoSeller lottoSeller;
    private LottoTickets lottoTickets;
    private LottoCalculator lottoCalculator;
    private Money money;
    private Amount manualAmount;

    public LottoService() {
        this.lottoSeller = new LottoSeller(new LottoMaker());
    }

    public void makeMoney(int moneyInput) {
        this.money = new Money(moneyInput);
    }

    public void makeAmount(int amountInput) {
        this.manualAmount = new Amount(amountInput);
    }

    public int getManualAmount() {
        return this.manualAmount.getAmount();
    }

    public void sell(List<List<Integer>> manualListInput) {
        this.lottoTickets = lottoSeller.sell(manualListInput, money, manualAmount);
    }

    public void makeLottoResult(List<Integer> answers, int bonusNumber) {
        this.lottoCalculator = new LottoCalculator(answers, bonusNumber, lottoTickets);
    }

    public int calculateBenefit() {
        int benefit = lottoCalculator.benefit();
        return money.calculateAmount(benefit);
    }

    public List<List<String>> getStatistics() {
        return lottoCalculator.getStatistics();
    }

    public LottoTickets getLottoTickets() {
        return lottoTickets;
    }


}
