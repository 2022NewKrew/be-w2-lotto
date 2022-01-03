package domain;
import java.util.*;

public class LottoStatics {
    private static final Map<Integer, Integer> winningPrices = Map.of(
            3, 5000,
            4, 50000,
            5, 1500000,
            6, 2000000000
    );
    private final int money;
    private final ArrayList<Lotto> lottos;
    private final ArrayList<Integer> answerLotto;
    private Map<Integer, Integer> results;
    private int yield;

    public LottoStatics(int money, ArrayList<Lotto> lottos, ArrayList<Integer> answerLotto) {
        this.lottos = lottos;
        this.answerLotto = answerLotto;
        this.money = money;
    }

    public void makeStatics() {
        makeResults();
        computeYield();
    }

    public Map<Integer, Integer> getResults() {
        return results;
    }

    public int getYield() { return yield; }

    public Map<Integer, Integer> getWinningPrices() {
        return winningPrices;
    }

    private void makeResults() {
        results = new TreeMap<>();
        for(int key : winningPrices.keySet()) {
            results.put(key, 0);
        }
        lottos.forEach(this::addToResults);
    }

    private void computeYield() {
        double earned = 0;
        for(int key : results.keySet()) {
            earned += results.get(key) * winningPrices.get(key);
        }
        yield = (int)(earned / money * 100);
    }

    private void addToResults(Lotto lotto) {
        int correctNumbers = evaluateLotto(lotto, answerLotto);
        if(winningPrices.containsKey(correctNumbers)) {
            results.put(correctNumbers, results.get(correctNumbers)+1);
        }
    }

    private static int evaluateLotto(Lotto lotto, ArrayList<Integer> answerLotto) {
        int result = 0;
        for(int number : lotto.getNumbers()) {
            result += answerLotto.contains(number) ? 1 : 0;
        }
        return result;
    }


}
