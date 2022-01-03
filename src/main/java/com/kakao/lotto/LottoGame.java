package com.kakao.lotto;

<<<<<<< HEAD
import com.kakao.io.LottoIO;
import com.kakao.model.LottoWinning;
=======
import com.kakao.exception.MoneyRangeException;
import com.kakao.io.LottoIO;
>>>>>>> edb2074 (1일차 중간 PR)
import com.kakao.model.Lottos;

public class LottoGame {

<<<<<<< HEAD
    private Integer moneyToBuyLotto;
    private Lottos lottos;
    private LottoWinning lottoWinning;

    // 로또 구매 진행
    private void inputLotto() {
        Lottos newLottos = null;
        Integer moneyToBuyNewLotto = null;
        while(newLottos == null) {
            moneyToBuyNewLotto = LottoIO.inputMoney();
            newLottos = LottoIO.buyLottos(moneyToBuyNewLotto);
        }
        this.moneyToBuyLotto = moneyToBuyNewLotto;
        this.lottos = newLottos;
    }

    // 당첨번호 입력
    private void inputWinning() {
        while(this.lottoWinning == null) {
            this.lottoWinning = LottoIO.inputLottoWinning();
        }
    }

    // 로또 출력
    private void printLotto() {
        LottoIO.printLottosInfo(this.lottos);
    }
    // 당첨 결과 출력
    private void printWinningResult() {
        LottoIO.printLottoWinning(this.moneyToBuyLotto, this.lottos, this.lottoWinning);
    }
=======
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
>>>>>>> edb2074 (1일차 중간 PR)

    // 메인에서 호출할 실행함수
    public void play() {
        inputLotto();
        printLotto();
<<<<<<< HEAD

        inputWinning();
        printWinningResult();
=======
>>>>>>> edb2074 (1일차 중간 PR)
    }
}
