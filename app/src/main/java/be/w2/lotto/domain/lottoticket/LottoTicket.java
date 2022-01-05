package be.w2.lotto.domain.lottoticket;

import be.w2.lotto.domain.lottonumber.LottoNumber;

import java.util.List;
import java.util.stream.Collectors;

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

    public static final int LOTTO_TICKET_PRICE = 1000;
}
