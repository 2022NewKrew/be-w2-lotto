package be.w2.lotto.view.output;

import be.w2.lotto.lottos.Lotto;
import be.w2.lotto.lottos.LottoNumber;

import java.util.List;
import java.util.stream.Collectors;

final class LottoOutput {

    private LottoOutput() {
    }

    static String getOutput(List<Lotto> lottos) {
        StringBuilder sb = new StringBuilder();
        writeOutputOfLottosTo(sb, lottos);
        return sb.toString();
    }

    private static void writeOutputOfLottosTo(StringBuilder sb, List<Lotto> lottos) {
        for (Lotto lotto : lottos) {
            writeOutputOfLottoTo(sb, lotto);
        }
    }

    private static void writeOutputOfLottoTo(StringBuilder sb, Lotto lotto) {
        writeOpenSignOfLottoTo(sb);
        writeContentsOfLottoTo(sb, lotto);
        writeCloseSignOfLottoTo(sb);
    }

    private static void writeOpenSignOfLottoTo(StringBuilder sb) {
        sb.append("[");
    }

    private static void writeContentsOfLottoTo(StringBuilder sb, Lotto lotto) {
        List<LottoNumber> numbers = lotto.getNumbers();
        List<String> stringOfNumbers = numbers.stream()
                .map(LottoNumber::toString)
                .collect(Collectors.toList());
        sb.append(String.join(", ", stringOfNumbers));
    }

    private static void writeCloseSignOfLottoTo(StringBuilder sb) {
        sb.append("]\n");
    }
}
