package validation;

import domain.Lotto;
import domain.Number;
import exception.InvalidInputException;
import java.util.ArrayList;
import java.util.List;
import static utils.Symbol.*;

public class Validator {

    public void isValidNumber(int num) throws InvalidInputException {
        if (!(MIN_LOTTO_RANGE <= num && num <= MAX_LOTTO_RANGE)) {
            throw new InvalidInputException(INVALID_NUMBER_RANGE);
        }
    }

    private void isDistinct(Lotto winningLotto, int bonusNumber) throws InvalidInputException {
        ArrayList<Integer> arrayList = new ArrayList<>();
        for (Number number : winningLotto.getNumberList()) {
            int num = number.getNum();
            arrayList.add(num);
        }
        if (arrayList.contains(bonusNumber)) {
            throw new InvalidInputException(INVALID_DUPLICATION_BONUSNUM);
        }
    }

    public void isValidBonusNumber(Lotto winningLotto, int bonusNumber) throws InvalidInputException {
        isValidNumber(bonusNumber);
        isDistinct(winningLotto, bonusNumber);
    }


    public void isValidNumberList(List<Number> numberList) throws InvalidInputException {
        if (!isLengthSix(numberList)) {
            throw new InvalidInputException(INVALID_LOTTO_FORMAT);
        }
        for (Number number : numberList) {
            isValidNumber(number.getNum());
        }
    }

    public boolean isLengthSix(List<Number> numberList) {
        return numberList.size() == 6;
    }

    public void isValidMoney(int purchaseAmount) throws InvalidInputException {
        if (!(purchaseAmount > 0 && purchaseAmount % LOTTO_PRICE == 0)) {
            throw new InvalidInputException(INVALID_MONEY_MESSAGE);
        }
    }

    public void isValidMannualCount(int purchaseAmount, int manualLottoCount) throws InvalidInputException {
        if (purchaseAmount / LOTTO_PRICE < manualLottoCount) {
            throw new InvalidInputException(INVALID_MANNUAL_LOTTOCOUNT);
        }
    }
}
