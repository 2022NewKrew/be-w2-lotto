package model.scan;

import exception.LottoException;
import validator.BonusValidator;
import validator.ValidatorInterface;

import java.util.List;

public class BonusNumberScanner extends InputData {
    public BonusNumberScanner() {
    }

    public static int getBonusNumber(List<Integer> winningNumber) {
        ValidatorInterface validatorInterface = new BonusValidator(winningNumber);
        System.out.println("보너스 볼을 입력해주세요.");
        String bonus = validateAndGetInput(validatorInterface);
        return Integer.parseInt(bonus);
    }
}
