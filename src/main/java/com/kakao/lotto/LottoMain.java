package com.kakao.lotto;

import com.kakao.lotto.controller.Controller;
import com.kakao.lotto.model.SystemLotto;
import com.kakao.lotto.model.UserLotto;

public class LottoMain {
    private static UserLotto userLotto;
    private static SystemLotto systemLotto;

    public static void main(String[] args) {
        //콘솔 실행 코드
        //Controller controller = new Controller();
        //controller.start();

        //Web UI 실행 코드
        Controller controller = new Controller(true);
        controller.run();
    }
}
