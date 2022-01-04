package lotto.domain;

import java.util.Iterator;

public class WinningNumbers implements Iterable<LottoNumber> {
    private final LottoNumbers winningNumbers;
    private final LottoNumber bonusNumber;

    private WinningNumbers(LottoNumbers winningNumbers, LottoNumber bonusNumber) {
        this.winningNumbers = winningNumbers;
        this.bonusNumber = bonusNumber;
    }

    public static WinningNumbers from(LottoNumbers winningNumbers, LottoNumber bonusNumber) {
        if (winningNumbers.contains(bonusNumber)) {
            throw new IllegalArgumentException("보너스 볼은 당첨 번호와 중복될 수 없습니다.");
        }
        return new WinningNumbers(winningNumbers, bonusNumber);
    }

    public LottoNumbers getWinningNumbers() {
        return winningNumbers;
    }

    public LottoNumber getBonusNumber() {
        return bonusNumber;
    }

    @Override
    public Iterator<LottoNumber> iterator() {
        return winningNumbers.getLottoNumbers().iterator();
    }
}
