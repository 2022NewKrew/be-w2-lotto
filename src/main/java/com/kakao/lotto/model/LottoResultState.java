package com.kakao.lotto.model;

import java.util.HashSet;
import java.util.Set;

import static com.kakao.lotto.model.ConstLottoConfig.LOTTO_PICK_NUMBER;

/**
 * author    : brody.moon
 * version   : 1.1
 * 로또 당첨 등수를 보여주는 Enum 클래스입니다.
 */
public enum LottoResultState {
    NOTMATCH(0, 0),
    FIFTH(LOTTO_PICK_NUMBER - 3, ConstLottoConfig.FIFTH_PRICE),
    FOURTH(LOTTO_PICK_NUMBER - 2, ConstLottoConfig.FOURTH_PRICE),
    THIRD(LOTTO_PICK_NUMBER - 1, ConstLottoConfig.THIRD_PRICE),
    SECOND(LOTTO_PICK_NUMBER - 1, ConstLottoConfig.SECOND_PRICE),
    FIRST(LOTTO_PICK_NUMBER, ConstLottoConfig.FIRST_PRICE);

    /**
     * 일치해야하는 숫자의 갯수와 당첨 금액을 가지고 있습니다.
     */
    private final int numOfMatchs;
    private final int price;

    LottoResultState(int numOfMatchs, int price) {
        this.numOfMatchs = numOfMatchs;
        this.price = price;
    }

    /**
     * 당첨 로또 번호와 유저 로또 번호가 Enum 상수와 매치할 수 있는지를 반환해주는 메서드입니다.
     * 각 int[] 변수 끼리 A -B, B- A 차집합을 이용해 매치 여부를 판단합니다.
     *
     * @param winningLottoNumber 당첨 로또 번호
     * @param curLottoNumber     유저 로또 번호
     * @param winningLottoBonus  보너스 구슬 번호
     * @return 현재 유저 로또가 몇등인지 enum객체 반환
     */
    public static LottoResultState calcMatchResult(LottoNumber winningLottoNumber, LottoNumber curLottoNumber, int winningLottoBonus) {
        Set<Integer> winningLottoNumberDiffSet = createDiffSet(winningLottoNumber, curLottoNumber);
        Set<Integer> curLottoNumberDiffSet = createDiffSet(curLottoNumber, winningLottoNumber);

        LottoResultState resultState = mapResultToState(winningLottoNumberDiffSet.size());
        if(resultState != LottoResultState.SECOND)
            return resultState;

        return winningLottoBonus == curLottoNumberDiffSet.iterator().next() ? LottoResultState.SECOND : LottoResultState.THIRD;
    }

    private static LottoResultState mapResultToState(int matchResult) {
        switch (matchResult) {
            case 0:
                return LottoResultState.FIRST;
            case 1:
                return LottoResultState.SECOND;
            case 2:
                return LottoResultState.FOURTH;
            case 3:
                return LottoResultState.FIFTH;
            default:
                return LottoResultState.NOTMATCH;
        }
    }

    /**
     * 차지합을 반환하주는 메서드입니다.
     *
     * @param source source 배열
     * @param target target 배열
     * @return
     */
    private static Set<Integer> createDiffSet(LottoNumber source, LottoNumber target) {
        Set<Integer> sourceSet = new HashSet<>(source.getAll());
        Set<Integer> targetSet = new HashSet<>(target.getAll());

        sourceSet.removeAll(targetSet);
        return sourceSet;
    }


    public int getNumOfMatchs() {
        return numOfMatchs;
    }

    public int getPrice() {
        return price;
    }
}
