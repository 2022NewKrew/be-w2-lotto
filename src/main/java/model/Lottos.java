package model;

import CONST.Const;

import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Lottos {
    private final List<Lotto> lottos;

    public Lottos(int buyPrice) {
        int numLotto = buyPrice / 1000;
        this.lottos = IntStream
                .range(0, numLotto)
                .mapToObj(i -> new Lotto())
                .collect(Collectors.toList());
        System.out.println(numLotto + Const.BUY_COUNT);
    }

    @Override
    public String toString() {
        return lottos
                .stream()
                .map(Lotto::toString)
                .collect(Collectors.joining("\n"));
    }

    public HashMap<Integer, Integer> checkResult(List<Integer> winningNumber, int bonusNum) {
        HashMap<Integer, Integer> resultMap = new HashMap<>();
        IntStream
                .range(3, 8)
                .forEach(correctNum -> resultMap.put(correctNum, countWinLotto(winningNumber, bonusNum, correctNum)));
        return resultMap;
    }

    private int countWinLotto(List<Integer> winningNumber, int bonusNum, int correctNum) {
        return (int) lottos
                .stream()
                .map(lotto -> lotto.checkNumber(winningNumber, bonusNum)).filter(l -> l.equals(correctNum)).count();
    }

    public double checkWinRate(HashMap<Integer, Integer> checkResult) {
        double buyPrice = 1000 * lottos.size();
        double winPrice = 0;
        winPrice += checkResult.get(3) * 5000;
        winPrice += checkResult.get(4) * 50000;
        winPrice += checkResult.get(5) * 1500000;
        winPrice += checkResult.get(7) * 30000000;
        winPrice += checkResult.get(6) * 2000000000;
        return (winPrice - buyPrice) * 100 / buyPrice;
    }
}
