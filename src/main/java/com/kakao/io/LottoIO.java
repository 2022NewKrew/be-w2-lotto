package com.kakao.io;

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
    }

    // 로또 정보 출력
    public static void printLottosInfo(Lottos lottos) {
        LottoOutput.printResult(lottos);
    }
}
