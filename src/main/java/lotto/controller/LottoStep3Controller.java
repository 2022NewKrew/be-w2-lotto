package lotto.controller;

import lotto.service.LottoService;
import lotto.service.domain.LottoGame;
import lotto.service.domain.LottoResult;
import lotto.util.LottoConstantValue;
import lotto.util.Validator;
import lotto.util.input.*;
import lotto.view.ConsoleOutput;

import java.util.ArrayList;
import java.util.List;

public class LottoStep3Controller {
    private final ConsoleInputInterface<Long> inputBudget = new InputBudget();
    private final ConsoleInputInterface<Integer> inputNumberOfManualLotto = new InputNumberOfManualLotto();
    private final ConsoleInputInterface<List<Integer>> inputManualLottoNumbers = new InputManualLottoNumbers();
    private final ConsoleInputInterface<List<Integer>> inputWinningNumbers = new InputWinningNumbers();
    private final ConsoleInputInterface<Integer> inputBonusNumber = new InputBonusNumber();

    private final ConsoleOutput output = new ConsoleOutput();
    private final LottoService lottoService = new LottoService();

    public void start(){
        LottoGame lottoGame = purchase();
        printPurchased(lottoGame);

        announcement(lottoGame);

        LottoResult result = lottoService.getWholeGameResult(lottoGame);
        printResult(result);
    }

    private void printPurchased(LottoGame lottoGame) {
        output.printPurchaedHistory(lottoGame);
    }

    private void printResult(LottoResult result) {
        output.printResult(result);
        output.printProfit(result);
    }

    private LottoGame purchase(){
        long budget = inputBudget.read(true);
        int numberOfManualLottoToBuy = inputNumberOfManualLotto.read(true);
        if(budget/ LottoConstantValue.LOTTO_PRICE < numberOfManualLottoToBuy)
            throw new IllegalArgumentException("입력한 예산으로 구매가능한 개수를 초과했습니다.");

        List<List<Integer>> manualLottoNumbersList = readManualNumbers(numberOfManualLottoToBuy);

        return lottoService.purchaseLottoGame(budget, manualLottoNumbersList);
    }

    private List<List<Integer>> readManualNumbers(int numberOfManualLottoToBuy){
        int inputNumbersCount = numberOfManualLottoToBuy;
        List<List<Integer>> manualLottoNumbersList = new ArrayList<>();
        while(inputNumbersCount > 0){
            manualLottoNumbersList.add(
                    inputManualLottoNumbers.read(inputNumbersCount-- == numberOfManualLottoToBuy ));
        }
        return manualLottoNumbersList;
    }

    private void announcement(LottoGame lottoGame) {
        List<Integer> winningNumbers = inputWinningNumbers.read(true);
        int bonusNumber = inputBonusNumber.read(true);
        Validator.checkBonusNumberAndWinningNumbersDuplication(winningNumbers, bonusNumber);

        lottoGame.announceLottoWinningNumber(winningNumbers,bonusNumber);
    }
}
