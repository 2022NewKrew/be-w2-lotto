package lotto.view;


import lotto.VO.InvalidFormatException;
import lotto.domain.LottoApp;
import lotto.model.Lotto;

import java.util.List;

public abstract class LottoView {
    protected LottoApp app;

    public LottoView(){
        app = new LottoApp();
    }

    public abstract void start();

    public List<Integer> validatedLottoNumbers(List<Integer> numbers) throws InvalidFormatException {
        if (numbers.size() != Lotto.N_NUMBERS) {
            throw new InvalidFormatException("6개의 숫자를 입력하세요.");
        }
        return numbers;
    }

    public int validatedLottoNumber(int number) throws InvalidFormatException {
        if (number < Lotto.MIN_NUMBER || number > Lotto.MAX_NUMBER) {
            throw new InvalidFormatException(Lotto.MIN_NUMBER + " 에서 " + Lotto.MAX_NUMBER + " 사이의 값을 입력하세요");
        }
        return number;
    }

    public int validatedMoneyNumber(int number) throws InvalidFormatException {
        if (number % 100 != 0) {
            throw new InvalidFormatException("최소 100원 단위로 입력하세요.");
        }
        return validatedPositiveNumber(number);
    }

    public int validatedPositiveNumber(int number) throws InvalidFormatException {
        if (number < 0) {
            throw new InvalidFormatException(number + "값은 양수가 아닙니다.");
        }
        return number;
    }
}

