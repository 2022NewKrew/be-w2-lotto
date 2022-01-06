package lotto.domain.model;

import lotto.domain.message.ExceptionMessage;

import java.util.List;

public class WinningLotto {
    private int bonusBall;
    private Lotto lotto;

    public WinningLotto(int bonusBall, List<Integer> lottoNumbers) {
        validateBonusBall(bonusBall, lottoNumbers);
        this.bonusBall = bonusBall;
        this.lotto = new Lotto(lottoNumbers);
    }

    private static void validateBonusBall(int bonusBall, List<Integer> lottoNumbers) {
        if (lottoNumbers.contains(bonusBall)) {
            throw new IllegalArgumentException(ExceptionMessage.ERROR_DUPLICATE_BONUS_BALL.getMessage());
        }
    }

    public int getMatchNumberCount(List<Integer> lottoNumbers) {
        return (int) lottoNumbers.stream()
                .filter(lotto.getLottoNumbers()::contains)
                .count();
    }

    public boolean isContainBonusBall(List<Integer> lottoNumbers) {
        return lottoNumbers.contains(bonusBall);
    }
}
