package lotto.validator;

import static lotto.controller.LottoGame.TICKET_PRICE;
import static lotto.domain.Lotto.LOTTO_NUMBER_END;
import static lotto.domain.Lotto.LOTTO_NUMBER_SIZE;
import static lotto.domain.Lotto.LOTTO_NUMBER_START;

import java.util.HashSet;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Set;
import lotto.dto.LottoDTO;

public class LottoGameInputValidator {

    private static final String PRICE_ERROR_MESSAGE = "로또 한 장 당 %d원 입니다."
        + "남은 금액 %d원은 지갑에 다시 넣어드리겠습니다.";

    public int purchasePriceValidate(int purchasePrice) {
        int remainingAmount = purchasePrice % TICKET_PRICE;
        if (remainingAmount > 0) {
            System.err.println(String.format(PRICE_ERROR_MESSAGE, TICKET_PRICE, remainingAmount));
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
        if (winningNumbers.size() != LOTTO_NUMBER_SIZE) {
            throw new InputMismatchException("당첨 번호는 6개만 입력 가능합니다.");
        }
    }

    private void validateWinningNumberDuplicate(List<Integer> winningNumbers) {
        Set<Integer> numberSet = new HashSet<>(winningNumbers);
        if (numberSet.size() != LOTTO_NUMBER_SIZE) {
            throw new InputMismatchException("당첨 번호는 중복될 수 없습니다.");
        }
    }

    private void validateWinningNumberRange(int number) {
        if (number < LOTTO_NUMBER_START || number > LOTTO_NUMBER_END) {
            throw new InputMismatchException("로또 번호는 1 ~ 45 내에서만 입력 가능합니다.");
        }
    }
}
