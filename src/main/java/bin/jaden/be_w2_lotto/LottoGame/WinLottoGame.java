package bin.jaden.be_w2_lotto.LottoGame;

import java.util.List;

public class WinLottoGame extends LottoGame {
    private final int bonusNumber;

    public WinLottoGame(List<Integer> numbers, int bonusNumber) {
        super.setNumbers(numbers);
        this.bonusNumber = bonusNumber;
    }

    public int getBonusNumber() {
        return bonusNumber;
    }
}
