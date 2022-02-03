package domain.validator;

import exception.LottoException;

import java.util.HashSet;
import java.util.Set;

public class LottoNumberValidator extends IntegerValidator implements Validator {
    @Override
    public void validate(String input) throws LottoException {
        Set<Integer> numberSet = new HashSet<>();

        String[] inputs = input.replace(" ", "").split(",");
        for (String i : inputs) {
            isNumeric(i);
            Integer num = Integer.parseInt(i);
            validLottoRange(num);
            numberSet.add(num);
        }

        if (numberSet.size() != 6) {
            throw new LottoException("서로 다른 6개의 로또 번호를 입력하세요.");
        }
    }

    private void validLottoRange(Integer num) throws LottoException {
        if (num < 1 || num > 45) {
            throw new LottoException("1~45 범위의 로또 번호를 입력하세요.");
        }
    }
}
