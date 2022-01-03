package be.w2.lotto.result;

import java.util.Map;

public class WinningStatMaker {

    public static final String OPEN_WORD = "당첨 통계\n---------\n";

    private Result result;
    private int investment;

    public WinningStatMaker(Result result, int investment) {
        this.result = result;
        this.investment = investment;
    }

    public String getStringOfWinningStat() {
        StringBuilder sb = new StringBuilder();
        sb.append(OPEN_WORD);
        Map<RewardForCorrect, Integer> winningStat = result.getStat();
        for(RewardForCorrect rewardForCorrect: winningStat.keySet()) {
            writeHowManyCorrect(sb, rewardForCorrect, winningStat.get(rewardForCorrect));
        }
        writeYield(sb);
        return sb.toString();
    }

    private void writeHowManyCorrect(StringBuilder sb, RewardForCorrect rewardForCorrect, Integer howMany) {
        sb.append(rewardForCorrect.getHowManyCorrect())
                .append("개 일치 (")
                .append(rewardForCorrect.getReward())
                .append(")- ")
                .append(howMany)
                .append("개\n");
    }

    private void writeYield(StringBuilder sb) {
        sb.append("총 수익률은 ")
                .append(calculateYield())
                .append("%입니다.");
    }

    private int calculateYield() {
        return ((result.getRevenue() - investment) / investment) * 100;
    }
}
