package model.scan;

import util.InputData;
import validator.BonusValidator;
import validator.ValidatorInterface;

import java.util.List;

public class BonusNumberScanner {
    private BonusNumberScanner() {
    }

    public static int getBonusNumber(List<Integer> winningNumber) {
        ValidatorInterface validatorInterface = new BonusValidator(winningNumber);
        System.out.println("보너스 볼을 입력해주세요.");
        String bonus = InputData.getInputUnitValid(validatorInterface);
        return Integer.parseInt(bonus);
    }
}
