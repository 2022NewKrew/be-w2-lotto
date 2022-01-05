package be.w2.lotto.view.output;

import be.w2.lotto.result.Result;
import be.w2.lotto.result.RewardForCorrect;

import java.util.Map;

final class ResultOutput {

    private ResultOutput() {
    }

    public static String getOutput(Result result, int investment) {
        StringBuilder sb = new StringBuilder();
        writeOpenWordTo(sb);
        writeResultTo(sb, result);
        writeYieldTo(sb, result, investment);
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
                .append("(")
                .append(rewardForCorrect.getReward())
                .append(")- ")
                .append(howMany)
                .append("개\n");
    }

    private static void writeYieldTo(StringBuilder sb, Result result, int investment) {
        sb.append("총 수익률은 ")
                .append(calculateYield(result, investment))
                .append("%입니다.");
    }

    private static int calculateYield(Result result, int investment) {
        return ((result.getRevenue() - investment) / investment) * 100;
    }
}
