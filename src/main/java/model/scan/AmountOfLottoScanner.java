package model.scan;

import util.InputData;
import validator.AmountOfLottoValidator;
import validator.ValidatorInterface;

public class AmountOfLottoScanner {
    private AmountOfLottoScanner() {
    }

    public static int getAmountOfLotto() {
        ValidatorInterface validatorInterface = new AmountOfLottoValidator();
        System.out.println("구입 금액을 입력해주세요.");
        String amountOfLotto = InputData.getInputUnitValid(validatorInterface);
        return Integer.parseInt(amountOfLotto) / 1000;
    }
}
