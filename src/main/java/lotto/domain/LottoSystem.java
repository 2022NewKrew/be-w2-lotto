package lotto.domain;

import lotto.view.LottoInput;
import lotto.view.LottoOutput;

import java.util.ArrayList;
import java.util.List;

import static lotto.constant.LottoConstant.LOTTO_PRICE;

public class LottoSystem {
    int totalCost;
    int lottoCount;

    List<Lotto> userLottos;
    Lotto pastWinningLotto;
    LottoStatistic lottoStatistic;
    LottoInput lottoInput;
    LottoOutput lottoOutput;

    public LottoSystem() {
        lottoInput = new LottoInput();
        lottoOutput = new LottoOutput();
    }

    public void start() {
        buyLottos();
        enterPastWinningLotto();
        calculateStatistic();
    }

    private void buyLottos() {
        lottoOutput.printEnterMoney();
        totalCost = lottoInput.enterMoney();
        lottoCount = calculateCount(totalCost);
        lottoOutput.printNumberOfLotto(lottoCount);
        userLottos = generateRandomLottos(lottoCount);
        lottoOutput.printLottos(userLottos);
    }

    private static int calculateCount(int money) {
        return money / LOTTO_PRICE;
    }

    private static List<Lotto> generateRandomLottos(int num) {
        List<Lotto> lottos = new ArrayList<Lotto>();
        for (int i = 0; i < num; i++) {
            Lotto lotto = new Lotto();
            lotto.generateRandomLotto();
            lottos.add(lotto);
        }
        return lottos;
    }

    private void enterPastWinningLotto() {
        lottoOutput.printEnterPastWinningLotto();
        pastWinningLotto = lottoInput.enterPastWinningLotto();
    }

    private void calculateStatistic() {
        lottoStatistic = generateStatistic(userLottos, pastWinningLotto);
        lottoOutput.printWinningStatistic(lottoStatistic);
    }

    private static LottoStatistic generateStatistic(List<Lotto> lottos, Lotto lotto) {
        LottoStatistic lottoStatistic = new LottoStatistic();
        lottoStatistic.initialize(lottos, lotto);
        return lottoStatistic;
    }
}
