package lotto.domain;

import lotto.VO.LackOfMoneyException;
import lotto.model.Lotto;
import lotto.model.WinningLotto;

import java.util.*;

public class LottoApp {
    public static final LottoGenerator GENERATOR = new LottoGenerator();


    private final Lottos lottos = new Lottos();
    private WinningLotto winningLotto;
    private LottoResultManager resultManager;
    private int accumPayment;
    private int countOfCustomLotto;

    public LottoApp() {
        this.accumPayment = 0;
        this.countOfCustomLotto = 0;
    }


    public void purchaseLotto(Money payment) throws LackOfMoneyException {
        int numOfNewLotto = payment.getAmount() / Lotto.PRICE;
        purchaseLotto(payment, numOfNewLotto);
    }

    public void purchaseLotto(Money payment, int numOfNewLotto) throws LackOfMoneyException {
        try {
            payment.decrement(numOfNewLotto * Lotto.PRICE);
        } catch (LackOfMoneyException e) {
            throw e;
        }

        for (int i = 0; i < numOfNewLotto; i++) {
            this.lottos.add(GENERATOR.generateLotto());
        }
        this.accumPayment += numOfNewLotto * Lotto.PRICE;
        System.out.println(numOfNewLotto + "개를 구매했습니다.");
    }

    public void purchaseCustomLotto(Money payment, Lotto lotto) throws LackOfMoneyException {
        try {
            payment.decrement(Lotto.PRICE);
        } catch (LackOfMoneyException e) {
            throw e;
        }

        this.lottos.add(lotto);
        this.accumPayment += Lotto.PRICE;
        this.countOfCustomLotto += 1;
    }

    public void purchaseCustomLottos(Money payment, List<Lotto> lottos) throws LackOfMoneyException {
        try {
            for (Lotto lotto : lottos) {
                purchaseCustomLotto(payment, lotto);
            }
        } catch (LackOfMoneyException e) {
            throw e;
        }
    }

    public LottoResult getLottoResult() {
        return resultManager.getLottoResult();
    }

    public float calculateRateOfReturn() {
        if (resultManager == null) {
            return 0.0f;
        }
        return (float) (resultManager.getTotalReturn() - accumPayment) / accumPayment * 100;
    }

    public void match() {
        this.resultManager = new LottoResultManager();
        for (Lotto lotto : this.lottos) {
            int countOfMatch = howManyMatch(lotto);
            boolean matchBonus = isMatchBonus(lotto);
            this.resultManager.addResult(countOfMatch, matchBonus);
        }
    }

    public int howManyMatch(Lotto lotto) {
        int count = 0;
        List<Integer> winningLottoNumbers = winningLotto.getNumbers();
        for (int i = 0; i < Lotto.N_NUMBERS; i++) {
            count += lotto.getNumbers().contains(winningLottoNumbers.get(i)) ? 1 : 0;
        }
        return count;
    }

    public boolean isMatchBonus(Lotto lotto) {
        return lotto.getNumbers().contains(winningLotto.getBonusNumber());
    }

    public void setWinLotto(WinningLotto winningLotto) {
        this.winningLotto = winningLotto;
    }

    public int getAccumPayment() {
        return this.accumPayment;
    }

    public int getCountOfLottos() {
        return this.lottos.size();
    }

    public int getCountOfCustomLotto() {
        return this.countOfCustomLotto;
    }

    public int getCountOfAutoLotto() {
        return this.getCountOfLottos() - getCountOfCustomLotto();
    }

    public Lottos getLottos() {
        return this.lottos;
    }

    public String toString() {
        return this.lottos.toString();
    }

}
