package lotto.controller;

import lotto.domain.result.LottoResult;
import lotto.domain.result.LottoResultChecker;
import lotto.domain.player.PlayerLottoList;
import lotto.domain.result.WinnerLotto;
import lotto.view.LottoGameInput;
import lotto.view.LottoGameOutput;

import java.util.List;
import java.util.Scanner;

public class LottoGame {
    private final int LOTTO_PRICE = 1000;

    private int purchaseAmount;
    private int numberOfLotto;
    private int bonusNumber;
    private final PlayerLottoList playerLottoList = new PlayerLottoList();
    private WinnerLotto winnerLotto;

    public void startGame(){
        try (Scanner scanner = new Scanner(System.in)) {
            purchase(scanner);
            drawLotto(scanner);
            showResults();
        }
    }

    private void purchase(Scanner scanner){
        purchaseAmount = LottoGameInput.inputPurchaseAmount(scanner);
        purchaseLotto();
        LottoGameOutput.printLottoNumbers(numberOfLotto, playerLottoList);
    }

    private void purchaseLotto() {
        numberOfLotto = purchaseAmount / LOTTO_PRICE;
        for (int i = 0; i < numberOfLotto; i++) {
            playerLottoList.purchaseLotto();
        }
    }

    private void drawLotto(Scanner scanner){
        winnerLotto = LottoGameInput.inputWinningNumbers(scanner);
        bonusNumber = LottoGameInput.inputBonusNumber(scanner);
    }

    private void showResults(){
        LottoResultChecker lottoResultChecker = new LottoResultChecker(winnerLotto, bonusNumber);
        List<LottoResult> playerLottoResults = lottoResultChecker.getLottoResults(playerLottoList);

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
