package model.scan;

import util.LottoScanner;
import validator.AmountOfLottoValidator;
import validator.ValidatorInterface;

public class AmountOfLottoScanner {
    private AmountOfLottoScanner() {
    }

    public static int getAmountOfLotto() {
        ValidatorInterface validatorInterface = new AmountOfLottoValidator();
        System.out.println("구입 금액을 입력해주세요.");
        String amountOfLotto = LottoScanner.getInputUnitValid(validatorInterface);
        return Integer.parseInt(amountOfLotto) / 1000;
    }
}
