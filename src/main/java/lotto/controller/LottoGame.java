package lotto.controller;

import lotto.domain.LottoResult;
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
    private int bonusNumber;
    private final PlayerLottoList playerLottoList = new PlayerLottoList();
    private List<Integer> winningNumbers = new ArrayList<>();

    public void startGame(){
        try (Scanner scanner = new Scanner(System.in)) {
            purchaseAmount = LottoGameInput.inputPurchaseAmount(scanner);
            purchaseLotto();
            LottoGameOutput.printLottoNumbers(numberOfLotto, playerLottoList);
            winningNumbers = LottoGameInput.inputWinningNumbers(scanner);
            bonusNumber = LottoGameInput.inputBonusNumber(scanner);
            showResults();
        }
    }

    private void purchaseLotto() {
        numberOfLotto = purchaseAmount / LOTTO_PRICE;
        for (int i = 0; i < numberOfLotto; i++) {
            playerLottoList.purchaseLotto();
        }
    }

    private void showResults(){
        List<LottoResult> playerLottoResults = playerLottoList.getLottoResults(winningNumbers);
        long rewardRate = calculateRewardRate(playerLottoResults);
        LottoGameOutput.printLottoResults(playerLottoResults, rewardRate);
    }

    private long calculateRewardRate(List<LottoResult> playerLottoResults){
        long totalEarnMoney = 0;
        for (LottoResult playerLottoResult : playerLottoResults) {
            totalEarnMoney += playerLottoResult.calculateEarnMoney();
        }
        return (totalEarnMoney*100 / purchaseAmount);
    }
}
