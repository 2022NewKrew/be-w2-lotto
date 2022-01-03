package validate;

import domain.Lotto;

import java.util.List;

public class WinNumbersValidator extends Validator {
    @Override
    protected boolean supports(Object value) {
        if(!(value instanceof List)){
            return false;
        }

        if(!(((List<?>) value).stream().allMatch(val -> val instanceof Integer))){
            return false;
        }

        return true;
    }

    @Override
    public void validateValue(Object value) {
        List<Integer> numbers = (List<Integer>) value;
        validateNumberOfValues(numbers.size());
        for(Integer number : numbers){
            validateOneValue(number);
        }
    }

    private void validateNumberOfValues(int numberOfValue){
        if(numberOfValue != Lotto.NUMBER_OF_WRITE_NUMBER){
            throw new IllegalArgumentException(
                    "당첨번호의 갯수는 ".concat(String.valueOf(Lotto.NUMBER_OF_WRITE_NUMBER)).concat("여야 합니다."));
        }
    }

    private void validateOneValue(Integer number) throws IllegalArgumentException{
        if(number <= 0 || number > 45){
            throw new IllegalArgumentException("당첨번호는 1이상 45 이하입니다.");
        }
    }
}
