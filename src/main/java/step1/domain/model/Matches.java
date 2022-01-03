package step1.domain.model;

import step1.utils.Rank;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static step1.utils.CommonConstants.LOTTO_PRICE;

public class Matches {
    private static final int FIRST_RANK_COUNT = 3;
    private static final int LAST_RANK_COUNT = 6;

    private final Map<Integer, Integer> matches;

    public Matches() {
        matches = new HashMap<>();
        initMatches();
    }

    private void initMatches() {
        List<Integer> availCounts = IntStream
                .range(FIRST_RANK_COUNT, LAST_RANK_COUNT + 1)
                .boxed().collect(Collectors.toList());

        for (int number : availCounts) {
            this.matches.put(number, 0);
        }
    }

    public Matches(Map<Integer, Integer> matches) {
        this.matches = matches;
    }

    public void matchLottosWithResult(Lottos lottos, Result result) {
        for (int i = 0, size = lottos.size(); i < size; i++) {
            addInMatches(result.matchWithLotto(lottos.lottoOf(i)));
        }
    }

    private void addInMatches(int count) {
        if (count >= FIRST_RANK_COUNT && count <= LAST_RANK_COUNT) {
            this.matches.put(count, this.matches.get(count) + 1);
        }
    }

    public int calcEarningsRate(Lottos lottos) {
        int usedMoney = lottos.size() * LOTTO_PRICE;
        return (int) Math.round(((double) calcTotalWinningMoney() / usedMoney) * 100);
    }

    private long calcTotalWinningMoney() {
        long totalWinningMoney = 0;

        for (Map.Entry<Integer, Integer> entry : this.matches.entrySet()){
            totalWinningMoney += (long) entry.getValue() *
                    Rank.valueOf(entry.getKey(), false).getWinningMoney();
        }

        return totalWinningMoney;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        for (Map.Entry<Integer, Integer> entry : this.matches.entrySet()){
            sb.append(String.format("%d개 일치 (%d원)- %d개%n",
                    entry.getKey(),
                    Rank.valueOf(entry.getKey(), false).getWinningMoney(),
                    entry.getValue()));
        }

        return sb.toString();
    }
}
