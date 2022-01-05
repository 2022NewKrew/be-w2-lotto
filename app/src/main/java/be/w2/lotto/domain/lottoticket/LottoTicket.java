package be.w2.lotto.domain.lottoticket;

import be.w2.lotto.domain.lottonumber.LottoNumber;

import java.util.List;
import java.util.stream.Collectors;

import static be.w2.lotto.common.exception.ExceptionMessages.INVALID_WINNING_NUMBERS_EXCEPTION;
import static be.w2.lotto.common.exception.ExceptionMessages.NUMBERS_DUPLICATION_NOT_ALLOWED_EXCEPTION;
import static be.w2.lotto.domain.lottoticket.LottoTickets.LOTTO_TICKET_SIZE;

public abstract class LottoTicket {
    private final List<LottoNumber> lottoNumbers;

    public LottoTicket(List<LottoNumber> lottoNumbers) {
        this.lottoNumbers = lottoNumbers;
    }

    public List<Integer> getLottoNumbers() {
        return this.lottoNumbers.stream()
                .map(LottoNumber::getNumber)
                .collect(Collectors.toList());
    }

    protected static void validateLottoNumbers(List<Integer> winningNumbers) throws IllegalArgumentException {
        validateNumbersSize(winningNumbers);
        validateNumbersDuplication(winningNumbers);
    }

    private static void validateNumbersDuplication(List<Integer> numbers) throws IllegalArgumentException {
        if (numbers.size() != numbers.stream().distinct().count()) {
            throw new IllegalArgumentException(NUMBERS_DUPLICATION_NOT_ALLOWED_EXCEPTION);
        }
    }

    private static void validateNumbersSize(List<Integer> winningNumbers) throws IllegalArgumentException {
        if (winningNumbers.size() != LOTTO_TICKET_SIZE) {
            throw new IllegalArgumentException(INVALID_WINNING_NUMBERS_EXCEPTION);
        }
    }

    public static final int LOTTO_TICKET_PRICE = 1000;
}
