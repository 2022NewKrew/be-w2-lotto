package domain.model.ticket;

import domain.model.LottoNumber;

import java.util.List;

public class WinningLottoTicket extends CommonLottoTicket {

    private final int bonusNumber;

    public WinningLottoTicket(List<Integer> lottoNumbers, int bonusNumber) {
        super(lottoNumbers);
        this.bonusNumber = bonusNumber;
    }

    public boolean matchBonus(LottoNumber number) {
        return bonusNumber == number.getNumber();
    }

    public int getBonusNumber() {
        return bonusNumber;
    }

}
