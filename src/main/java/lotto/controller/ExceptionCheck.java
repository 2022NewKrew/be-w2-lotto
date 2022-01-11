package lotto.controller;

import lotto.VO.InvalidFormatException;
import lotto.model.Lotto;

import java.util.List;
import java.util.Set;

public class ExceptionCheck {

    public static void validateLottoNumbers(Set<Integer> numbers) throws InvalidFormatException {
        if (numbers.size() != Lotto.N_NUMBERS) {
            throw new InvalidFormatException("6개의 숫자를 입력하세요.");
        }

        for (Integer number : numbers) {
            validateLottoNumber(number);
        }
    }

    public static void validateLottoNumber(int number) throws InvalidFormatException {
        if (number < Lotto.MIN_NUMBER || number > Lotto.MAX_NUMBER) {
            throw new InvalidFormatException(Lotto.MIN_NUMBER + " 에서 " + Lotto.MAX_NUMBER + " 사이의 값을 입력하세요");
        }
    }

    public static void validateMoneyNumber(int number) throws InvalidFormatException {
        if (number % 100 != 0) {
            throw new InvalidFormatException("최소 100원 단위로 입력하세요.");
        }
    }

    public static void validatePositiveNumber(int number) throws InvalidFormatException {
        if (number < 0) {
            throw new InvalidFormatException(number + "값은 양수가 아닙니다.");
        }
    }
}
