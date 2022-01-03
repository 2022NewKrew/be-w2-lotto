package lotto.controller;

import lotto.domain.PlayerLottoList;
import lotto.view.LottoGameInput;
import lotto.view.LottoGameOutput;

import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;

public class LottoGame {
    private final int LOTTO_PRICE = 1000;

    private int purchaseAmount;
    private int numberOfLotto;
    private final PlayerLottoList playerLottoList = new PlayerLottoList();
    private List<Integer> winningNumbers = new ArrayList<>();

    public void startGame(){
        try (Scanner scanner = new Scanner(System.in)) {
            purchaseAmount = LottoGameInput.inputPurchaseAmount(scanner);
            purchaseLotto();
            LottoGameOutput.printLottoNumbers(numberOfLotto, playerLottoList);
            winningNumbers = LottoGameInput.inputWinningNumbers(scanner);
        }
    }

    private void purchaseLotto() {
        numberOfLotto = purchaseAmount / LOTTO_PRICE;
        for (int i = 0; i < numberOfLotto; i++) {
            playerLottoList.purchaseLotto();
        }
    }
}
