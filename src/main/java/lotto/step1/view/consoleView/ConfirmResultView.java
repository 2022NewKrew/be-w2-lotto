package lotto.step1.view.consoleView;

import lotto.step1.controller.ConsoleLottoController;
import lotto.step1.dto.request.LastWeekWinningNumbersDTO;
import lotto.step1.dto.response.LottoResultsDTO;
import lotto.step1.exception.ConsoleInputCountExceededException;
import lotto.step1.exception.LottoGameException;
import lotto.step1.util.TypeConverter;
import lotto.step1.util.Validator;
import lotto.step1.util.consoleInput.LastWeekWinningNumbersInputConsole;

import java.util.List;

public class ConfirmResultView implements ConsoleView {
    private final ConsoleLottoController consoleLottoController;
    private final LastWeekWinningNumbersInputConsole lastWeekWinningNumbersInputConsole = new LastWeekWinningNumbersInputConsole();

    protected ConfirmResultView(ConsoleLottoController consoleLottoController) {
        this.consoleLottoController = consoleLottoController;
    }

    @Override
    public void print() throws LottoGameException {
        final LastWeekWinningNumbersDTO lastWeekWinningNumbersDTO = inputLastWeekWinningNumbers();
        final long lottoId = getLottoIdFromConsoleTempMemory();

        final LottoResultsDTO lottoResults = consoleLottoController.confirmTheWin(lottoId, lastWeekWinningNumbersDTO);
        System.out.println(lottoResults);
    }

    private LastWeekWinningNumbersDTO inputLastWeekWinningNumbers() throws ConsoleInputCountExceededException {
        final List<Integer> lastWeekWinningNumbers = lastWeekWinningNumbersInputConsole.read();
        return new LastWeekWinningNumbersDTO(lastWeekWinningNumbers);
    }

    private long getLottoIdFromConsoleTempMemory() {
        final String id = getAttributes(LOTTO_ID);
        return TypeConverter.strToLong(id, Validator.EMPTY_VALIDATOR);
    }
}
