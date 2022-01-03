package domain;

import java.util.List;

public class LottoTicket {

    private final List<LottoNumber> lottoNumbers;

    public LottoTicket(List<LottoNumber> lottoNumber) {
        lottoNumbers = lottoNumber;
    }

    public int getNumberOfMatchedNumber(List<LottoNumber> winningNumbers) {
        return (int) lottoNumbers.stream()
                .filter(winningNumbers::contains)
                .count();
    }

    public void print() {
        System.out.println(lottoNumbers.toString());
    }
}
