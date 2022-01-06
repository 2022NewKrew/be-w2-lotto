package com.kakao.lotto;

import com.kakao.exception.MoneyRangeException;
import com.kakao.helper.LottoHelper;
import com.kakao.io.LottoIO;
import com.kakao.model.LottoWinning;
import com.kakao.model.Lottos;
import com.kakao.model.Money;
import com.kakao.model.lotto.Lotto;
import java.util.List;

public class LottoGame {

    private Money moneyToBuyLotto;
    private Lottos lottos;
    private LottoWinning lottoWinning;

    // 로또 구매 진행
    private void generateLottos() {
        Integer countOfManualLotto = null; // 수동으로 입력할 로또
        List<Lotto> newManualLottos = null;
        Money moneyToBuyNewLotto = null;
        Lottos newLottos = null;

        while(moneyToBuyNewLotto == null){
            moneyToBuyNewLotto = inputMoney();
        }
        countOfManualLotto = inputCountOfManualLottos(moneyToBuyNewLotto);
        newManualLottos = buyManualLottos(countOfManualLotto);
        newLottos = buyLottos(moneyToBuyNewLotto, newManualLottos);

        this.moneyToBuyLotto = moneyToBuyNewLotto;
        this.lottos = newLottos;
    }
    private Money inputMoney () { // 돈입력
        try {
            return LottoIO.inputMoney();
        } catch (MoneyRangeException e) {
            e.printStackTrace();
        }
        return null;
    }
    private Integer inputCountOfManualLottos (Money money) { // 수동 로또
        Integer countOfManualLotto = null;
        do {
            countOfManualLotto = LottoIO.inputCountOfManualLotto();
        } while(!LottoHelper.canBuyLottos(money, countOfManualLotto));
        return countOfManualLotto;
    }

    private Lottos buyLottos(Money money, List<Lotto> newManualLottos) { // 자동 로또
        return new Lottos(money, newManualLottos);
    }

    // 수동 로또 구매
    public static List<Lotto> buyManualLottos (int count) {
        return LottoIO.inputManualLottos(count);
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

    // 메인에서 호출할 실행함수
    public void play() {
        generateLottos();
        printLotto();

        inputWinning();
        printWinningResult();
    }
}
