package domain.lotto;

import java.util.List;

public class WinningLotto {

    private final List<Integer> winningLottoNumbers;
    private final int bonusNumber;

    public WinningLotto(List<Integer> winningLottoNumbers, int bonusNumber) {
        validateBonusLottoNumber(winningLottoNumbers, bonusNumber);
        this.winningLottoNumbers = winningLottoNumbers;
        this.bonusNumber = bonusNumber;
    }

    private void validateBonusLottoNumber(List<Integer> inputWinningNumbers, int bonusNumber) {
        if (inputWinningNumbers.contains(bonusNumber)) {
            throw new IllegalArgumentException("[에러] 보너스 번호는 당첨 번호와 같을 수 없습니다.");
        }
    }

    public boolean isContainsNumber(int number) {
        return winningLottoNumbers.contains(number);
    }

    public int getBonusNumber() {
        return bonusNumber;
    }
}
