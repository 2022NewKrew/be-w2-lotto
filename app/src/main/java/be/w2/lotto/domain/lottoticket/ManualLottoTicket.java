package be.w2.lotto.domain.lottoticket;

import be.w2.lotto.domain.lottonumber.LottoNumber;

import java.util.List;
import java.util.stream.Collectors;

public class ManualLottoTicket extends LottoTicket {
    private ManualLottoTicket(List<LottoNumber> lottoNumbers) {
        super(lottoNumbers);
    }

    public static ManualLottoTicket valueOf(List<Integer> lottoNumbersInput) {
        validateLottoNumbers(lottoNumbersInput);

        List<LottoNumber> lottoNumber = lottoNumbersInput.stream()
                .map(LottoNumber::from)
                .collect(Collectors.toList());

        return new ManualLottoTicket(lottoNumber);
    }

}
