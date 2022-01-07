package controller;

import domain.Generator.AutoLottoGenerator;
import domain.Lotto;
import domain.LottoPack;
import view.LottoInput;
import view.LottoOutput;

public class BuyLotto {
    public static final int LottoPrice = 1000;

    public BuyLotto() {

    }

    public static LottoPack buy(int buyPrice) {
        LottoPack lottoPack = new LottoPack(buyPrice);
        int numberOfLotto = buyPrice / LottoPrice;
        AutoLottoGenerator autoLottoGenerator = new AutoLottoGenerator();
        for (int i = 0; i < numberOfLotto; i++) {
            lottoPack.add(autoLottoGenerator.generateLotto());
        }
        return lottoPack;
    }

    public static void printLottoPack(LottoPack lottoPack) {
        LottoOutput.printLottoPack(lottoPack);
    }

}
