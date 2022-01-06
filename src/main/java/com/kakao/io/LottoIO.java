package com.kakao.io;

import com.kakao.data.LottoData;
import com.kakao.data.io.LottoInputData;
import com.kakao.exception.MoneyRangeException;
import com.kakao.exception.PickedNumberRangeException;
import com.kakao.model.lotto.Lotto;
import com.kakao.model.LottoWinning;
import com.kakao.model.Lottos;

import java.util.ArrayList;
import java.util.List;

public class LottoIO {
    private LottoIO() {}

    // 돈 입력받기
    public static Integer inputMoney() {
        String requestPrice = String.format(LottoInputData.REQUEST_COMMNET_OF_PRICE, LottoData.PRICE_OF_LOTTO);
        LottoOutput.printString(requestPrice);
        return LottoInput.inputSingleNumber();
    }

    // 수동 로또 갯수 입력
    public static Integer inputCountOfManualLotto () {
        LottoOutput.printString(LottoInputData.REQUEST_COMMENT_OF_MANUAL_LOTTO_COUNT);
        return LottoInput.inputSingleNumber();
    }
    // 수동 로또 구매
    public static List<Lotto> buyManualLottos () {
        List<Lotto> newManualLottoList = new ArrayList<>();
        return newManualLottoList;
    }
    private static Lotto inputManualLotto () {
        Lotto newManualLotto = null;
        return newManualLotto;
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
        do {
            LottoOutput.printString(LottoInputData.REQUEST_COMMENT_OF_BONUS_BALL);
        } while(!inputBonusBallToWinning(lottoWinning));
        return lottoWinning;
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

    // 당첨결과 출력
    public static void printLottoWinning(Integer moneyToBuyLotto, Lottos lottos, LottoWinning lottoWinning) {
        LottoOutput.printLottoWinning(moneyToBuyLotto, lottos, lottoWinning);
    }
}
