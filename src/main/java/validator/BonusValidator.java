package validator;

import constants.LottoRule;

import java.util.List;

public class BonusValidator extends IntegerValidator implements ValidatorInterface{
    private final List<Integer> winningNumbers;

    public BonusValidator(List<Integer> winningNumbers) { this.winningNumbers = winningNumbers; }

    @Override
    public boolean validateData(String input) {
        if(!isNumeric(input)) { return false; }
        int bonus = Integer.parseInt(input);

        return (validateBoundary(bonus) && isDuplicated(bonus));
    }

    private boolean validateBoundary(int bonus){
        if(!(bonus <= LottoRule.MAX_LOTTO_NUMBER && bonus >= LottoRule.MIN_LOTTO_NUMBER)){
            System.out.println("1에서 45사이로 입력해주세요.");
            return false;
        }
        return true;
    }

    private boolean isDuplicated(int bonus){
        if(winningNumbers.contains(bonus)){
            System.out.println("이미 존재하는 번호입니다.");
            return false;
        }
        return true;
    }
}
