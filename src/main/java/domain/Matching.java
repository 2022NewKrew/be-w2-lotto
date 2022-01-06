package domain;

import view.InputView;

import java.util.*;

import static domain.Prize.*;

public class Matching {

    private EnumMap<Prize, Integer> matchingMap = new EnumMap<>(Prize.class);

    public Integer getPrizeCount(Prize prize) {
        return matchingMap.getOrDefault(prize, 0);
    }

    public void addMatchingMap(Prize prize) {
        if (prize == NO_PRIZE)
            return;
        matchingMap.put(prize, matchingMap.getOrDefault(prize, 0) + 1);
    }

    public double calTotalEarningRate(int payPrice) {
        int sum = matchingMap.entrySet().stream().
                map(e -> e.getKey().getPrizeMoney() * e.getValue()).
                mapToInt(i -> i).sum();
        return (sum - payPrice)/(double)payPrice*100;
    }
/*
    public void addMatchingLotto(Player player) {
        List<Integer> winningNumber = InputView.getWinningInput();
        Integer bonusNumber = InputView.getBonusWinningInput();
        List<Integer> matchingLottos = player.matchingLotto(winningNumber);
        List<Boolean> matchingBonusLottos = player.matchingBonusLotto(bonusNumber);
        for (int i = 0; i < matchingLottos.size(); i++) {
            Prize prize = Prize.getPrize(matchingLottos.get(i), matchingBonusLottos.get(i));
            addMatchingMap(prize);
        }
    }
 */
    public void addMatchingLotto(Player player, List<Integer> winningNumber, Integer bonusNumber) {
        List<Integer> matchingLottos = player.matchingLotto(winningNumber);
        List<Boolean> matchingBonusLottos = player.matchingBonusLotto(bonusNumber);
        for (int i = 0; i < matchingLottos.size(); i++) {
            Prize prize = Prize.getPrize(matchingLottos.get(i), matchingBonusLottos.get(i));
            addMatchingMap(prize);
        }
    }
}