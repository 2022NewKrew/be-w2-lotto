package domain;

import java.util.List;

public class WinningLotto extends Lotto{

    private final List<Integer> lottoNumbers;
    private final int bonusNumber;

    public WinningLotto(String inputWinningNumbers, int bonusNumber){
        this.lottoNumbers = splitLottoNumbers(inputWinningNumbers);
        validateBonusNumber(bonusNumber);
        this.bonusNumber = bonusNumber;
    }

    private void validateBonusNumber(int bonusNumber) {
        if (bonusNumber < LOTTO_MIN_NUMBER || bonusNumber > LOTTO_MAX_NUMBER) {
            throw new IllegalArgumentException("보너스 볼 번호는 1~45여야 합니다.");
        }
    }

    public List<Integer> getLottoNumbers() {
        return lottoNumbers;
    }

    public int getBonusNumber() {
        return bonusNumber;
    }
}
