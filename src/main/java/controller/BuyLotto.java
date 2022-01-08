package controller;

import domain.LottoPack;
import view.LottoOutput;

import java.util.List;

public class BuyLotto {
    public BuyLotto() {

    }

    public static LottoPack buy(int buyPrice) {
        LottoPack lottoPack = new LottoPack(buyPrice);
        return lottoPack;
    }


    public static void printLottoPack(LottoPack lottoPack) {
        LottoOutput.printLottoPack(lottoPack);
    }

}
