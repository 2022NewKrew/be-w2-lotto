package com.kakao.lotto.controller;

import com.kakao.lotto.model.LottoResultCheck;
import com.kakao.lotto.model.SystemLotto;
import com.kakao.lotto.model.UserLotto;
import com.kakao.lotto.view.PrintResult;
import com.kakao.lotto.view.UserLottoInput;

/**
 * author    : brody.moon
 * version   : 1.0
 * 컨트롤러 클래스입니다.
 * Model 과 View 를 이어주는 역활을 합니다.
 */
public class Controller {
    /**
     * Model 의 사용자의 로또와 당첨 로또 클래스를 가지고 있습니다ㅏ.
     * View 로 보여줄 프린트 클래스도 가지고 있습니다.
     */
    private final UserLotto userLotto;
    private final SystemLotto systemLotto;
    private final PrintResult printResult;

    public Controller() {
        userLotto = new UserLotto(new UserLottoInput.Builder()
                .setNumberOfAllNumber()
                .setNumberOfCustomNumber()
                .setCustomLottos()
                .build());

        systemLotto = new SystemLotto();

        printResult = new PrintResult(userLotto.getLottoNumbers(), userLotto.getNumOfCustomLotto(), systemLotto.getWinningLottoNumbers(), systemLotto.getBonus());
    }

    /**
     * Model 과 View 사이의 프로그램 진행 과정을 모아준 메서드입니다.
     */
    public void start() {
        printResult.printBuyLottoNumbers();

        System.out.println();

        printResult.printWinningLottoNumber();

        LottoResultCheck lottoResultCheck = new LottoResultCheck(userLotto.getLottoNumbers(), systemLotto.getWinningLottoNumbers(), systemLotto.getBonus());

        printResult.printAllLottoResult(lottoResultCheck.lottoResult());
    }


}
