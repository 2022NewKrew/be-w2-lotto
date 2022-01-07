package model;

import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static CONST.Const.*;

public class Lottos {
    private final List<Lotto> lottos;

    public Lottos(Lottos manualLottos, int buyPrice) {
        int numManualLotto = manualLottos.getLottos().size();
        int numAutoLotto = (buyPrice / LOTTO_PRICE) - manualLottos.size();
        this.lottos = manualLottos.getLottos();
        this.lottos.addAll(IntStream
                .range(0, numAutoLotto)
                .mapToObj(i -> new Lotto())
                .collect(Collectors.toList()));

        System.out.println(BUY_COUNT_PREFIX
                + numManualLotto
                + BUY_COUNT_INFIX
                + numAutoLotto
                + BUY_COUNT_POSTFIX);
    }

    public Lottos(List<Lotto> lottos) {
        this.lottos = lottos;
    }

    private int size() {
        return lottos.size();
    }

    public List<Lotto> getLottos() {
        return lottos;
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
                .range(LOTTO_THREE_WIN, LOTTO_FIVE_BONUS_WIN + 1)
                .forEach(correctNum -> resultMap.put(correctNum, countWinLotto(winningNumber, bonusNum, correctNum)));
        return resultMap;
    }

    private int countWinLotto(List<Integer> winningNumber, int bonusNum, int correctNum) {
        return (int) lottos
                .stream()
                .map(lotto -> lotto.checkNumber(winningNumber, bonusNum)).filter(l -> l.equals(correctNum)).count();
    }

    public double checkWinRate(HashMap<Integer, Integer> checkResult) {
        double buyPrice = LOTTO_PRICE * lottos.size();
        double winPrice = 0;
        winPrice += checkResult.get(LOTTO_THREE_WIN) * LOTTO_THREE_WIN_PRICE;
        winPrice += checkResult.get(LOTTO_FOUR_WIN) * LOTTO_FOUR_WIN_PRICE;
        winPrice += checkResult.get(LOTTO_FIVE_WIN) * LOTTO_FIVE_WIN_PRICE;
        winPrice += checkResult.get(LOTTO_FIVE_BONUS_WIN) * LOTTO_FIVE_BONUS_WIN_PRICE;
        winPrice += checkResult.get(LOTTO_SIX_WIN) * LOTTO_SIX_WIN_PRICE;
        return (winPrice - buyPrice) * 100 / buyPrice;
    }
}
