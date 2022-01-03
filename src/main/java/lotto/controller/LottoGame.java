package lotto.controller;

import lotto.view.LottoGameInput;
import lotto.view.LottoGameOutput;

import java.util.Scanner;

public class LottoGame {

    private int purchaseAmount;

    public void startGame(){
        try (Scanner scanner = new Scanner(System.in)) {
            purchaseAmount = LottoGameInput.inputPurchaseAmount(scanner);
            LottoGameOutput.printLottoNumbers(purchaseAmount);
        }
    }
}
