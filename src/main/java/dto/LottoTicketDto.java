package dto;

import domain.lottonumber.LottoNumber;

import java.util.List;

public class LottoTicketDto {
    private final List<LottoNumber> lottoNumbers;

    public LottoTicketDto(List<LottoNumber> lottoNumbers) {
        this.lottoNumbers = lottoNumbers;
    }
}
