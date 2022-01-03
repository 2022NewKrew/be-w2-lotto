package domain;

import view.InputView;
import view.OutputView;

import java.util.ArrayList;
import java.util.List;

public class LottoController {
    private InputView inputView = new InputView();
    private OutputView outputView = new OutputView();

    private int purchaseAmount;
    private final List<Lotto> allLotto = new ArrayList<>();

    public void runLotto() {
        getPurchaseAmount();
        buyLotto();
        printAllLotto();
    }

    private void getPurchaseAmount() {
        purchaseAmount = inputView.getPurchasedMoneyFromClient();
    }

    private void buyLotto() {
        for (int i = 0 ; i < getNumbersOfLotto() ; i++) {
            allLotto.add(new Lotto());
        }
    }

    private int getNumbersOfLotto() {
        return purchaseAmount/1000;
    }

    private void printAllLotto() {
        outputView.printAllLotto(allLotto);
    }
}
