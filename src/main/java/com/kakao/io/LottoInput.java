package com.kakao.io;

<<<<<<< HEAD
import com.kakao.exception.PickedNumberException;
import com.kakao.helper.TextHelper;
import com.kakao.data.io.LottoInputData;
import com.kakao.exception.PickedNumbersFormatException;
import com.kakao.model.LottoWinning;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

class LottoInput {
    private LottoInput() {}

=======
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class LottoInput {
>>>>>>> edb2074 (1일차 중간 PR)
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static Integer inputMoney() {
        Integer money = null; // 기본값은 null 이므로, 에러가 발생하면 null 반환
        try {
            money = Integer.parseInt(br.readLine());
        } catch (IOException | NumberFormatException e) {
            e.printStackTrace();
<<<<<<< HEAD
        }
        return money;
    }

    public static LottoWinning inputWinning() {
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
    public static Integer inputBonusBall() {
        Integer bonusBallNumber = null;
        try {
            bonusBallNumber = Integer.parseInt(br.readLine());
        } catch (IOException | NumberFormatException e ) {
            e.printStackTrace();
        }
        return bonusBallNumber;
=======
        } finally { // 반드시 값을 반환
            return money;
        }
>>>>>>> edb2074 (1일차 중간 PR)
    }
}
