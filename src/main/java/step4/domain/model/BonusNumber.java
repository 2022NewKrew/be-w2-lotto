package step4.domain.model;

import step4.exceptions.DuplicatedNumberException;

import static step4.utils.CommonConstants.END_LOTTO_NUM;
import static step4.utils.CommonConstants.START_LOTTO_NUM;

public class BonusNumber {
    private final int bonusNumber;

    public BonusNumber(int bonusNumber, Result result) {
        checkBonusNumber(bonusNumber, result);
        this.bonusNumber = bonusNumber;
    }

    private static void checkBonusNumber(int bonusNumber, Result result) {
        if (bonusNumber < START_LOTTO_NUM || bonusNumber > END_LOTTO_NUM) {
            throw new NumberFormatException("잘못된 번호가 입력되었습니다.");
        }

        if (result.contains(bonusNumber)) {
            throw new DuplicatedNumberException("중복된 번호가 입력되었습니다.");
        }
    }

    public boolean matchWithLotto(Lotto lotto) {
        return lotto.contains(this.bonusNumber);
    }
}
