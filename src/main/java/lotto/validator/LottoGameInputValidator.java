package lotto.validator;

import static lotto.domain.Lotto.LOTTO_NUMBER_END;

import java.util.HashSet;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Set;
import lotto.domain.Lotto;
import lotto.dto.LottoDTO;

public class LottoGameInputValidator {

    private static final int LOTTO_NUMBERS_SIZE = 6;

    public int purchasePriceValidate(int purchasePrice, int ticketPrice) {
        int remainingAmount = purchasePrice % ticketPrice;
        if (remainingAmount > 0) {
            System.err.println(
                "로또 한 장 당 1000원 입니다. 남은 금액 " + remainingAmount + "원은 지갑에 다시 넣어드리겠습니다.");
            return purchasePrice - remainingAmount;
        }
        return purchasePrice;
    }

    public void winningNumbersValidate(LottoDTO winningLotto) {
        validateWinningNumberSize(winningLotto.getLottoNumbers());
        validateWinningNumberDuplicate(winningLotto.getLottoNumbers());
        winningLotto.getLottoNumbers().forEach(this::validateWinningNumberRange);
    }

    private void validateWinningNumberSize(List<Integer> winningNumbers) {
        if (winningNumbers.size() != LOTTO_NUMBERS_SIZE) {
            throw new InputMismatchException("당첨 번호는 6개만 입력 가능합니다.");
        }
    }

    private void validateWinningNumberDuplicate(List<Integer> winningNumbers) {
        Set<Integer> numberSet = new HashSet<>(winningNumbers);
        if (numberSet.size() != LOTTO_NUMBERS_SIZE) {
            throw new InputMismatchException("당첨 번호는 중복될 수 없습니다.");
        }
    }

    private void validateWinningNumberRange(int number) {
        if (number < Lotto.LOTTO_NUMBER_START || number > LOTTO_NUMBER_END) {
            throw new InputMismatchException("로또 번호는 1 ~ 45 내에서만 입력 가능합니다.");
        }
    }
}
