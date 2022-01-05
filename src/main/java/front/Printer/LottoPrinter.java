package front.Printer;

import dto.LottoDto;

public class LottoPrinter {
    public static void print(LottoDto lotto) {
        System.out.println(String.join(", ", lotto.getLottoSequence().toString()));
    }
}
