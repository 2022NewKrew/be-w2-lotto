package lotto.domain;

import java.util.*;

public class LottoApp {
    public static final LottoGenerator GENERATOR = new LottoGenerator();


    private final List<Lotto> lottos = new ArrayList<>();
    private WinningLotto winningLotto;
    private Rewards rewards;
    private int accumPayment;

    public LottoApp() {
        this.accumPayment = 0;
    }

    public void purchaseLotto(int payment) {
        int numOfNewLotto = payment / Lotto.PRICE;
        for (int i = 0; i < numOfNewLotto; i++) {
            this.lottos.add(GENERATOR.generateLotto());
        }
        System.out.println(numOfNewLotto + "개를 구매했습니다.");
        this.accumPayment += numOfNewLotto * Lotto.PRICE;
    }




    public String getResultString() {
        if (this.winningLotto == null) {
            return "지난 주 로또 번호가 입력되지 않았습니다.";
        }

        this.compareHowManyMatch();

        StringBuilder builder = new StringBuilder();
        builder.append(this.rewards.toString());
        builder.append("총 수익률은 ");

        builder.append(String.format("%.2f%%", (float) rewards.getTotalReward() / accumPayment * 100));

        builder.append("입니다.");

        return builder.toString();
    }

    public void compareHowManyMatch() {
        this.rewards = new Rewards();
        for (Lotto lotto : this.lottos) {
            int countOfMatch = lotto.howManyMatch(this.winningLotto);
            boolean matchBonus = lotto.isMatchBonus(this.winningLotto);
            this.rewards.addReward(countOfMatch, matchBonus);
        }
    }

    public void setWinLotto(WinningLotto winningLotto) {
        this.winningLotto = winningLotto;
    }

    public int getAccumPayment(){
        return this.accumPayment;
    }

    public int getCountOfLottos(){
        return this.lottos.size();
    }

    public String toString() {
        StringBuilder builder = new StringBuilder();
        for (Lotto lotto : lottos) {
            builder.append(lotto.toString());
            builder.append("\n");
        }
        return builder.toString();
    }

}
