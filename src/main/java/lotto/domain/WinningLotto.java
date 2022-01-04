package lotto.domain;

public class WinningLotto {

    private static final String BONUS_ERROR_MESSAGE = "당첨 번호와 보너스 번호는 중복될 수 없습니다.";

    private final Lotto lotto;
    private final int bonusNumber;

    public WinningLotto(Lotto lotto, int bonusNumber) {
        if (validateBonusNumber(lotto, bonusNumber)) {
            throw new IllegalArgumentException(BONUS_ERROR_MESSAGE);
        }
        this.lotto = lotto;
        this.bonusNumber = bonusNumber;
    }

    public int getBonusNumber() {
        return bonusNumber;
    }

    public int ticketMatchCount(Lotto ticket) {
        return (int) lotto.getLottoNumbers().stream()
            .filter(ticket::hasNumber)
            .count();
    }

    private boolean validateBonusNumber(Lotto lotto, int bonusNumber) {
        return lotto.hasNumber(bonusNumber);
    }
}
