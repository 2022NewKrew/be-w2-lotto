package view.Printer;

import domain.Lotto;

public class LottoPrinter {
    public static void print(Lotto lotto) {
        System.out.println(String.join(", ", lotto.getLottoSequence().toString()));
    }
}
