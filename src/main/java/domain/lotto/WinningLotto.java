package domain.lotto;

import java.util.List;

public class WinningLotto {

    private final List<Integer> winningLottoNumbers;
    private final int bonusNumber;

    public WinningLotto(List<Integer> winningLottoNumbers, int bonusNumber) {
        this.winningLottoNumbers = winningLottoNumbers;
        this.bonusNumber = bonusNumber;
    }

    public boolean isContainsNumber(int number) {
        return winningLottoNumbers.contains(number);
    }

    public int getBonusNumber() {
        return bonusNumber;
    }
}
