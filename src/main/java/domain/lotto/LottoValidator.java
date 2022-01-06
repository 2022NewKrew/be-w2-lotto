package domain.lotto;

import java.util.List;

import static util.LottoConst.*;

public class LottoValidator {

    public static void validatePositiveNumber(int number) {
        if (number < 0) {
            throw new IllegalArgumentException("[에러] 음수 값을 입력할 수 없습니다.");
        }
    }

    public static void validateInputMoney(int money) {
        if (money < LOTTO_PRICE) {
            throw new IllegalArgumentException(
                    String.format("[에러] 구입 금액은 반드시 %s원 이상이어야 합니다.", LOTTO_PRICE)
            );
        }
    }

    public static void validateNumOfPurchaseManually(int money, int numOfPurchaseManually) {
        if (money < numOfPurchaseManually * LOTTO_PRICE) {
            throw new IllegalArgumentException("[에러] 입력한 금액보다 많은 로또를 구매할 수 없습니다.");
        }
    }

    public static void validateInputNumbers(List<Integer> numbers) {
        for (Integer number : numbers) {
            validateLottoNumber(number);
        }
        if (numbers.size() != MAX_LOTTO_COUNT) {
            throw new IllegalArgumentException("[에러] 로또 번호는 반드시 6개를 입력해야 합니다.");
        }
        long distinctCount = numbers.stream().distinct().count();
        if (distinctCount != MAX_LOTTO_COUNT) {
            throw new IllegalArgumentException("[에러] 로또 번호는 중복되는 숫자가 없어야 합니다.");
        }
    }

    public static void validateBonusLottoNumber(List<Integer> inputWinningNumbers, int bonusNumber) {
        validateLottoNumber(bonusNumber);
        if (inputWinningNumbers.contains(bonusNumber)) {
            throw new IllegalArgumentException("[에러] 보너스 번호는 당첨 번호와 같을 수 없습니다.");
        }
    }

    public static void validateLottoNumber(int number) {
        if (!LOTTO_NUMBERS.contains(number)) {
            throw new IllegalArgumentException(
                    String.format("[에러] 로또 번호는 %s ~ %s 사이의 숫자를 입력해야 합니다.",
                            MIN_LOTTO_NUMBER, MAX_LOTTO_NUMBER)
            );
        }
    }
}
