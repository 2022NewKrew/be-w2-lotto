package be.w2.lotto.view.output;

import be.w2.lotto.result.Result;
import be.w2.lotto.result.RewardForCorrect;

import java.util.Map;

final class ResultOutput {

    private ResultOutput() {
    }

    public static String getOutput(Result result) {
        StringBuilder sb = new StringBuilder();
        writeOpenWordTo(sb);
        writeResultTo(sb, result);
        return sb.toString();
    }

    private static void writeOpenWordTo(StringBuilder sb) {
        sb.append("당첨 통계\n---------\n");
    }

    private static void writeResultTo(StringBuilder sb, Result result) {
        Map<RewardForCorrect, Integer> winningStat = result.getStat();
        for (RewardForCorrect rewardForCorrect : winningStat.keySet()) {
            writeHowManyCorrectTo(sb, rewardForCorrect, winningStat.get(rewardForCorrect));
        }
    }

    private static void writeHowManyCorrectTo(StringBuilder sb, RewardForCorrect rewardForCorrect, Integer howMany) {
        sb.append(RewardForCorrectOutput.getOutput(rewardForCorrect))
                .append(howMany)
                .append("개\n");
    }
}
