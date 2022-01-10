package lotto.domain;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import lotto.LottoGame;

public class Result {

    final float yield;
    final Map<Rank, Integer> result;

    public Result(float yield, Map<Rank, Integer> result) {
        this.yield = yield;
        this.result = result;
    }

    public static Result valueOf(Lottos lottos, WinningLotto winningLotto) {
        float profit = 0;
        Map<Rank, Integer> result = new HashMap<>();
        for (Lotto lotto : lottos.getLottos()) {
            Rank rank = Rank.valueOf(
                getCountOfMatch(lotto.getLottoNumber(), winningLotto.getWinningLotto()),
                isContainBonusNumber(lotto, winningLotto.getBonusNumber()));
            if (rank != null) {
                putRankResult(rank, result);
                profit += rank.getWinningMoney();
            }
        }
        return new Result(getCalculateYield(profit, lottos.getLottos().size()), result);
    }

    private static int getCountOfMatch(List<Integer> lottoNumber, List<Integer> winningLotto) {
        return (int)lottoNumber.stream()
            .filter(winningLotto::contains)
            .count();
    }

    private static boolean isContainBonusNumber(Lotto lotto, int bonusNumber) {
        if (lotto.getLottoNumber().contains(bonusNumber)) {
            return true;
        }
        return false;
    }

    private static void putRankResult(Rank rank, Map<Rank, Integer> result) {
        if (result.containsKey(rank)) {
            result.put(rank, result.get(rank) + 1);
            return;
        }
        result.put(rank, 1);
    }

    public static float getCalculateYield(float profit, int CountOfGame) {
        return (profit - CountOfGame * LottoGame.getGameCost()) / (CountOfGame
            * LottoGame.getGameCost()) * 100;
    }

    public float getYield() {
        return yield;
    }

    public Map<Rank, Integer> getResult() {
        return result;
    }
}
