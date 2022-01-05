package lotto.util.input;


import lotto.util.Validator;

public class InputBonusNumber implements ConsoleInputInterface<Integer> {
    @Override
    public String getMessage() {
        return "보너스 볼을 입력해 주세요.";
    }

    //TODO - winningNumbers와 중복 validation 따로 해야하는데 어떻게 입력받을때 한꺼번에 할 수 있을까?
    @Override
    public Integer convert(String inputString) {
        Integer bonusNumber = Integer.parseInt(inputString);

        return bonusNumber;
    }
}
