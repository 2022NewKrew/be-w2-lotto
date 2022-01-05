package be.w2.lotto.domain.lottoticket;

import be.w2.lotto.domain.lottonumber.LottoNumber;

import java.util.List;
import java.util.stream.Collectors;

public class WinningLottoTicket extends LottoTicket {
    private WinningLottoTicket(List<LottoNumber> winningNumbers) {
        super(winningNumbers);
    }

    public static WinningLottoTicket valueOf(List<Integer> winningNumbers) {
        validateLottoNumbers(winningNumbers);

        List<LottoNumber> winningLottoNumbers = winningNumbers.stream()
                .map(LottoNumber::from)
                .collect(Collectors.toList());

        return new WinningLottoTicket(winningLottoNumbers);
    }

    public boolean contains(int bonusNumber) {
        return this.getLottoNumbers().contains(bonusNumber);
    }
}
