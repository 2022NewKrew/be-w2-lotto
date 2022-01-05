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


    public int purchaseLotto(Money payment) throws IllegalArgumentException{
        int numOfNewLotto = payment.getAmount() / Lotto.PRICE;
        return purchaseLotto(payment, numOfNewLotto);
    }

    public int purchaseLotto(Money payment, int numOfNewLotto) throws IllegalArgumentException{
        try{
            payment.decrement(numOfNewLotto * Lotto.PRICE);
        }catch(IllegalArgumentException e){
            throw new IllegalArgumentException();
        }


        for (int i = 0; i < numOfNewLotto; i++) {
            this.lottos.add(GENERATOR.generateLotto());
        }
        this.accumPayment += numOfNewLotto * Lotto.PRICE;
        System.out.println(numOfNewLotto + "개를 구매했습니다.");
        return numOfNewLotto;
    }

    public int purchaseCustomLotto(Money payment, Lotto lotto) throws IllegalArgumentException{
        try{
            payment.decrement(Lotto.PRICE);
        }catch(IllegalArgumentException e){
            throw new IllegalArgumentException();
        }

        this.lottos.add(lotto);
        this.accumPayment += Lotto.PRICE;
        return 1;
    }



    public String getResultString() {
        if (this.winningLotto == null) {
            return "지난 주 로또 번호가 입력되지 않았습니다.";
        }

        this.compareHowManyMatch();

        StringBuilder builder = new StringBuilder();
        builder.append(this.rewards.toString());
        builder.append("총 수익률은 ");


        builder.append(String.format("%.2f%%", (float) (rewards.getTotalReward() - accumPayment) / accumPayment * 100));


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
