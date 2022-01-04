package lotto.controller;

import lotto.service.domain.LottoGame;
import lotto.service.LottoService;
import lotto.service.domain.LottoResult;
import lotto.view.ConsoleInput;
import lotto.view.ConsoleOutput;
import lotto.view.InputInterface;

import java.util.List;

public class LottoController {

    private static InputInterface input = new ConsoleInput();
    private static ConsoleOutput output = new ConsoleOutput();
    private final LottoService lottoService = new LottoService();

    public void start(){
        final long budget = input.inputBudget();
        final LottoGame lottoGame = lottoService.purchaseLottoGame(budget);

        List<Integer> winningNumbers = input.inputWinningNumbers();

        LottoResult lottoResult = lottoService.getWholeGameResult(lottoGame, winningNumbers);

        output.printResult(lottoResult);
        output.printProfit(budget, lottoResult.getWholePrizeMoney());
    }
}
