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
     * enum 내부 메서드를 이용해 구현했다가 내부 static 메서드로 바꾸어 반복을 줄였습니다.
     *
     * @return
     */
    public Map<LottoResultState, Integer> lottoResult() {
        Map<LottoResultState, Integer> result = new EnumMap<>(LottoResultState.class);

        for (LottoResultState state : LottoResultState.values()) {
            result.put(state, 0);
        }

        for (LottoNumber userLotto : userLottos) {
            addResultHashMap(result, LottoResultState.calcMatchResult(winningLotto, userLotto, bonus));
        }

        result.remove(LottoResultState.NOTMATCH);

        return result;
    }

    /**
     * 현재 Enum 상수 상태와 로또가 일치하는지 확인하고 일치할 경우 count를 올려주는 메서드입니다.
     *
     * @param result    결과를 저장할 Map 객체
     * @param state     현재 확인중인 Enum 상수
     */
    private void addResultHashMap(Map<LottoResultState, Integer> result, LottoResultState state) {
        result.put(state, result.get(state) + 1);
    }
}
