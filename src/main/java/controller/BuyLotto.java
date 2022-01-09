package controller;

import domain.Lotto;
import domain.LottoBundle;
import domain.LottoPack;
import view.LottoInput;
import view.LottoOutput;

import java.util.stream.Collectors;
import java.util.stream.Stream;

public class BuyLotto {
    public BuyLotto() {

    }

    public static LottoPack buy(int buyPrice) {
        LottoBundle manualLottoBundle = makeManual();
        int manualCount = manualLottoBundle.getCount();
        LottoBundle autoLottoBundle = new LottoBundle(LottoPack.getAutoCount(buyPrice, manualCount));
        return new LottoPack(buyPrice, manualCount, manualLottoBundle.concat(autoLottoBundle));
    }

    private static LottoBundle makeManual() {
        int manualCount = LottoInput.inputManualCount();
        String manualLottoString = LottoInput.inputManualLotto(manualCount);
        return new LottoBundle(
                Stream.of(manualLottoString.split("\n")).map(
                                Lotto::new).
                        collect(Collectors.toList()));
    }


    public static void printLottoPack(LottoPack lottoPack) {
        LottoOutput.printLottoPack(lottoPack);
    }

}
