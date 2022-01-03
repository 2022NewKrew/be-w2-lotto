package domain;

import java.util.ArrayList;
import java.util.HashMap;

public class LottoResult {
    private static final HashMap<Integer, Long> REWARD_OF_MATCHES = new HashMap<>() {{
        put(3, 5000L);
        put(4, 50000L);
        put(5, 1500000L);
        put(6, 2000000000L);
    }};
    private static final String RENDER_FORMAT = "%d개 일치 (%d원)- %d개";
    private final HashMap<Integer, Integer> stats = new HashMap<>();
    private final ArrayList<Lotto> lottoList;
    private final ArrayList<Integer> winningNumber;

    public LottoResult(ArrayList<Lotto> lottoList, ArrayList<Integer> winningNumber) {
        this.lottoList = lottoList;
        this.winningNumber = winningNumber;
        calcResult();
    }

    private void calcResult() {
        for (Lotto lotto : lottoList) {
            int matches = getNumOfMatches(lotto.getNumbers());
            stats.put(matches, getOrDefault(matches) + 1);
        }
    }

    private int getNumOfMatches(ArrayList<Integer> numbers) {
        int matches = 0;
        for (Integer number : numbers) {
            matches += winningNumber.contains(number) ? 1 : 0;
        }
        return matches;
    }

    private int getOrDefault(int key) {
        if (stats.containsKey(key)) {
            return stats.get(key);
        }
        return 0;
    }

    public StringBuilder render() {
        StringBuilder builder = new StringBuilder();
        for (int i = 3; i <= 6; ++i) {
            builder.append(String.format(RENDER_FORMAT, i, REWARD_OF_MATCHES.get(i), getOrDefault(i)));
            builder.append("\n");
        }
        return builder;
    }

    public long getYieldByPercent(int price) {
        return 100 * getRewards() / lottoList.size() / price;
    }

    public long getRewards() {
        long rewards = 0;
        for (int i = 3; i <= 6; ++i) {
            rewards += getOrDefault(i) * REWARD_OF_MATCHES.get(i);
        }
        return rewards;
    }
}
