package be.w2.lotto.view.output;

import be.w2.lotto.lottos.Lotto;

import java.util.List;

final class LottoOutput implements ClassOutput<Lotto> {

    LottoOutput() {
    }

    @Override
    public String getOutput(Lotto lotto) {
        StringBuilder sb = new StringBuilder();
        writeOutputOfLottoTo(sb, lotto);
        return sb.toString();
    }

    private void writeOutputOfLottoTo(StringBuilder sb, Lotto lotto) {
        writeOpenSignOfLottoTo(sb);
        writeContentsOfLottoTo(sb, lotto);
        writeCloseSignOfLottoTo(sb);
    }

    private void writeOpenSignOfLottoTo(StringBuilder sb) {
        sb.append("[");
    }

    private void writeContentsOfLottoTo(StringBuilder sb, Lotto lotto) {
        List<String> stringOfNumbers = lotto.getListOfStringForLottoNumbers();
        sb.append(String.join(", ", stringOfNumbers));
    }

    private void writeCloseSignOfLottoTo(StringBuilder sb) {
        sb.append("]");
    }
}
