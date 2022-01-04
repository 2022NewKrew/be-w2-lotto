package be.w2.lotto.domain;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static be.w2.lotto.common.exception.ExceptionMessages.INVALID_WINNING_NUMBERS_EXCEPTION;

public class WinningLottoTicket {
    List<LottoNumber> winningNumbers;

    private WinningLottoTicket(List<LottoNumber> winningNumbers) {
        this.winningNumbers = winningNumbers;
    }

    public static WinningLottoTicket valueOf(String winningNumbersInput) {
        List<String> parsedWinningNumbers = parseWinningLottoTicket(winningNumbersInput);
        validateNumbers(parsedWinningNumbers);

        List<LottoNumber> winningNumbers = parsedWinningNumbers
                .stream().map(Integer::parseInt)
                .map(LottoNumber::from)
                .collect(Collectors.toList());

        return new WinningLottoTicket(winningNumbers);
    }

    private static void validateNumbers(List<String> winningNumbers) throws IllegalArgumentException {
        if (winningNumbers.size() != LOTTO_SIZE) {
            throw new IllegalArgumentException(INVALID_WINNING_NUMBERS_EXCEPTION);
        }
    }

    private static List<String> parseWinningLottoTicket(String winningNumbersInput) {
        return Stream.of(winningNumbersInput.split(DELIMITER))
                .map(String::trim)
                .collect(Collectors.toList());
    }

    public List<LottoNumber> getLottoNumbers() {
        return this.winningNumbers;
    }

    private static final String DELIMITER = ",";

    private static final int LOTTO_SIZE = 6;
}
