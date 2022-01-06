package com.kakao.io;


import com.kakao.exception.PickedNumberException;
import com.kakao.helper.TextHelper;
import com.kakao.data.io.LottoInputData;
import com.kakao.model.LottoWinning;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

class LottoInput {
    private LottoInput() {}

    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    // 단일 숫자 입력
    static Integer inputSingleNumber() {
        Integer number = null; // 기본값은 null 이므로, 에러가 발생하면 null 반환
        try {
            number = Integer.parseInt(br.readLine());
        } catch (IOException | NumberFormatException e) {
            e.printStackTrace();
        }
        return number;
    }

    // 로또 당첨 정보
    static LottoWinning inputWinning() {
        LottoWinning lottoWinning = null;
        try {
            List<String> strList = TextHelper.seperateString(br.readLine(), LottoInputData.REQUEST_SEPERATOR_OF_WINNING);
            List<Integer> winningList = TextHelper.convertListType(strList, Integer::parseInt);
            lottoWinning = new LottoWinning(winningList);
        } catch (IOException | NumberFormatException | PickedNumberException e) {
            e.printStackTrace();
        }
        return lottoWinning;
    }
    // 보너스볼
    static Integer inputBonusBall() {
        Integer bonusBallNumber = null;
        try {
            bonusBallNumber = Integer.parseInt(br.readLine());
        } catch (IOException | NumberFormatException e ) {
            e.printStackTrace();
        }
        return bonusBallNumber;
    }
}
