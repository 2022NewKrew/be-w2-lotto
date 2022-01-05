package be.w2.lotto.domain.lottoticket;

import be.w2.lotto.domain.lottonumber.LottoNumber;

import java.util.List;

public class AutoLottoTicket extends LottoTicket {
    public AutoLottoTicket(List<LottoNumber> lottoNumbers) {
        super(lottoNumbers);
    }

    public static AutoLottoTicket from(List<LottoNumber> lottoNumbers) {
        return new AutoLottoTicket(lottoNumbers);
    }
}
