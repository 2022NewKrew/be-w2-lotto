package com.kakao.lotto.model;

import java.util.EnumMap;
import java.util.List;
import java.util.Map;


/**
 * author    : brody.moon
 * version   : 1.1
 * 로또의 결과를 확인해서 map 형식으로 바꾸어 주는 클래스입니다.
 */
public class LottoResultCheck {
    /**
     * 당첨 로또 번호와 유저의 로또 정보를 가지고 있습니다.
     */
    private final List<LottoNumber> userLottos;
    private final LottoNumber winningLotto;
    private final int bonus;

    public LottoResultCheck(List<LottoNumber> userLottos, LottoNumber winningLotto, int bonus) {
        this.userLottos = userLottos;
        this.winningLotto = winningLotto;
        this.bonus = bonus;
    }

    /**
     * 로또의 결과를 Map 으로 변환해 주는 메서드입니다.
     * enum 내부 메서드를 써보려고 어거지로 만들어서 조잡합니다.
     * enum 내부 메서드를 사용하려다 보니 불필요한 반복을 하게 되어 다시 생각해 봐야할 것 같습니다.
     *
     * @return
     */
    public Map<LottoResultState, Integer> lottoResult() {
        Map<LottoResultState, Integer> result = new EnumMap<>(LottoResultState.class);

        for (LottoResultState state : LottoResultState.values()) {
            result.put(state, 0);
        }

        for (LottoNumber userLotto : userLottos) {
            visitAllState(result, userLotto);
        }

        return result;
    }

    /**
     * 각 Enum 상수에서 메서드를 호출에 현재 로또가 지금 Enum 상태와 일치하는지 확인합니다.
     * Enum 메서드가 아니였으면 반복하지 않아도 되는 불필요한 메서드입니다.
     *
     * @param result    결과를 저장할 Map 객체
     * @param userLotto 결과를 확인하고 있는 로또 번호
     */
    private void visitAllState(Map<LottoResultState, Integer> result, LottoNumber userLotto) {
        for (LottoResultState state : LottoResultState.values()) {
            addResultHaskMap(result, userLotto, state);
        }
    }

    /**
     * 현재 Enum 상수 상태와 로또가 일치하는지 확인하고 일치할 경우 count를 올려주는 메서드입니다.
     *
     * @param result    결과를 저장할 Map 객체
     * @param userLotto 결과를 확인하고 있는 로또 번호
     * @param state     현재 확인중인 Enum 상수
     */
    private void addResultHaskMap(Map<LottoResultState, Integer> result, LottoNumber userLotto, LottoResultState state) {
        if (state.isIncludedCurrentState(winningLotto, userLotto, bonus)) {
            result.put(state, result.get(state) + 1);
        }
    }
}
