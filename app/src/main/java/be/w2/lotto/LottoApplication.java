package be.w2.lotto;

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
        makeMoney();
        makeAmount();
        makeManualInputs();
        userInterface.printBuyAmount(lottoService.getLottoTickets());
        userInterface.printTickets(lottoService.getLottoTickets());
    }

    private void makeManualInputs() {
        while (!isValidManualInputs()) ;
    }

    private boolean isValidManualInputs() {
        boolean isValid = false;
        try {
            userInterface.queryManualNumbers();
            List<List<Integer>> manualInputs = userInterface.readManualInputs(lottoService.getManualAmount());
            lottoService.sell(manualInputs);
            isValid = true;
        } catch (IllegalArgumentException e) {
            userInterface.printString(e.getMessage());
        }
        return isValid;
    }

    private void makeAmount() {
        while (!isValidAmount()) ;
    }

    private boolean isValidAmount() {
        boolean isValid = false;
        try {
            userInterface.queryManualAmount();
            lottoService.makeAmount(userInterface.readInt());
            isValid = true;
        } catch (IllegalArgumentException e) {
            userInterface.printString(e.getMessage());
        }
        return isValid;
    }


    private void makeMoney() {
        while (!isValidMoney()) ;
    }

    private boolean isValidMoney() {
        boolean isValid = false;
        try {
            userInterface.queryBuyMoney();
            lottoService.makeMoney(userInterface.readInt());
            isValid = true;
        } catch (IllegalArgumentException e) {
            userInterface.printString(e.getMessage());
        }
        return isValid;
    }

    private void makeAnswer() {
        makeBenefit();
        userInterface.printStatistics(lottoService.getStatistics());
        userInterface.printBenefit(lottoService.calculateBenefit());
    }

    private void makeBenefit() {
        while (!isValidBenefit()) ;
    }

    private boolean isValidBenefit() {
        boolean isValid = false;
        try {
            userInterface.queryAnswerNumber();
            List<Integer> nums = userInterface.readIntList();
            userInterface.queryBonusNumber();
            int bonusNum = userInterface.readInt();
            lottoService.makeLottoResult(nums, bonusNum);
            isValid = true;
        } catch (IllegalArgumentException e) {
            userInterface.printString(e.getMessage());
        }
        return isValid;
    }

}
