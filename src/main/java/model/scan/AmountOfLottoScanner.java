package model.scan;

import validator.AmountOfLottoValidator;
import validator.ValidatorInterface;

public class AmountOfLottoScanner extends InputData{
    public AmountOfLottoScanner() { }

    public static int getAmountOfLotto() {
        ValidatorInterface validatorInterface = new AmountOfLottoValidator();
        String amountOfLotto;
        do {
            System.out.println("구입 금액을 입력해주세요.");
            amountOfLotto = getInput();
        }while(!validatorInterface.validateData(amountOfLotto));
        return Integer.parseInt(amountOfLotto) / 1000;
    }
}
