package model.scan;

import validator.BonusValidator;
import validator.ValidatorInterface;

import java.util.List;

public class BonusNumberScanner extends InputData{
    public BonusNumberScanner() { }

    public static int getBonusNumber(List<Integer> winningNumber) {
        ValidatorInterface validatorInterface = new BonusValidator(winningNumber);
        String bonus;
        do {
            System.out.println("보너스 볼을 입력해주세요.");
            bonus = getInput();
        }while(!validatorInterface.validateData(bonus));

        return Integer.parseInt(bonus);
    }
}
