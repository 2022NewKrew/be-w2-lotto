package validate;

import java.util.List;

public class WinNumbersValidator extends Validator{
    @Override
    protected boolean supports(Object param) {
        if(!(param instanceof List)){
            return false;
        }

        List<?> list = (List<?>)param;
        if(!list.stream().allMatch(value -> value instanceof Integer)){
            return false;
        }

        return true;
    }

    @Override
    protected void validateValue(Object param) throws IllegalArgumentException {
        List<Integer> numbers = (List<Integer>) param;
        for(Integer number : numbers){
            validateOneValue(number);
        }
    }

    private void validateOneValue(Integer number) throws IllegalArgumentException{
        if(number <= 0 || number > 45){
            throw new IllegalArgumentException("당첨번호는 1이상 45 이하입니다.");
        }
    }
}
