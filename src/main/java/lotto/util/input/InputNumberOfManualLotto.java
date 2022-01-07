package lotto.util.input;

import lotto.util.Validator;

public class InputNumberOfManualLotto implements ConsoleInputInterface<Integer>{

    @Override
    public String getMessage() {
        return "수동으로 구매할 로또 수를 입력해 주세요.";
    }
    //TODO - budget보다 더 많이 입력했는지 validation 따로 해줘야함.
    @Override
    public Integer convert(String inputString) {
        Integer numberOfManualToBuy = Integer.parseInt(inputString);
        Validator.checkNaturalNumber(numberOfManualToBuy);
        return numberOfManualToBuy;
    }
}
