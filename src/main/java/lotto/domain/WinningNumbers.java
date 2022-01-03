package lotto.domain;

import java.util.Iterator;

public class WinningNumbers implements Iterable<LottoNumber> {
    private final LottoNumbers winningNumbers;

    private WinningNumbers(LottoNumbers winningNumbers) {
        this.winningNumbers = winningNumbers;
    }

    public static WinningNumbers from(LottoNumbers winningNumbers) {
        return new WinningNumbers(winningNumbers);
    }

    public LottoNumbers getWinningNumbers() {
        return winningNumbers;
    }

    @Override
    public Iterator<LottoNumber> iterator() {
        return winningNumbers.getLottoNumbers().iterator();
    }
}
