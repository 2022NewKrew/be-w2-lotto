package be.w2.lotto.Domain;

import java.util.List;

public class LottoService {
    private LottoSeller lottoSeller;
    private LottoTickets lottoTickets;
    private LottoCalculator lottoCalculator;
    private Money money;

    public LottoService(){
        this.lottoSeller = new LottoSeller(new LottoMaker());
    }

    public int calculateAmount(int moneyInput){
        return new Money(moneyInput).calculateAmount(LottoTicket.PRICE);
    }

    public void sell(int moneyInput){
        Money money = new Money(moneyInput);
        this.money = money;
        this.lottoTickets = lottoSeller.sell(money);
    }

    public int calculateBenefit(List<Integer> answers){
        this.lottoCalculator = new LottoCalculator(answers);
        int benefit = lottoCalculator.calculateResult(lottoTickets);
        return money.calEarningRate(benefit);
    }

    public List<List<Integer>> getStatistics(){
        return lottoCalculator.getStatistics();
    }

    public LottoTickets getLottoTickets(){
        return lottoTickets;
    }


}
