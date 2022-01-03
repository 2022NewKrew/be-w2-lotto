package lotto;

import lotto.domain.LottoPack;
import lotto.view.IO;

public class Main {
    public static void main(String[] args) {
        IO io = new IO();
        int itemCnt = io.start();
        LottoPack lottoPack = new LottoPack(itemCnt);
    }
}
