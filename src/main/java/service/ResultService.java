package service;

import domain.Number;
import domain.Lotto;
import domain.Result;
import domain.WinningLotto;
import enums.Rank;

import java.util.ArrayList;
import java.util.List;

import static utils.Symbol.LOTTO_PRICE;

public class ResultService {
    List<Result> results;

    public ResultService() {
        results = new ArrayList<>();
    }

    public void generateResult(List<Lotto> lottoList, WinningLotto winningLotto) {
        for (Lotto lotto : lottoList) {
            int count = lotto.getHitCount(winningLotto.getLotto());
            Number bonusNumber = winningLotto.getBonusNumber();
            Boolean isBonus = (lotto.isHit(bonusNumber) != 0);

            Result result = new Result(count, isBonus);
            results.add(result);
        }
    }

    public int getCountRank(Rank rank) {
        int count = 0;
        for (Result result : results) {
            Rank resultRank = result.getResultRank();
            count += isSameRank(resultRank, rank);
        }
        return count;
    }

    public int isSameRank(Rank a, Rank b) {
        int sameCount = (a.equals(b)) ? 1 : 0;
        return sameCount;
    }

    public int getProfit() {
        int sum = 0;
        for (Result result : results) {
            Rank rank = result.getResultRank();
            sum += rank.getWinningMoney();
        }
        return sum;
    }

    public int getProfitRate() {
        int inputMoney = results.size() * LOTTO_PRICE;
        double profitRate = (double) getProfit() / inputMoney * 100;
        return (int) profitRate;
    }
}
