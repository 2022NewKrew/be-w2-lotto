package com.kakao;

import com.kakao.domain.Lotto;
import com.kakao.domain.WinningLotto;
import com.kakao.ui.GameInput;
import com.kakao.ui.GameOutput;

import java.util.*;

public class RunLottoGame {

    private final GameInput gameInput = new GameInput();
    private final GameOutput gameOutput = new GameOutput();

    public void run() {
        int money = gameInput.inputMoney();
        List<Lotto> lottos = gameInput.buyLottos(money);
        gameOutput.printLottos(lottos);

        WinningLotto winningLotto = gameInput.inputWinningLotto();
        gameOutput.printTotalResult(money, lottos, winningLotto);
    }

    public static void main(String[] args) {
        RunLottoGame runLottoGame = new RunLottoGame();
        runLottoGame.run();
    }
}
