package com.upperleaf.domain.lotto.create;

import java.util.List;

public class LottoValidator {

    private LottoValidator() {}

    public static void validation(List<Integer> lottoNums) {
        validLottoSize(lottoNums);
        for(Integer num : lottoNums) {
            validLottoNumRange(num);
        }
    }

    public static void validLottoSize(List<Integer> lottoNums) {
        if (lottoNums.size() != LottoConstants.LOTTO_SIZE) {
            throw new IllegalArgumentException("로또 번호 개수가 일치하지 않습니다.");
        }
    }

    public static void validLottoNumRange(Integer num) {
        if(num < LottoConstants.LOTTO_START_NUM || num > LottoConstants.LOTTO_END_NUM) {
            throw new IllegalArgumentException("로또 번호 값이 번호 범위에 해당하지 않습니다.");
        }
    }
}
