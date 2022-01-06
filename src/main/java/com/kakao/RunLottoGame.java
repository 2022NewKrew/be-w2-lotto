package com.kakao;

import com.kakao.domain.Lotto;
import com.kakao.domain.LottoMachine;
import com.kakao.domain.Result;
import com.kakao.domain.WinningLotto;
import com.kakao.ui.GameInput;
import com.kakao.ui.GameOutput;

import java.util.*;

public class RunLottoGame {

    private final GameInput gameInput = new GameInput();
    private final GameOutput gameOutput = new GameOutput();
    private final LottoMachine lottoMachine = new LottoMachine();

    public static void main(String[] args) {
        RunLottoGame runLottoGame = new RunLottoGame();
        runLottoGame.run();
    }

    public void run() {
        int money = gameInput.inputMoney();
        List<Lotto> lottos = buyLottos(money);

        gameOutput.printLottos(lottos);

        WinningLotto winningLotto = setWinningLotto();

        Result result = lottoMachine.setResult(money, lottos, winningLotto);
        gameOutput.printTotalResult(result);
    }

    private List<Lotto> buyLottos(int money) {
        List<List<Integer>> customLottoNumbersList = gameInput.inputCustomLottos(money);
        return lottoMachine.buyLottos(money, customLottoNumbersList);
    }

    private WinningLotto setWinningLotto() {
        List<Integer> winningLottoNumbers = gameInput.inputWinningLotto();
        int bonusNumber = gameInput.inputBonusNumber(winningLottoNumbers);
        return lottoMachine.setWinningLotto(winningLottoNumbers, bonusNumber);
    }
}
