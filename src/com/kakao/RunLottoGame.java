package com.kakao;

import com.kakao.domain.Lotto;
import com.kakao.domain.WinningLotto;
import com.kakao.ui.GameInput;
import com.kakao.ui.GameOutput;

import java.util.*;

public class RunLottoGame {

    public static GameInput gameInput = new GameInput();
    public static GameOutput gameOutput = new GameOutput();

    public static void main(String[] args) {
        int money = gameInput.inputMoney();
        List<Lotto> lottos = gameInput.buyLottos(money);
        gameOutput.printLottos(lottos);

        WinningLotto winningLotto = gameInput.inputWinningLotto();
        gameOutput.printResult(money, lottos, winningLotto);
    }
}
