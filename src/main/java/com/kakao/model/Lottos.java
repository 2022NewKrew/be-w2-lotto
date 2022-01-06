package com.kakao.model;

import com.kakao.data.LottoData;
import com.kakao.exception.MoneyRangeException;
import com.kakao.exception.PickedNumberException;
import com.kakao.helper.LottoHelper;
import com.kakao.model.lotto.AutoLotto;
import com.kakao.model.lotto.Lotto;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Lottos {

    private List<Lotto> lottoList;

    // 생성자
    public Lottos(final Integer moneyToBuyLottos) throws MoneyRangeException {
        checkMoneyRange(moneyToBuyLottos);

        int numberOfLotto = moneyToBuyLottos/LottoData.PRICE_OF_LOTTO;
        this.lottoList = getNewAutoLottos(numberOfLotto);
    }

    // 유효성 검사
    private void checkMoneyRange(final Integer moneyToBuyLottos) throws MoneyRangeException {
        if( moneyToBuyLottos == null || moneyToBuyLottos < LottoData.PRICE_OF_LOTTO ) {
            throw new MoneyRangeException();
        }
    }

    // 로또용지들 생성함수
    private List<Lotto> getNewAutoLottos(int numberOfLottos) {
        List<Lotto> lottoList = new ArrayList<>();
        for(int i=0; i<numberOfLottos; i++){
            lottoList.add(getNewAutoLotto());
        }
        return lottoList;
    }
    private Lotto getNewAutoLotto() {
        Lotto newLotto = null;
        while(newLotto == null) {
            newLotto = generateAutoLotto();
        }
        return newLotto;
    }

    // 로또 생성
    private Lotto generateAutoLotto() {
        Lotto newLotto = null;
        try {
            newLotto = new AutoLotto(LottoHelper.generatePickedNumber());
        } catch (PickedNumberException e) {
            e.printStackTrace();
        }
        return newLotto;
    }

    // 로또의 당첨 등수 확인
    public Map<LottoWinningReward, Integer> matchLottosAreWinning(LottoWinning lottoWinning) {
        // 해시맵 사용
        Map<LottoWinningReward, Integer> countOfWinningLottos = new HashMap<>();
        if( lottoWinning == null ){
            return countOfWinningLottos;
        }
        for(Lotto lotto: this.lottoList) {
            int winningNumber = lotto.matchNumberIsWinning(lottoWinning); // 일치한 갯수
            boolean bonusBallIsMatched = lotto.matchBonusBall(lottoWinning.getBonusBall());

            LottoWinningReward rewardKey = new LottoWinningReward(winningNumber, bonusBallIsMatched);
            updateCountOfWinningLottos(countOfWinningLottos, rewardKey);
        }
        return countOfWinningLottos;
    }
    private void updateCountOfWinningLottos(Map<LottoWinningReward, Integer> countOfWinningLottos, LottoWinningReward rewardKey) {
        Integer countOfWinningNumber = countOfWinningLottos.get(rewardKey);
        if(countOfWinningNumber == null){
            countOfWinningNumber = 0;
        }
        countOfWinningLottos.put(rewardKey, countOfWinningNumber+1);
    }

    // getter
    public List<Lotto> getLottoList() {
        return lottoList;
    }
}
