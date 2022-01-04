package com.kakao.io;

import com.kakao.data.io.LottoInputData;
import com.kakao.exception.MoneyRangeException;
import com.kakao.model.LottoWinning;
import com.kakao.model.Lottos;

public class LottoIO {
    private LottoIO() {}

    // 돈 입력받기
    public static Integer inputMoney() {
        LottoOutput.printString(LottoInputData.REQUEST_COMMNET_OF_PRICE);
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
    }

    // 당첨 정보 입력 및 생성
    public static LottoWinning inputLottoWinning() {
        LottoWinning lottoWinning = null;
        while(lottoWinning == null) {
            LottoOutput.printString(LottoInputData.REQUEST_COMMNET_OF_WINNING);
            lottoWinning = LottoInput.inputWinning();
        }
        return lottoWinning;
    }

    // 로또 정보 출력
    public static void printLottosInfo(Lottos lottos) {
        LottoOutput.printResult(lottos);
    }

    // 당첨결과 출력
    public static void printLottoWinning(Integer moneyToBuyLotto, Lottos lottos, LottoWinning lottoWinning) {
        LottoOutput.printLottoWinning(moneyToBuyLotto, lottos, lottoWinning);
    }
}
