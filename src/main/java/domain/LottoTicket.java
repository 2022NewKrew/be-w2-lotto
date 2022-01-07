package domain;

import constant.Constants;
import domain.lottonumber.LottoNumber;
import domain.dto.LottoMatchResultDto;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class LottoTicket {

    private final List<LottoNumber> lottoNumbers;

    public LottoTicket(List<LottoNumber> lottoNumber) {
        lottoNumbers = lottoNumber;
        validateLottoTicketSize();
    }

    private void validateLottoTicketSize() {
        if (lottoNumbers.size() != Constants.SIZE_OF_LOTTO_TICKET) {
            throw new IllegalStateException("로또 티켓은 " + Constants.SIZE_OF_LOTTO_TICKET + "개의 로또 번호만 입력할수 있습니다.");
        }
    }

    public Optional<LottoResult> match(List<LottoNumber> winningNumbers) {
        LottoMatchResultDto lottoMatchResultDto = getNumberOfMatchedNumber(winningNumbers);
        return LottoResult.getLottoResultType(lottoMatchResultDto);
    }

    public LottoMatchResultDto getNumberOfMatchedNumber(List<LottoNumber> winningNumbers) {
        List<LottoNumber> matchedNumbers = winningNumbers.stream()
                .filter(lottoNumbers::contains)
                .collect(Collectors.toList());

        return new LottoMatchResultDto(matchedNumbers);
    }

    @Override
    public String toString() {
        return lottoNumbers.toString();
    }
}
