package step5.domain.model;

import step5.utils.Rank;

import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

import static step5.utils.CommonConstants.LOTTO_PRICE;

public class Matches implements Iterable<String> {
    private final Map<Rank, Integer> matches;

    public Matches() {
        this.matches = Arrays.stream(Rank.values())
                .filter(rank -> rank != Rank.OTHER)
                .collect(Collectors.toMap(Function.identity(), num -> 0,
                        (val1, val2) -> val2, LinkedHashMap::new));
    }

    public void matchLottosWithResult(Lottos lottos, Result result, BonusNumber bonusNumber) {
        for (int i = 0, size = lottos.size(); i < size; i++) {
            Lotto lotto = lottos.lottoOf(i);
            Rank rank = Rank.valueOf(result.matchWithLotto(lotto),
                    bonusNumber.matchWithLotto(lotto));

            addInMatches(rank);
        }
    }

    private void addInMatches(Rank rank) {
        if (rank != Rank.OTHER) {
            this.matches.put(rank, this.matches.get(rank) + 1);
        }
    }

    public int calcTotalRateOfReturn(Lottos lottos) {
        int usedMoney = lottos.size() * LOTTO_PRICE;
        return (int) Math.round(((double) (calcTotalWinningMoney() - usedMoney) / usedMoney) * 100);
    }

    private long calcTotalWinningMoney() {
        return this.matches.entrySet().stream()
                .reduce(0L,
                        (total, entry) -> total + (long) entry.getValue() * entry.getKey().getWinningMoney(),
                        Long::sum);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        return this.matches.entrySet().stream()
                .reduce(sb,
                        (str, entry) -> sb.append(String.format(entry.getKey() + " - %d개\n", entry.getValue())),
                        StringBuilder::append).toString();
    }

    @Override
    public Iterator<String> iterator() {
        return this.matches.entrySet().stream()
                .map((entry) -> String.format(entry.getKey() + " - %d개\n", entry.getValue())).iterator();
    }
}
