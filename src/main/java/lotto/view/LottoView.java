package lotto.view;

import lotto.model.Lotto;

import java.util.List;

public abstract class LottoView {
    public abstract void start();

    public List<Integer> validatedLottoNumbers(List<Integer> numbers) throws IllegalArgumentException {
        if (numbers.size() != Lotto.N_NUMBERS) {
            throw new IllegalArgumentException("6개의 숫자를 입력하세요.");
        }
        return numbers;
    }

    public int validatedLottoNumber(int number) throws IllegalArgumentException {
        if (number < Lotto.MIN_NUMBER || number > Lotto.MAX_NUMBER) {
            throw new IllegalArgumentException(Lotto.MIN_NUMBER + " 에서 " + Lotto.MAX_NUMBER + " 사이의 값을 입력하세요");
        }
        return number;
    }

    public int validatedMoneyNumber(int number) throws IllegalArgumentException {
        if (number % 100 != 0) {
            throw new IllegalArgumentException("최소 100원 단위로 입력하세요.");
        }
        return validatedPositiveNumber(number);
    }

    public int validatedPositiveNumber(int number) throws IllegalArgumentException {
        if (number < 0) {
            throw new IllegalArgumentException(number + "값은 양수가 아닙니다.");
        }
        return number;
    }
}
