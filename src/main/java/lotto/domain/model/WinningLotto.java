package lotto.domain.model;

public class WinningLotto {

    private static final String BONUS_ERROR_MESSAGE = "당첨 번호와 보너스 번호는 중복될 수 없습니다.";

    private final Lotto lotto;
    private final LottoNumber bonusNumber;

    public static WinningLotto of(Lotto lotto, LottoNumber bonusNumber) {
        return new WinningLotto(lotto, bonusNumber);
    }

    private WinningLotto(Lotto lotto, LottoNumber bonusNumber) {
        if (!validateBonusNumber(lotto, bonusNumber)) {
            throw new IllegalArgumentException(BONUS_ERROR_MESSAGE);
        }
        this.lotto = lotto;
        this.bonusNumber = bonusNumber;
    }

    private boolean validateBonusNumber(Lotto lotto, LottoNumber bonusNumber) {
        return !lotto.hasNumber(bonusNumber);
    }
    
    public int ticketMatchCount(Lotto ticket) {
        return lotto.calculateMatchCountWith(ticket);
    }

    public boolean isTicketHasBonusNumber(Lotto ticket) {
        return ticket.hasNumber(bonusNumber);
    }
}
