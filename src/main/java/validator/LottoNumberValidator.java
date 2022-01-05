package validator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import constants.LottoRule;
import exception.LottoException;

public class LottoNumberValidator implements ValidatorInterface {
    @Override
    public void validateData(String input) throws LottoException {
        List<String> numbers = new ArrayList<>(Arrays.asList(input.split(",")));

        checkDuplicate(numbers);
        checkAmount(numbers);
        checkValidNumbers(numbers);
    }

    private void checkDuplicate(List<String> numbers) throws LottoException {
        boolean freq = numbers.stream()
                .noneMatch(number -> Collections.frequency(numbers, number) > 1);
        if (!freq) {
            throw new LottoException("중복되는 값이 있습니다.");
        }
    }

    private void checkAmount(List<String> numbers) throws LottoException {
        if (numbers.size() != LottoRule.LOTTO_NUMBER_COUNT) {
            throw new LottoException("로또 번호는 숫자 6개로 입력해주세요.");
        }
    }

    private void checkValidNumbers(List<String> numbers) throws LottoException {
        for (String number : numbers) {
            checkValidNumber(number);
        }
    }

    private void checkValidNumber(String number) throws LottoException {
        if (!number.matches(LottoRule.IS_NUMERIC)) {
            throw new LottoException("정수를 입력해주세요.");
        }
        if (Integer.parseInt(number) < LottoRule.MIN_LOTTO_NUMBER ||
                Integer.parseInt(number) > LottoRule.MAX_LOTTO_NUMBER) {
            throw new LottoException("1부터 45사이의 정수로 입력해주세요.");
        }
    }
}
