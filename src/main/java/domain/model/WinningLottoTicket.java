package domain.model;

import java.util.List;

public class WinningLottoTicket {

    private final List<Integer> lottoNumbers;

    private final int bonusNumber;

    public WinningLottoTicket(List<Integer> lottoNumbers, int bonusNumber) {
        this.lottoNumbers = lottoNumbers;
        this.bonusNumber = bonusNumber;
    }

    public boolean contains(Integer number) {
        return lottoNumbers.contains(number);
    }

    public boolean matchBonus(Integer number) {
        return bonusNumber == number.intValue();
    }

    public List<Integer> getLottoNumbers() {
        return lottoNumbers;
    }

    public int getBonusNumber() {
        return bonusNumber;
    }
}
