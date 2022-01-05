package model.lotto;

import model.lotto.number.LottoNumber;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class LottoPrecondition {

    public static void checkNumbers(List<LottoNumber> lottoNumbers) {
        checkNull(lottoNumbers);
        checkNumbersLength(lottoNumbers);
        checkDuplicateNumber(lottoNumbers);
    }

    private static void checkNull(List<LottoNumber> lottoNumbers) {
        if (lottoNumbers == null){
            throw new IllegalArgumentException("리스트가 Null입니다.");
        }
    }

    private static void checkNumbersLength(List<LottoNumber> lottoNumbers) {
        if (lottoNumbers.size() != Lotto.LENGTH_OF_NUMBERS) {
            throw new IllegalArgumentException("숫자의 개수가 부적절합니다!");
        }
    }

    private static void checkDuplicateNumber(List<LottoNumber> lottoNumbers) {
        Set<LottoNumber> testSet = new HashSet<>(lottoNumbers);
        if (testSet.size() != lottoNumbers.size()) {
            throw new IllegalArgumentException("중복된 숫자가 존재합니다.");
        }
    }
}
