package lottery.web.dto;

import java.util.ArrayList;
import java.util.HashMap;

public class LotteryResultDto {

    private HashMap<Integer, Integer> matchResult;
    private Integer budget;
    private Double earningRate;

    public ArrayList<String> getMessages() {
        return messages;
    }

    private ArrayList<String> messages = new ArrayList<>();

    public Double getEarningRate() {
        return earningRate;
    }

    public HashMap<Integer, Integer> getMatchCnt() {
        return matchResult;
    }

    public LotteryResultDto(HashMap<Integer, Integer> result, int budget) {
        this.matchResult = result;
        this.budget = budget;
    }

    public String toString() {
        if (matchResult.get(-1) == null) return getResult();
        return getResultWithBonus();
    }

    private String getResult() {
        StringBuffer str = new StringBuffer("당첨 통계\n-----------\n");
        messages.add("당첨 통계\n-----------\n");
        int totalReward = 0;
        for (LotteryRank lotteryRank : LotteryRank.values()) {
            int matchCnt = lotteryRank.getMatchCnt();
            int reward = lotteryRank.getReward();
            int numOfMatchedLottery = matchResult.get(matchCnt);
            str.append(matchCnt + "개 일치 (" + reward + "원): " + numOfMatchedLottery + "\n");
            messages.add(matchCnt + "개 일치 (" + reward + "원): " + numOfMatchedLottery + "\n");
            totalReward += reward * numOfMatchedLottery;
        }
        this.earningRate = calculateEarningRate(totalReward);
        str.append("총 상금은 " + totalReward + "원, 수익률은 " + String.format("%.2f", this.earningRate) + "% 입니다.");
        return str.toString();
    }

    private String getResultWithBonus() {
        StringBuffer str = new StringBuffer("당첨 통계\n-----------\n");
        messages.add("당첨 통계\n-----------\n");
        int totalReward = 0;
        for (LotteryRank lotteryRank : LotteryRank.values()) {
            int matchCnt = lotteryRank.getMatchCnt();
            int reward = lotteryRank.getReward();
            int numOfMatchedLottery = matchResult.get(matchCnt);
            if (matchCnt == -1) {
                str.append("5개 일치, 보너스 볼 일치 (" + reward + "원): " + numOfMatchedLottery + "\n");
                messages.add("5개 일치, 보너스 볼 일치 (" + reward + "원): " + numOfMatchedLottery + "\n");
            }
            else {
                str.append(matchCnt + "개 일치 (" + reward + "원): " + numOfMatchedLottery + "\n");
                messages.add(matchCnt + "개 일치 (" + reward + "원): " + numOfMatchedLottery + "\n");
            }
            totalReward += reward * numOfMatchedLottery;
        }
        earningRate = calculateEarningRate(totalReward);
        str.append("총 상금은 " + totalReward + "원, 수익률은 " + String.format("%.2f", earningRate) + "% 입니다.");
        return str.toString();
    }

    private Double calculateEarningRate(Integer totalReward) {
        return (totalReward.doubleValue() - budget.doubleValue()) / budget.doubleValue() * 100;
    }

}
