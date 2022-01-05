package lotto.domain;

import lotto.exception.LottoNumberDuplicateException;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by melodist
 * Date: 2022-01-05 005
 * Time: 오후 1:36
 */
public class Validator {
    public static void validatePurchaseAmount(int purchaseAmount) {
        if (purchaseAmount < Constants.LOTTO_PRICE) {
            throw new IllegalArgumentException("1000원 이상의 금액을 입력해주세요.");
        }
    }

    public static void validateManualLottoCount(Integer lottoCount, Integer manualLottoCount) {
        if (lottoCount < manualLottoCount) {
            throw new IllegalArgumentException("입력한 수가 구매할 수 있는 로또 수보다 큽니다.");
        }
    }

    public static void validateLottoNumbers(List<Integer> lottoNumbers) {
        validateLottoNumbersLength(lottoNumbers);
        for (Integer lottoNumber: lottoNumbers) {
            validateLottoNumberRange(lottoNumber);
        }
        validateLottoNumberDuplicate(lottoNumbers);
    }
    
    public static void validateLottoNumbersLength(List<Integer> lottoNumbers) {
        if(lottoNumbers.size() != Constants.LOTTO_SIZE) {
            throw new IllegalArgumentException("로또 번호의 갯수가 6개가 아닙니다.");
        }
    }

    public static void validateLottoNumberDuplicate(List<Integer> lottoNumbers) {
        Set<Integer> nonDuplicateNumbers = new HashSet<>(lottoNumbers);
        if(nonDuplicateNumbers.size() != lottoNumbers.size()) {
            throw new LottoNumberDuplicateException("로또 번호는 중복될 수 없습니다.");
        }
    }

    public static void validateLottoNumberRange(Integer lottoNumber) {
        if (lottoNumber < Constants.LOTTO_MIN_NUMBER || lottoNumber > Constants.LOTTO_MAX_NUMBER) {
            throw new IllegalArgumentException("숫자의 범위는 1~45입니다.");
        }
    }

    public static void validateLottoBonusDuplicate(List<Integer> lottoNumbers, Integer bonusBall) {
        if (lottoNumbers.contains(bonusBall)) {
            throw new IllegalArgumentException("보너스 번호와 당첨 번호가 중복될 수 없습니다.");
        }
    }
}
