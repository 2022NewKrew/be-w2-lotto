package factory;

import validate.PurchaseAmountValidator;
import validate.Validator;
import validate.ValidatorService;
import validate.WinNumbersValidator;

public class ValidatorServiceFactory {
    private static ValidatorService instance = null;

    public static ValidatorService getInstance(){
        if(instance == null){
            instance = new ValidatorService(purchaseAmountValidator(), winNumbersValidator());
        }

        return instance;
    }

    private static Validator purchaseAmountValidator(){
        return new PurchaseAmountValidator();
    }

    private static Validator winNumbersValidator(){
        return new WinNumbersValidator();
    }
}
