package validator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import constants.LottoRule;

public class LottoNumberValidator implements ValidatorInterface{
    @Override
    public boolean validateData(String input) {
        List<String> numbers = new ArrayList<>(Arrays.asList(input.split(",")));
        return checkAmount(numbers) && checkValidNumbers(numbers);
    }

    private boolean checkAmount(List<String> numbers){
        if(numbers.size() == LottoRule.LOTTO_NUMBER_COUNT)
            return true;
        System.out.println("로또 번호는 숫자 6개로 입력해주세요.");
        return false;
    }

    private boolean checkValidNumbers(List<String> numbers){
        return numbers.stream()
                .allMatch(this::checkValidNumber);
    }

    private boolean checkValidNumber(String number){
        if(!number.matches(LottoRule.IS_NUMERIC)){
            System.out.println("정수를 입력해주세요.");
            return false;
        }
        if(Integer.parseInt(number) < LottoRule.MIN_LOTTO_NUMBER ||
                Integer.parseInt(number) > LottoRule.MAX_LOTTO_NUMBER){
            System.out.println("1부터 45사이의 정수로 입력해주세요.");
            return false;
        }
        return true;
    }
}
