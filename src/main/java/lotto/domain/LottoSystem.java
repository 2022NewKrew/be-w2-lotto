package lotto.domain;

import lotto.view.LottoInput;
import lotto.view.LottoOutput;

import java.util.ArrayList;

public class LottoSystem {
    int totalCost;

    ArrayList<Lotto> userLottos;
    Lotto pastWinningLotto;
    LottoInput lottoInput;
    LottoOutput lottoOutput;

    public LottoSystem() {
        lottoInput = new LottoInput();
        lottoOutput = new LottoOutput();
    }

    public void start() {
        lottoOutput.printEnterMoney();
        totalCost = lottoInput.enterMoney();
        lottoOutput.printNumberOfLotto();
        lottoOutput.printLottos();
        lottoOutput.printEnterPastWinningLotto();
        pastWinningLotto = lottoInput.enterPastWinningLotto();
        lottoOutput.printWinningStatistic();
    }
}
