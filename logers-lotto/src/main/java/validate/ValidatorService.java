package validate;

import java.util.List;

public class ValidatorService {
    private final Validator purchaseAmountValidator;
    private final Validator winNumbersValidator;

    public ValidatorService(Validator purchaseAmountValidator, Validator winNumbersValidator) {
        this.purchaseAmountValidator = purchaseAmountValidator;
        this.winNumbersValidator = winNumbersValidator;
    }

    public void validatePurchaseAmount(int amount) {
        purchaseAmountValidator.validate(amount);
    }

    public void validateWinNumbers(List<Integer> winNumbers){
        winNumbersValidator.validate(winNumbers);
    }
}
