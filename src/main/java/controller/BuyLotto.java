package controller;

import domain.Lotto;
import domain.LottoPack;
import view.LottoOutput;

public class BuyLotto {
    public static int buyPrice = 0;
    public static final int LottoPrice = 1000;
    public static final LottoPack lottoPack = new LottoPack();
    public BuyLotto(int buyPrice){
        buy(buyPrice);
        printLottoPack();
    }

    public void buy(int buyPrice){
        this.buyPrice = buyPrice;
        int numberOfLotto = buyPrice / LottoPrice;
        for (int i = 0; i < numberOfLotto; i++) {
            lottoPack.add(new Lotto());
        }
    }
    private void printLottoPack(){
        LottoOutput.printLottoPack(lottoPack);
    }

}
