package lotto.validator;

import lotto.domain.lotto.Lotto;
import lotto.domain.result.BonusNumber;
import lotto.domain.result.WinningLotto;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class LottoValidator {

    public static void validateLottoNumbers(List<Integer> numbers) {
        validateNumbersCount(numbers);
        validateNumbersDuplicate(numbers);
        validateNumbersRange(numbers);
    }

    public static void validateNumbersCount(List<Integer> numbers) {
        if(numbers.size() != Lotto.LOTTO_NUMBER_COUNT_MAX){
            throw new IllegalArgumentException("수동 번호 입력 개수가 유효하지 않습니다.");
        }
    }

    public static void validateNumbersDuplicate(List<Integer> numbers){
        Set<Integer> chkDuplicationSet = new HashSet<>(numbers);
        if(chkDuplicationSet.size() != Lotto.LOTTO_NUMBER_COUNT_MAX){
            throw new IllegalArgumentException("중복 된 입력 번호가 있습니다.");
        }
    }

    public static void validateNumbersRange(List<Integer> numbers){
        numbers.forEach(number ->{
            if(number < Lotto.LOTTO_NUMBER_MIN || number >Lotto.LOTTO_NUMBER_MAX){
                throw new IllegalArgumentException("숫자가 1~45가 아닙니다.");
            }
        });
    }

    public static void validateBonusNumber(WinningLotto winningLotto, BonusNumber bonusNumber){
        if (winningLotto.getNumbers().contains(bonusNumber.getNumber())) {
            throw new IllegalArgumentException("당첨 번호와 보너스 번호가 중복됩니다.");
        }
    }
}
