package domain;

import domain.lottonumber.LottoNumber;

import java.util.List;
import java.util.stream.Collectors;

public class LottoTicket {

    private final List<LottoNumber> lottoNumbers;

    public LottoTicket(List<LottoNumber> lottoNumber) {
        lottoNumbers = lottoNumber;
    }

    public LottoMatchResultDto getNumberOfMatchedNumber(List<LottoNumber> winningNumbers) {
        List<LottoNumber> matchedNumbers = winningNumbers.stream()
                .filter(lottoNumbers::contains)
                .collect(Collectors.toList());

        return new LottoMatchResultDto(matchedNumbers);

    }

    public void print() {
        System.out.println(lottoNumbers.toString());
    }
}
