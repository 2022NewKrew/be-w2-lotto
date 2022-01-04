package validator;

import constants.LottoRule;

public class AmountOfLottoValidator extends IntegerValidator implements ValidatorInterface{
    public AmountOfLottoValidator() { }

    @Override
    public boolean validateData(String input) {
        if(isNumeric(input)){
            System.out.println("정수로 입력해주세요.");
            return false;
        }
        if(!dividableByThousand(input)){
            System.out.println("로또는 1개에 1000원입니다.");
            return false;
        }
        return true;
    }

    private boolean dividableByThousand(String input){
        int intInput = Integer.parseInt(input);
        return (intInput > 1000 && intInput % LottoRule.PRICE_PER_LOTTO == 0);
    }
}
