package lotto.domain;

import lotto.view.LottoInput;
import lotto.view.LottoOutput;

import java.util.ArrayList;

import static lotto.constant.LottoConstant.LOTTO_PRICE;

public class LottoSystem {
    int totalCost;
    int lottoCount;

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
        lottoCount = calculateCount(totalCost);
        lottoOutput.printNumberOfLotto(lottoCount);
        userLottos = generateRandomLottos(lottoCount);
        lottoOutput.printLottos(userLottos);
        lottoOutput.printEnterPastWinningLotto();
        pastWinningLotto = lottoInput.enterPastWinningLotto();
        lottoOutput.printWinningStatistic();
    }

    public static int calculateCount(int money) {
        return money / LOTTO_PRICE;
    }

    public static ArrayList<Lotto> generateRandomLottos(int num) {
        ArrayList<Lotto> lottos = new ArrayList<Lotto>();
        for (int i = 0; i < num; i++) {
            Lotto lotto = new Lotto();
            lotto.generateRandomLotto();
            lottos.add(lotto);
        }
        return lottos;
    }
}
