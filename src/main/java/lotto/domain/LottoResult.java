package lotto.domain;

import java.util.HashMap;
import java.util.List;

public class LottoResult {
    private HashMap<Rank, Integer> matchMap;
    private int profitRate;

    LottoResult(int moneyAmount,
                List<LottoNumbers> lottos,
                LottoNumbers winningLottoNumbers,
                int bonusWinningLottoNumber) {

        initMatchMap();
        evaluateResult(moneyAmount, lottos, winningLottoNumbers, bonusWinningLottoNumber);
    }

    private void initMatchMap() {
        matchMap = new HashMap<>();
        for (Rank rank : Rank.values()) {
            matchMap.put(rank, 0);
        }
    }

    private void evaluateResult(int moneyAmount,
                               List<LottoNumbers> lottos,
                               LottoNumbers winningLottoNumbers,
                               int bonusWinningLottoNumber) {
        int cntOfMatch;
        Rank rank;
        for (LottoNumbers ln : lottos) {
            cntOfMatch = countMatchingNumbers(ln, winningLottoNumbers);
            rank = evaluateRank(cntOfMatch, ln.contains(bonusWinningLottoNumber));
            increaseCntOfMatch(rank);
        }
        calculateProfit(moneyAmount);
    }

    private void increaseCntOfMatch(Rank rank) {
        try {
            matchMap.put(rank, matchMap.get(rank) + 1);
        } catch (Exception e) {
            return;
        }
    }

    private Rank evaluateRank(int cntOfMatch, boolean isBonus) {
        if (cntOfMatch == Rank.FIFTH.getCntOfMatch()) return Rank.FIFTH;
        if (cntOfMatch == Rank.FOURTH.getCntOfMatch()) return Rank.FOURTH;
        if (cntOfMatch == Rank.THIRD.getCntOfMatch()) return isBonus ? Rank.SECOND : Rank.THIRD;
        if (cntOfMatch == Rank.FIRST.getCntOfMatch()) return Rank.FIRST;
        return Rank.NONE;
    }

    private int countMatchingNumbers(LottoNumbers ln, LottoNumbers winningLottoNumbers) {
        int cnt = 0;
        for (int index = 0; index < ln.size(); index++) {
            cnt += ln.contains(winningLottoNumbers.getElByIndex(index)) ? 1 : 0;
        }
        return cnt;
    }

    private void calculateProfit(int moneyAmount) {
        int totalValue = 0;
        for (Rank rank : Rank.values()) {
            totalValue += matchMap.get(rank) * rank.getWinningMoney();
        }
        profitRate = 100*(totalValue - moneyAmount)/moneyAmount;
    }

    public HashMap<Rank, Integer> getMatchMap() {
        return matchMap;
    }

    public int getProfitRate() {
        return profitRate;
    }
}
