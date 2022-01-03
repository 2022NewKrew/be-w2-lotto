package lotto;

import lotto.domain.LottoPack;
import lotto.view.IO;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        IO io = new IO();
        int itemCnt = io.start();

        LottoPack lottoPack = new LottoPack(itemCnt);
        List<List<Integer>> lottoNums = lottoPack.getNumList();

        io.printPurchasedLottos(lottoNums);

        List<Integer> prevNums = io.enterPrevNums();
    }
}
