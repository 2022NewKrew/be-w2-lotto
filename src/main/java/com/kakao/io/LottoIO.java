package com.kakao.io;

<<<<<<< HEAD
import com.kakao.data.LottoData;
import com.kakao.data.io.LottoInputData;
import com.kakao.exception.MoneyRangeException;
import com.kakao.model.LottoWinning;
import com.kakao.model.Lottos;

public class LottoIO {
    private LottoIO() {}

    // 돈 입력받기
    public static Integer inputMoney() {
        String requestPrice = String.format(LottoInputData.REQUEST_COMMNET_OF_PRICE, LottoData.PRICE_OF_LOTTO);
        LottoOutput.printString(requestPrice);
        return LottoInput.inputMoney();
    }

    // 로또 구매 시도
    public static Lottos buyLottos(Integer moneyToBuyLottos) {
        Lottos lottosToBuy = null;
        try {
            lottosToBuy = new Lottos(moneyToBuyLottos);
        } catch (MoneyRangeException e) {
            e.printStackTrace();
        }
        return lottosToBuy;
    }

    // 당첨 정보 입력 및 생성
    public static LottoWinning inputLottoWinning() {
        LottoWinning lottoWinning = null;
        while(lottoWinning == null) {
            LottoOutput.printString(LottoInputData.REQUEST_COMMNET_OF_WINNING);
            lottoWinning = LottoInput.inputWinning();
        }
        return lottoWinning;
=======
import com.kakao.data.io.LottoInputData;
import com.kakao.model.Lottos;

public class LottoIO {

    // 로또 정보 입력받기
    public static Integer inputMoneyToBuyLotto() {
        Integer money = null; // 돈 정보
        while(money == null) {
            LottoOutput.printString(LottoInputData.REQUEST_COMMNET_OF_PRICE);
            money = LottoInput.inputMoney();
        }
        return money;
>>>>>>> edb2074 (1일차 중간 PR)
    }

    // 로또 정보 출력
    public static void printLottosInfo(Lottos lottos) {
        LottoOutput.printResult(lottos);
    }
<<<<<<< HEAD

    // 당첨결과 출력
    public static void printLottoWinning(Integer moneyToBuyLotto, Lottos lottos, LottoWinning lottoWinning) {
        LottoOutput.printLottoWinning(moneyToBuyLotto, lottos, lottoWinning);
    }
=======
>>>>>>> edb2074 (1일차 중간 PR)
}
