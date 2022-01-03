package model.scan;

import validator.AmountOfLottoValidator;
import validator.ValidatorInterface;

public class AmountOfLottoScanner extends InputData{
    public AmountOfLottoScanner() { }

    public int getAmountOfLotto() {
        ValidatorInterface amountOfLottoValidator = new AmountOfLottoValidator();
        String amountOfLotto;
        do {
            System.out.println("구입 금액을 입력해주세요.");
            amountOfLotto = getInput();
        }while(!amountOfLottoValidator.validateData(amountOfLotto));
        int amount = Integer.parseInt(amountOfLotto) / 1000;
        System.out.println(amount + "개를 구매했습니다.");
        return amount;
    }
}
