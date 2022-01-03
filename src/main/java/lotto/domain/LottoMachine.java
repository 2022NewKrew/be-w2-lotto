package lotto.domain;

import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LottoMachine {

    private static final int LOTTO_PRICE = 1000;
    private int purchaseAmount;
    private int prizeAmount;
    private List<Integer> winningNumberList;
    private final List<Lotto> lottoList = new ArrayList<>();
    private final List<Integer> numberList = new ArrayList<>();

    public LottoMachine() {
        for (int i = 1; i <= 45; i++) {
            numberList.add(i);
        }
    }

    public void start() {
        this.purchaseAmount = InputView.getPurchaseAmount();
        purchaseLotto();
        OutputView.printLottos(lottoList);
        this.winningNumberList = InputView.getWinningNumberList();
        checkLottoList();
        OutputView.printLottoResults(purchaseAmount, prizeAmount);
    }

    private void purchaseLotto() {
        int lottoCount = purchaseAmount / LOTTO_PRICE;
        for (int i = 0; i < lottoCount; i++) {
            Collections.shuffle(numberList);
            List<Integer> tempNumberList = new ArrayList<>(numberList.subList(0, 6));
            Collections.sort(tempNumberList);
            lottoList.add(new Lotto(tempNumberList));
        }
    }

    private void checkLottoList() {
        for (Lotto lotto : lottoList) {
            int matchingNumber = lotto.checkLotto(winningNumberList);
            Rank rank = Rank.valueOf(matchingNumber);
            addPrizeAmount(rank);
        }
    }

    private void addPrizeAmount(Rank rank) {
        if (rank != null) {
            rank.addWinnerCount();
            prizeAmount += rank.getPrizeAmount();
        }
    }
}
