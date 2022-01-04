package be.w2.lotto.domain;

import java.util.List;
import java.util.stream.Collectors;

import static be.w2.lotto.common.exception.ExceptionMessages.INVALID_WINNING_NUMBERS_EXCEPTION;
import static be.w2.lotto.common.exception.ExceptionMessages.NUMBER_DUPLICATION_NOT_ALLOWED_EXCEPTION;
import static be.w2.lotto.domain.LottoTickets.LOTTO_TICKET_SIZE;

public class WinningLottoTicket {
    private final List<LottoNumber> winningNumbers;

    private WinningLottoTicket(List<LottoNumber> winningNumbers) {
        this.winningNumbers = winningNumbers;
    }

    public List<Integer> getLottoNumbers() {
        return this.winningNumbers
                .stream().map(LottoNumber::getNumber)
                .collect(Collectors.toList());
    }

    public static WinningLottoTicket valueOf(List<Integer> winningNumbers) {
        validateNumbers(winningNumbers);

        List<LottoNumber> winningLottoNumbers = winningNumbers
                .stream().map(LottoNumber::from)
                .collect(Collectors.toList());

        return new WinningLottoTicket(winningLottoNumbers);
    }

    private static void validateNumbers(List<Integer> winningNumbers) throws IllegalArgumentException {
        validateNumbersSize(winningNumbers);
        validateNumbersDuplication(winningNumbers);
    }

    private static void validateNumbersSize(List<Integer> winningNumbers) {
        if (winningNumbers.size() != LOTTO_TICKET_SIZE) {
            throw new IllegalArgumentException(INVALID_WINNING_NUMBERS_EXCEPTION);
        }
    }

    private static void validateNumbersDuplication(List<Integer> winningNumbers) {
        if (winningNumbers.size() != winningNumbers.stream().distinct().count()) {
            throw new IllegalArgumentException(NUMBER_DUPLICATION_NOT_ALLOWED_EXCEPTION);
        }
    }
}
