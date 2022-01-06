package com.kakao.io;


import com.kakao.exception.PickedNumberException;
import com.kakao.helper.TextHelper;
import com.kakao.data.io.LottoInputData;
import com.kakao.model.LottoNumbers;
import com.kakao.model.LottoWinning;
import com.kakao.model.lotto.Lotto;
import com.kakao.model.lotto.ManualLotto;

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

    // 로또값 직접 입력
    static LottoNumbers inputLottoNumbers() {
        LottoNumbers lottoNumbers = null;
        try {
            List<String> list = TextHelper.seperateString(br.readLine(), LottoInputData.REQUEST_SEPERATOR_OF_WINNING);
            List<Integer> winningList = TextHelper.convertListType(list, Integer::parseInt);
            lottoNumbers = new LottoNumbers(winningList);
        } catch (IOException | NumberFormatException | PickedNumberException e) {
            e.printStackTrace();
        }
        return lottoNumbers;
    }

    // 수동 로또
    static ManualLotto inputManualLotto() {
        LottoNumbers lottoNumbers = null;
        while(lottoNumbers == null) {
            lottoNumbers = inputLottoNumbers();
        }
        return new ManualLotto(lottoNumbers);
    }
    // 지난주 로또결과
    static LottoWinning inputWinning() {
        LottoNumbers lottoNumbers = inputLottoNumbers();
        if( lottoNumbers == null ) {
            return null;
        }
        return new LottoWinning(lottoNumbers);
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
