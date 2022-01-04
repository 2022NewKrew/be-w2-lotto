package lotto.step1.view.consoleView;

import lotto.step1.controller.LottoController;
import lotto.step1.dto.request.ConfirmTheWinDTO;
import lotto.step1.dto.response.LottoResultsDTO;
import lotto.step1.exception.ConsoleInputCountExceededException;
import lotto.step1.exception.LottoGameException;
import lotto.step1.util.TypeConverter;
import lotto.step1.util.Validator;
import lotto.step1.util.consoleInput.InputConsole;
import lotto.step1.util.consoleInput.LastWeekWinningNumbersInputConsole;

import java.util.List;

public class ConfirmResultView implements ConsoleView {
    protected final LottoController lottoController;
    protected final InputConsole<List<Integer>> lastWeekWinningNumbersInputConsole = new LastWeekWinningNumbersInputConsole();

    protected ConfirmResultView(LottoController lottoController) {
        this.lottoController = lottoController;
    }

    @Override
    public void print() throws LottoGameException, ClassCastException {
        final ConfirmTheWinDTO confirmTheWinDTO = inputConfirmTheWinDTO();
        final long lottoId = getLottoIdFromConsoleTempMemory();

        final LottoResultsDTO lottoResults = lottoController.confirmTheWin(lottoId, confirmTheWinDTO);
        System.out.println(lottoResults);
    }

    protected ConfirmTheWinDTO inputConfirmTheWinDTO() throws ConsoleInputCountExceededException {
        final List<Integer> lastWeekWinningNumbers = lastWeekWinningNumbersInputConsole.read();
        return new ConfirmTheWinDTO(lastWeekWinningNumbers);
    }

    protected long getLottoIdFromConsoleTempMemory() {
        final String id = getAttributes(LOTTO_ID);
        return TypeConverter.strToLong(id, Validator.EMPTY_VALIDATOR);
    }
}
