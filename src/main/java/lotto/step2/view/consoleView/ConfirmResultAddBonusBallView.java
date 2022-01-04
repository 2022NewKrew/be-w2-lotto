package lotto.step2.view.consoleView;

import lotto.step1.controller.LottoController;
import lotto.step1.dto.request.ConfirmTheWinDTO;
import lotto.step1.exception.ConsoleInputCountExceededException;
import lotto.step1.util.consoleInput.InputConsole;
import lotto.step2.dto.request.ConfirmTheWinAddBonusBallDTO;
import lotto.step2.util.consoleInput.BonusBallInputConsole;
import lotto.step1.view.consoleView.ConfirmResultView;

import java.util.List;

public class ConfirmResultAddBonusBallView extends ConfirmResultView {
    private final InputConsole<Integer> bonusBallInputConsole = new BonusBallInputConsole();

    public ConfirmResultAddBonusBallView(LottoController lottoController) {
        super(lottoController);
    }

    @Override
    protected ConfirmTheWinDTO inputConfirmTheWinDTO() throws ConsoleInputCountExceededException {
        final List<Integer> lastWeekWinningNumbers = lastWeekWinningNumbersInputConsole.read();
        final int bonusBall = bonusBallInputConsole.read();

        return new ConfirmTheWinAddBonusBallDTO(lastWeekWinningNumbers, bonusBall);
    }
}
