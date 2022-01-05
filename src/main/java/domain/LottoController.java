package domain;

import view.InputView;
import view.OutputView;

import java.util.ArrayList;
import java.util.List;

public class LottoController {
    private InputView inputView = new InputView();
    private OutputView outputView = new OutputView();
    private WinningStats winningStats;

    private int purchaseAmount;
    private List<Integer> winningNumbers = new ArrayList<>();
    private int bonusNumber;
    private final List<PurchasedLotto> allLotto = new ArrayList<>();

    public void runLotto() {
        getPurchaseAmount();
        buyLotto();
        printAllLotto();
        getLastWeekWinningNumbers();
        calculateWinningStats();
        printWinningStats();
    }

    private void getPurchaseAmount() {
        purchaseAmount = inputView.getPurchasedMoneyFromClient();
    }

    private void buyLotto() {
        for (int i = 0 ; i < getNumbersOfLotto() ; i++) {
            allLotto.add(new PurchasedLotto());
        }
    }

    private int getNumbersOfLotto() {
        return purchaseAmount/1000;
    }

    private void printAllLotto() {
        outputView.printAllLotto(allLotto);
    }

    private void getLastWeekWinningNumbers() {
        winningNumbers = inputView.getWinningNumbers();
        bonusNumber = inputView.getBonusNumber();
    }

    private void calculateWinningStats() {
        winningStats = new WinningStats(allLotto, winningNumbers, bonusNumber);
    }

    private void printWinningStats() {
        outputView.printWinningStats(winningStats.toStringArrayList());
        outputView.printWinningRate(getWinningRate());
    }

    private double getWinningRate() {
        int purchasedMoney = getNumbersOfLotto()*1000;
        return ((double) winningStats.getEarnedMoney()-(double) purchasedMoney)/purchasedMoney*100;
    }
}
