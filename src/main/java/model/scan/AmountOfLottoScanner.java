package model.scan;

import exception.LottoException;
import validator.AmountOfLottoValidator;
import validator.ValidatorInterface;

public class AmountOfLottoScanner extends InputData {
    public AmountOfLottoScanner() {
    }

    public static int getAmountOfLotto() {
        ValidatorInterface validatorInterface = new AmountOfLottoValidator();
        System.out.println("구입 금액을 입력해주세요.");
        String amountOfLotto = validateAndGetInput(validatorInterface);
        return Integer.parseInt(amountOfLotto) / 1000;
    }
}
