package step2.domain.model;

import step2.exceptions.DuplicatedNumberException;

import static step2.utils.CommonConstants.*;

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
        return lotto.contains(bonusNumber);
    }
}
