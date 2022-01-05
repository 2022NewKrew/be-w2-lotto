package lotto.controller;

import lotto.domain.lotto.Lotto;
import lotto.domain.player.PlayerLotto;
import lotto.domain.purchase.LottoPurchaseMachine;
import lotto.domain.result.LottoResult;
import lotto.domain.result.LottoResultChecker;
import lotto.domain.player.PlayerLottoList;
import lotto.domain.result.WinningLotto;
import lotto.view.LottoGameInput;
import lotto.view.LottoGameOutput;

import java.util.List;
import java.util.Scanner;

public class LottoGame {
    private int purchaseAmount;
    private int numberOfLotto;
    private int bonusNumber;
    private final PlayerLottoList playerLottoList = new PlayerLottoList();
    private WinningLotto winningLotto;

    public void startGame(){
        try (Scanner scanner = new Scanner(System.in)) {
            purchase(scanner);
            drawLotto(scanner);
            showResults();
        }
    }

    private void purchase(Scanner scanner){
        purchaseAmount = LottoGameInput.inputPurchaseAmount(scanner);
        numberOfLotto = purchaseAmount / Lotto.LOTTO_PRICE;
        int numberOfManualLotto = LottoGameInput.inputNumberOfManualLotto(scanner);
        purchaseManualLotto(scanner, numberOfManualLotto);

        int numberOfAutoLotto = numberOfLotto - numberOfManualLotto;
        purchaseAutoLotto(numberOfAutoLotto);

        LottoGameOutput.printLottoNumbers(numberOfManualLotto, numberOfAutoLotto, playerLottoList);
    }

    private void purchaseManualLotto(Scanner scanner, int numberOfManualLotto){
        LottoGameOutput.printInputManualLottoComment();
        for (int i =0 ; i < numberOfManualLotto; i++) {
            List<Integer> inputManualNumbers = LottoGameInput.inputOneManualLotto(scanner);
            PlayerLotto manualLotto = LottoPurchaseMachine.purchaseManualLotto(inputManualNumbers);
            playerLottoList.addPlayerLotto(manualLotto);
        }
    }

    private void purchaseAutoLotto(int numberOfAutoLotto){
        for (int i = 0; i < numberOfAutoLotto; i++) {
            PlayerLotto autoLotto = LottoPurchaseMachine.purchaseAutoLotto();
            playerLottoList.addPlayerLotto(autoLotto);
        }
    }

    private void drawLotto(Scanner scanner){
        winningLotto = LottoGameInput.inputWinningNumbers(scanner);
        bonusNumber = LottoGameInput.inputBonusNumber(scanner);
    }

    private void showResults(){
        LottoResultChecker lottoResultChecker = new LottoResultChecker(winningLotto, bonusNumber);
        List<LottoResult> playerLottoResults = lottoResultChecker.getLottoResults(playerLottoList);

        long rewardRate = calculateRewardRate(playerLottoResults);
        LottoGameOutput.printLottoResults(playerLottoResults, rewardRate);
    }

    private long calculateRewardRate(List<LottoResult> playerLottoResults){
        long totalEarnMoney = 0;
        for (LottoResult playerLottoResult : playerLottoResults) {
            totalEarnMoney += playerLottoResult.calculateEarnMoney();
        }
        return ((totalEarnMoney-purchaseAmount)*100 / purchaseAmount);
    }
}
