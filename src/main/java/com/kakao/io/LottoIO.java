package com.kakao.io;

import com.kakao.data.LottoData;
import com.kakao.data.io.LottoInputData;
import com.kakao.exception.MoneyRangeException;
import com.kakao.exception.PickedNumberRangeException;
import com.kakao.model.LottoNumbers;
import com.kakao.model.Money;
import com.kakao.model.lotto.Lotto;
import com.kakao.model.LottoWinning;
import com.kakao.model.Lottos;
import com.kakao.model.lotto.ManualLotto;

import java.util.ArrayList;
import java.util.List;

public class LottoIO {
    private LottoIO() {}

    // 돈 입력받기
    public static Money inputMoney() throws MoneyRangeException {
        String requestPrice = String.format(LottoInputData.REQUEST_COMMNET_OF_PRICE, LottoData.PRICE_OF_LOTTO);
        LottoOutput.printString(requestPrice);
        return new Money(LottoInput.inputSingleNumber());
    }

    // 수동 로또 갯수 입력
    public static Integer inputCountOfManualLotto () {
        LottoOutput.printString(LottoInputData.REQUEST_COMMENT_OF_MANUAL_LOTTO_COUNT);
        return LottoInput.inputSingleNumber();
    }

    // 수동 로또
    public static List<Lotto> inputManualLottos (int count) {
        LottoOutput.printString(LottoInputData.REQUEST_COMMENT_OF_MANUAL_LOTTO_NUMBER);

        List<Lotto> newManualLottoList = new ArrayList<>();
        for(int i=0; i<count; i++) {
            newManualLottoList.add(inputManualLotto());
        }
        return newManualLottoList;
    }
    private static ManualLotto inputManualLotto () {
        ManualLotto manualLotto = null;
        while(manualLotto == null){
            manualLotto = LottoInput.inputManualLotto();
        }
        return manualLotto;
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
    public static void printLottoWinning(Money moneyToBuyLotto, Lottos lottos, LottoWinning lottoWinning) {
        LottoOutput.printLottoWinning(moneyToBuyLotto, lottos, lottoWinning);
    }
}
