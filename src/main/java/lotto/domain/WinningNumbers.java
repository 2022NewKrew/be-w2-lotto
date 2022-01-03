package lotto.domain;

public class WinningNumbers {
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
}
