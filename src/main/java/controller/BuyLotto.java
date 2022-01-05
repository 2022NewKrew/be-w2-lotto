package controller;

import domain.Lotto;
import domain.LottoPack;

public class BuyLotto {
    public static final int LottoPrice = 1000;
    LottoPack lottoPack = new LottoPack();

    public BuyLotto(int buyPrice){
        int numberOfLotto = buyPrice / LottoPrice;
        for (int i = 0; i < numberOfLotto; i++) {
            lottoPack.add(new Lotto());
        }
    }

}
