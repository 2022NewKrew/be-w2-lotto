package com.kakao.io;

<<<<<<< HEAD
<<<<<<< HEAD
import com.kakao.data.LottoData;
import com.kakao.data.io.LottoInputData;
import com.kakao.exception.MoneyRangeException;
import com.kakao.exception.PickedNumberRangeException;
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
<<<<<<< HEAD
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
        do {
          LottoOutput.printString(LottoInputData.REQUEST_COMMENT_OF_BONUS_BALL);
        } while(!inputBonusBallToWinning(lottoWinning));

        return lottoWinning;
=======
=======
import com.kakao.data.LottoData;
>>>>>>> 231c634 (1차 PR 리뷰 개선)
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
        } finally {
            return lottosToBuy;
        }
<<<<<<< HEAD
        return money;
>>>>>>> edb2074 (1일차 중간 PR)
=======
=======
        }
        return lottosToBuy;
>>>>>>> 7df44b8 (- return 구문 finally 밖으로 이동)
    }

    // 당첨 정보 입력 및 생성
    public static LottoWinning inputLottoWinning() {
        LottoWinning lottoWinning = null;
        while(lottoWinning == null) {
            LottoOutput.printString(LottoInputData.REQUEST_COMMNET_OF_WINNING);
            lottoWinning = LottoInput.inputWinning();
        }
        return lottoWinning;
>>>>>>> 4f43f8b (1차 Commit)
    }
    public static boolean inputBonusBallToWinning(LottoWinning lottoWinning) {
        boolean success = true;
        try {
            lottoWinning.setBonusBall(LottoInput.inputBonusBall());
        } catch (PickedNumberRangeException e) {
            e.printStackTrace();
            success = false;
        }
        return success;
    }

    // 로또 정보 출력
    public static void printLottosInfo(Lottos lottos) {
        LottoOutput.printResult(lottos);
    }
<<<<<<< HEAD
<<<<<<< HEAD
=======
>>>>>>> 4f43f8b (1차 Commit)

    // 당첨결과 출력
    public static void printLottoWinning(Integer moneyToBuyLotto, Lottos lottos, LottoWinning lottoWinning) {
        LottoOutput.printLottoWinning(moneyToBuyLotto, lottos, lottoWinning);
    }
<<<<<<< HEAD
=======
>>>>>>> edb2074 (1일차 중간 PR)
=======
>>>>>>> 4f43f8b (1차 Commit)
}
