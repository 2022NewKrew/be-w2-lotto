package be.w2.lotto;

import be.w2.lotto.Domain.LottoCalculator;
import be.w2.lotto.Domain.LottoService;
import be.w2.lotto.View.UserInterface;

import java.util.List;

public class LottoApplication {

    private final UserInterface userInterface;
    private final LottoService lottoService;

    public LottoApplication() {
        this.userInterface = new UserInterface();
        this.lottoService = new LottoService();
    }

    public static void main(String[] args) {
        LottoApplication lottoApplication = new LottoApplication();
        lottoApplication.makeLottoTickets();
        lottoApplication.makeAnswer();
    }

    private void makeLottoTickets() {
        userInterface.queryBuyMoney();
        int moneyInput = userInterface.readInt();
        int amount = lottoService.calculateAmount(moneyInput);
        userInterface.printBuyAmount(amount);
        lottoService.sell(moneyInput);
        userInterface.printTickets(lottoService.getLottoTickets());
    }

    private void makeAnswer() {
        userInterface.queryLastNumber();
        List<Integer> nums = userInterface.readIntList();
        int benefit = lottoService.calculateBenefit(nums);
        userInterface.printStatistics(lottoService.getStatistics());
        userInterface.printBenefit(benefit);
    }
}
