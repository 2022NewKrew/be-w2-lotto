package validator;

import constants.LottoRule;

import java.util.List;

public class BonusValidator extends IntegerValidator implements ValidatorInterface{
    private final List<Integer> winningNumbers;

    public BonusValidator(List<Integer> winningNumbers) { this.winningNumbers = winningNumbers; }

    @Override
    public boolean validateData(String input) {
        if(!isInteger(input)){
            System.out.println("정수로 입력해주세요.");
            return false;
        }
        int bonus = Integer.parseInt(input);
        if(!validateBoundary(bonus)){
            System.out.println("1에서 45사이로 입력해주세요.");
            return false;
        }
        if(winningNumbers.contains(bonus)){
            System.out.println("이미 존재하는 번호입니다.");
            return false;
        }
        return true;
    }

    private boolean validateBoundary(int bonus){
        return bonus <= LottoRule.MAX_LOTTO_NUMBER && bonus >= LottoRule.MIN_LOTTO_NUMBER;
    }
}
