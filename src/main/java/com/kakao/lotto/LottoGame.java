package com.kakao.lotto;

<<<<<<< HEAD
<<<<<<< HEAD
import com.kakao.io.LottoIO;
import com.kakao.model.LottoWinning;
=======
import com.kakao.exception.MoneyRangeException;
import com.kakao.io.LottoIO;
>>>>>>> edb2074 (1일차 중간 PR)
=======
import com.kakao.io.LottoIO;
import com.kakao.model.LottoWinning;
>>>>>>> 4f43f8b (1차 Commit)
import com.kakao.model.Lottos;

public class LottoGame {

<<<<<<< HEAD
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
=======
    private Integer moneyToBuyLotto;
>>>>>>> 4f43f8b (1차 Commit)
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
<<<<<<< HEAD
>>>>>>> edb2074 (1일차 중간 PR)
=======
    // 당첨 결과 출력
    private void printWinningResult() {
        LottoIO.printLottoWinning(this.moneyToBuyLotto, this.lottos, this.lottoWinning);
    }
>>>>>>> 4f43f8b (1차 Commit)

    // 메인에서 호출할 실행함수
    public void play() {
        inputLotto();
        printLotto();
<<<<<<< HEAD
<<<<<<< HEAD

        inputWinning();
        printWinningResult();
=======
>>>>>>> edb2074 (1일차 중간 PR)
=======

        inputWinning();
        printWinningResult();
>>>>>>> 4f43f8b (1차 Commit)
    }
}
