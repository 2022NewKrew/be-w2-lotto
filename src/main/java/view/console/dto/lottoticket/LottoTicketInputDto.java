package view.console.dto.lottoticket;

import domain.LottoTicket;
import domain.lottonumber.LottoNumber;

import java.util.List;

public class LottoTicketInputDto {

    private final List<LottoNumber> lottoNumbers;

    public LottoTicketInputDto(List<LottoNumber> lottoNumbers) {
        this.lottoNumbers = lottoNumbers;
    }

    public LottoTicket toLottoTicket() {
        return new LottoTicket(lottoNumbers);
    }

}
