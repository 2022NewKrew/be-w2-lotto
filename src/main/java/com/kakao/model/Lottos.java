package com.kakao.model;

import com.kakao.data.LottoData;
import com.kakao.exception.PickedNumberException;
import com.kakao.helper.LottoHelper;
import com.kakao.model.lotto.AutoLotto;
import com.kakao.model.lotto.Lotto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Lottos implements Serializable {

    private List<Lotto> lottoList;

    // 생성자
    public Lottos(Money moneyToBuyLottos) {
        int numberOfLotto = moneyToBuyLottos.getMoney()/LottoData.PRICE_OF_LOTTO;
        this.lottoList = getNewAutoLottos(null, numberOfLotto);
    }
    public Lottos(Money moneyToBuyLottos, List<Lotto> manualLottoList) {
        int numberOfLotto = moneyToBuyLottos.getMoney()/LottoData.PRICE_OF_LOTTO;
        this.lottoList = getNewAutoLottos(manualLottoList, numberOfLotto);
    }

    // 로또용지들 생성함수
    private List<Lotto> getNewAutoLottos(List<Lotto> manualLottoList, int numberOfLottos) {
        List<Lotto> lottoList = new ArrayList<>();
        if(manualLottoList != null) {
            lottoList.addAll(manualLottoList);
        }
        for(int i=lottoList.size(); i<numberOfLottos; i++){
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
    public LottoWinningResult matchLottosAreWinning(LottoWinning lottoWinning) {
        LottoWinningResult countOfWinningLottos = new LottoWinningResult();
        if( lottoWinning == null ){
            return countOfWinningLottos;
        }
        for(Lotto lotto: this.lottoList) {
            int winningNumber = lotto.matchNumberIsWinning(lottoWinning); // 일치한 갯수
            boolean bonusBallIsMatched = lotto.matchBonusBall(lottoWinning.getBonusBall());

            LottoWinningReward rewardKey = new LottoWinningReward(winningNumber, bonusBallIsMatched);
            countOfWinningLottos.addCountAndUpdateByKey(rewardKey);
        }
        return countOfWinningLottos;
    }

    // getter
    public List<Lotto> getLottoList() {
        return lottoList;
    }
}
