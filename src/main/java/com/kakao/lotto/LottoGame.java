package com.kakao.lotto;

import com.kakao.exception.MoneyRangeException;
import com.kakao.io.LottoIO;
import com.kakao.model.Lottos;

public class LottoGame {

    private Lottos lottos;

    private void inputLotto() {
        // 로또 구매 진행
        while(this.lottos == null) {
            int moneyToBuyLotto = LottoIO.inputMoneyToBuyLotto();
            this.lottos = buyLotto(moneyToBuyLotto);
        }
    }
    // 로또 구매 시도
    private Lottos buyLotto(int moneyToBuyLotto) {
        Lottos lottosToBuy = null;
        try {
            lottosToBuy = new Lottos(moneyToBuyLotto);
        } catch (MoneyRangeException e) {
            e.printStackTrace();
        } finally {
            return lottosToBuy;
        }
    }

    private void printLotto() { // 로또 출력
        LottoIO.printLottosInfo(this.lottos);
    }

    // 메인에서 호출할 실행함수
    public void play() {
        inputLotto();
        printLotto();
    }
}
