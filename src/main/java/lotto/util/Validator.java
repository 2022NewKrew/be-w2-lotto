package lotto.util;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Validator {
    public static void checkNaturalNumber(long budget) throws IllegalArgumentException{
        if(budget < 0)
            throw new IllegalArgumentException("0 이상의 자연수를 입력해야합니다.");
    }
    public static void checkNaturalNumber(int numberOfManualBuy) throws IllegalArgumentException{
        if(numberOfManualBuy < 0)
            throw new IllegalArgumentException("0 이상의 자연수를 입력해야합니다.");
    }

    public static void checkLottoNumbersFormat(List<Integer> numbers) throws IllegalArgumentException{
        if (numbers.size() != LottoConstantValue.NUMBER_OF_PICK)
            throw new IllegalArgumentException(LottoConstantValue.NUMBER_OF_PICK + "개의 번호를 입력해야 합니다.");

        Set<Integer> checkDuplication = new HashSet<>(numbers);
        if (checkDuplication.size() != numbers.size()) {
            throw new IllegalArgumentException("각각 다른 번호를 입력해야합니다.");
        }

        Collections.sort(numbers);
        checkLottoNumberRange(numbers.get(0));
        checkLottoNumberRange(numbers.get(LottoConstantValue.NUMBER_OF_PICK-1));
    }

    public static void checkBonusNumberAndWinningNumbersDuplication(List<Integer> winningNumbers, int bonusNumber){
        checkLottoNumberRange(bonusNumber);
        if( winningNumbers.contains(bonusNumber) )
            throw new IllegalArgumentException("보너스볼은 당첨번호에 포함되지 않는 번호를 입력해야합니다.");
    }

    private static void checkLottoNumberRange(int number) throws IllegalArgumentException{
        if(number > LottoConstantValue.MAX_NUMBER || number < LottoConstantValue.MIN_NUMBER)
            throw new IllegalArgumentException(
                    LottoConstantValue.MIN_NUMBER + "과 " +
                    LottoConstantValue.MAX_NUMBER + "사이의 숫자를 입력해야합니다.");
    }


}
