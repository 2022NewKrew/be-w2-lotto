package be.w2.lotto.view.output;

import be.w2.lotto.lottos.Lotto;

import java.util.List;

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
        List<String> stringOfNumbers = lotto.getListOfStringForLottoNumbers();
        sb.append(String.join(", ", stringOfNumbers));
    }

    private static void writeCloseSignOfLottoTo(StringBuilder sb) {
        sb.append("]\n");
    }
}
