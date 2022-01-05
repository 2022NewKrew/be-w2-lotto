package model.scan;

import validator.ManualNumberValidator;
import validator.ValidatorInterface;

public class ManualCountScanner extends InputData {
    public ManualCountScanner() {
    }

    public static int getManualCount(int amountOfLotto) {
        ValidatorInterface validatorInterface = new ManualNumberValidator(amountOfLotto);
        System.out.println("수동으로 구매할 로또 수를 입력해 주세요.");
        String manualCount = validateAndGetInput(validatorInterface);
        return Integer.parseInt(manualCount);
    }
}
