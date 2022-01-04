package lotto.controller;

import lotto.service.LottoBonusService;
import lotto.service.domain.LottoGame;
import lotto.service.domain.LottoResult;
import lotto.view.ConsoleInput;
import lotto.view.ConsoleOutput;
import lotto.view.InputInterface;

import java.util.List;

public class LottoBonusController{
    private static InputInterface input = new ConsoleInput();
    private static ConsoleOutput output = new ConsoleOutput();
    private final LottoBonusService lottoService = new LottoBonusService();

    public void start(){
        final long budget = input.inputBudget();
        final LottoGame lottoGame = lottoService.purchaseLottoGame(budget);

        List<Integer> winningNumbers = input.inputWinningNumbers();
        int bonusNumber = input.inputBonusNumber(winningNumbers);

        LottoResult lottoResult = lottoService.getWholeGameResult(lottoGame, winningNumbers, bonusNumber);

        output.printResult(lottoResult);
        output.printProfit(budget, lottoResult.getWholePrizeMoney());
    }
}
