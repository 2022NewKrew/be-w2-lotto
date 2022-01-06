package be.w2.lotto.Domain;


import java.util.List;

public class LottoService {

    private LottoMaker lottoMaker;
    private LottoTickets lottoTickets;
    private LottoResult lottoResult;
    private Money money;
    private Amount manualAmount;

    public LottoService() {
        this.lottoMaker = new LottoMaker();
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

    public void sell(List<List<Integer>> manualNumbers) {
        LottoTickets lottoTickets = new LottoTickets();
        sellManual(manualNumbers, this.money, lottoTickets, this.manualAmount);
        sellAuto(money, lottoTickets);
        this.lottoTickets = lottoTickets;
    }

    private void sellManual(List<List<Integer>> manualNumbers, Money money, LottoTickets lottoTickets, Amount amount) {
        lottoTickets.addManualTickets(manualNumbers, money, amount);
    }

    private void sellAuto(Money money, LottoTickets lottoTickets) {
        lottoTickets.addAutoTickets(money, lottoMaker);
    }

    public void makeLottoResult(List<Integer> answersInput, int bonusNumberInput) {
        LottoNumbers answers = LottoNumbers.getInstanceByIntList(answersInput);
        LottoNumber bonusNumber = new LottoNumber(answers, bonusNumberInput);
        this.lottoResult = lottoTickets.calculateResult(answers, bonusNumber);
    }

    public int calculateBenefit() {
        int benefit = lottoResult.benefit();
        return money.earningRate(benefit);
    }

    public List<List<String>> getStatistics() {
        return lottoResult.getStatistics();
    }

    public LottoTickets getLottoTickets() {
        return lottoTickets;
    }


}
