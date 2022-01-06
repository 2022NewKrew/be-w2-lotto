package lotto.controller;

import lotto.domain.lotto.Lotto;
import lotto.domain.player.PlayerLotto;
import lotto.domain.purchase.LottoPurchaseMachine;
import lotto.domain.result.*;
import lotto.domain.player.PlayerLottoList;
import lotto.validator.InputValidator;
import lotto.view.LottoGameInput;
import lotto.view.LottoGameOutput;

import java.util.List;
import java.util.Scanner;

public class LottoGame {
    private int purchaseAmount;
    private int numberOfLotto;
    private final PlayerLottoList playerLottoList = new PlayerLottoList();
    private WinningLottoInfo winningLottoInfo;

    public void startGame(){
        try (Scanner scanner = new Scanner(System.in)) {
            purchase(scanner);
            drawLotto(scanner);
            showResults();
        }
    }

    private void purchase(Scanner scanner){
        purchaseAmount = LottoGameInput.inputPurchaseAmount(scanner);
        InputValidator.validateNumber(purchaseAmount);

        numberOfLotto = purchaseAmount / Lotto.LOTTO_PRICE;
        int numberOfManualLotto = LottoGameInput.inputNumberOfManualLotto(scanner);
        InputValidator.validateCanPurchaseLotto(numberOfLotto, numberOfManualLotto);
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
        WinningLotto winningLotto = new WinningLotto(LottoGameInput.inputWinningNumbers(scanner));
        BonusNumber bonusNumber = new BonusNumber(LottoGameInput.inputBonusNumber(scanner));
        winningLottoInfo = new WinningLottoInfo(winningLotto, bonusNumber);
    }

    private void showResults(){
        LottoResultChecker lottoResultChecker = new LottoResultChecker(winningLottoInfo);
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
