package lotto.util.input;

import lotto.util.Validator;

public class InputBudget implements ConsoleInputInterface<Long>{

    @Override
    public String getMessage() {
        return "구매금액을 입력해 주세요.";
    }

    @Override
    public Long convert(String inputString) {
        Long budget = Long.parseLong(inputString);
        Validator.checkNaturalNumber((long)budget);
        return budget;
    }
}
