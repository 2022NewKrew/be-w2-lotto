package validator;

import constants.LottoRule;

public class AmountOfLottoValidator extends IntegerValidator implements ValidatorInterface{
    public AmountOfLottoValidator() { }

    @Override
    public boolean validateData(String input) {
        return (isNumeric(input) && dividableByThousand(input));
    }

    private boolean dividableByThousand(String input){
        int intInput = Integer.parseInt(input);
        if(!(intInput >= 1000 && intInput % LottoRule.PRICE_PER_LOTTO == 0)){
            System.out.println("로또는 1개에 1000원입니다.");
            return false;
        }
        return true;
    }
}
