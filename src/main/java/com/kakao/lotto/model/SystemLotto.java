package com.kakao.lotto.model;

import java.util.Arrays;
import java.util.Random;
import java.util.stream.Stream;

/**
 * author    : brody.moon
 * version   : 1.0
 * 당첨 로또를 생성하는 클래스입니다.
 */
public class SystemLotto {
    /**
     * 당첨 로또 번호와 보너스 번호를 가지고 있습니다.
     */
    private final int[] winningLottoNumbers;
    private static final Random random = new Random();
    private final int bonus;

    public SystemLotto() {
        int[] tmpIntArray = Stream.generate(() -> random.nextInt(ConstLottoConfig.LOTTO_NUMBER_RANGE) + 1)
                .distinct()
                .limit(ConstLottoConfig.LOTTO_PICK_NUMBER + 1)
                .mapToInt(number -> number)
                .toArray();

        winningLottoNumbers = Arrays.stream(tmpIntArray)
                .limit(ConstLottoConfig.LOTTO_PICK_NUMBER)
                .sorted()
                .toArray();
        bonus = tmpIntArray[ConstLottoConfig.LOTTO_PICK_NUMBER];
    }

    public int[] getWinningLottoNumbers() {
        return winningLottoNumbers;
    }

    public int getBonus() {
        return bonus;
    }
}
