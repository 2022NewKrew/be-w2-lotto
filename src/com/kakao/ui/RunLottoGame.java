package com.kakao.ui;

import com.kakao.domain.Lotto;
import com.kakao.domain.WinningLotto;

import java.util.*;

public class RunLottoGame {

    public static GameInput gameInput = new GameInput();
    public static GameOutput gameOutput = new GameOutput();

    public static void main(String[] args) {
        List<Lotto> lottos = gameInput.inputMoney();
        gameOutput.printLottos(lottos);

        WinningLotto winningLotto = gameInput.inputWinningLotto();
        gameOutput.printResult(lottos, winningLotto);
    }
}
