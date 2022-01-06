package controller;

import domain.Lotto;
import domain.LottoPack;
import view.LottoInput;
import view.LottoOutput;

public class BuyLotto {
    public static int buyPrice = 0;
    public static final int LottoPrice = 1000;

    public BuyLotto() {

    }

    public static LottoPack buy(int buyPrice) {
        LottoPack lottoPack = new LottoPack(buyPrice);
        BuyLotto.buyPrice = buyPrice;
        int numberOfLotto = buyPrice / LottoPrice;
        for (int i = 0; i < numberOfLotto; i++) {
            lottoPack.add(new Lotto());
        }
        return lottoPack;
    }

    public static void printLottoPack(LottoPack lottoPack) {
        LottoOutput.printLottoPack(lottoPack);
    }

}
