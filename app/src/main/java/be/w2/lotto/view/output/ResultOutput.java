package be.w2.lotto.view.output;

import be.w2.lotto.result.Result;
import be.w2.lotto.result.Winnings;

import java.util.Map;

final class ResultOutput implements ClassOutput<Result> {

    ResultOutput() {
    }

    @Override
    public String getOutput(Result result) {
        StringBuilder sb = new StringBuilder();
        writeOpenWordTo(sb);
        writeResultTo(sb, result);
        return sb.toString();
    }

    private void writeOpenWordTo(StringBuilder sb) {
        sb.append("당첨 통계\n---------\n");
    }

    private void writeResultTo(StringBuilder sb, Result result) {
        Map<Winnings, Integer> winningStat = result.getStat();
        for (Winnings winnings : winningStat.keySet()) {
            writeHowManyCorrectTo(sb, winnings, winningStat.get(winnings));
        }
    }

    private void writeHowManyCorrectTo(StringBuilder sb, Winnings winnings, Integer howMany) {
        sb.append(new WinningsOutput().getOutput(winnings))
                .append(howMany)
                .append("개\n");
    }
}
