package be.w2.lotto.domain.lottoticket;

import be.w2.lotto.common.exception.InvalidLottoTicketSizeException;
import be.w2.lotto.common.exception.LottoNumberDuplicationNotAllowedException;
import be.w2.lotto.domain.lottonumber.LottoNumber;

import java.util.List;
import java.util.stream.Collectors;

public abstract class LottoTicket {
    private final List<LottoNumber> lottoNumbers;

    protected LottoTicket(List<LottoNumber> lottoNumbers) {
        this.lottoNumbers = lottoNumbers;
    }

    public List<Integer> getLottoNumbers() {
        return this.lottoNumbers.stream()
                .map(LottoNumber::getNumber)
                .collect(Collectors.toList());
    }

    protected static void validateLottoNumbers(List<Integer> lottoNumbers) throws IllegalArgumentException {
        validateTicketSize(lottoNumbers);
        validateNumbersDuplication(lottoNumbers);
    }

    private static void validateNumbersDuplication(List<Integer> numbers) throws IllegalArgumentException {
        if (numbers.size() != numbers.stream().distinct().count()) {
            throw new LottoNumberDuplicationNotAllowedException();
        }
    }

    private static void validateTicketSize(List<Integer> lottoNumbers) throws IllegalArgumentException {
        if (lottoNumbers.size() != LOTTO_TICKET_SIZE) {
            throw new InvalidLottoTicketSizeException();
        }
    }

    public static final int LOTTO_TICKET_SIZE = 6;
    public static final int LOTTO_TICKET_PRICE = 1000;
}
