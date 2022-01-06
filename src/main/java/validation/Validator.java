package validation;

import domain.Lotto;
import domain.Number;

import java.util.ArrayList;
import java.util.List;

import static utils.Symbol.*;

public class Validator {

    public void isValidNumber(int num) {
        if (!(MIN_LOTTO_RANGE <= num && num <= MAX_LOTTO_RANGE)) {
            throw new IllegalArgumentException(INVALID_NUMBER_RANGE);
        }
    }

    private void isDistinct(Lotto winningLotto, int bonusNumber) {
        List<Integer> list = new ArrayList<>();
        for (Number number : winningLotto.getNumberList()) {
            int num = number.getNum();
            list.add(num);
        }
        if (list.contains(bonusNumber)) {
            throw new IllegalArgumentException(INVALID_DUPLICATION_BONUSNUM);
        }
    }

    public void isValidBonusNumber(Lotto winningLotto, int bonusNumber) {
        isValidNumber(bonusNumber);
        isDistinct(winningLotto, bonusNumber);
    }


    public void isValidNumberList(List<Number> numberList) {
        if (!isLengthSix(numberList)) {
            throw new IllegalArgumentException(INVALID_DUPLICATION_BONUSNUM);
        }
        for (Number number : numberList) {
            isValidNumber(number.getNum());
        }
    }

    public boolean isLengthSix(List<Number> numberList) {
        return numberList.size() == 6;
    }

    public void isValidMoney(int purchaseAmount) {
        if (!(purchaseAmount > 0 && purchaseAmount % LOTTO_PRICE == 0)) {
            throw new IllegalArgumentException(INVALID_MONEY_MESSAGE);
        }
    }

    public void isValidMannualCount(int purchaseAmount, int manualLottoCount) {
        if (purchaseAmount / LOTTO_PRICE < manualLottoCount) {
            throw new IllegalArgumentException(INVALID_MANNUAL_LOTTOCOUNT);
        }
    }
}
