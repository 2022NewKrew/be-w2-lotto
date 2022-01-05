package step3.domain.model;

import step3.utils.Rank;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static step3.utils.CommonConstants.LOTTO_PRICE;

public class Matches {
    private final Map<Rank, Integer> matches;

    public Matches() {
        this.matches = new LinkedHashMap<>();
        initMatches();
    }

    private void initMatches() {
        List<Rank> filteredRanks = Arrays.stream(Rank.values())
                .filter(rank -> rank != Rank.OTHER)
                .collect(Collectors.toList());

        for (Rank rank : filteredRanks) {
            this.matches.put(rank, 0);
        }
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

    public int calcEarningsRate(Lottos lottos) {
        int usedMoney = lottos.size() * LOTTO_PRICE;
        return (int) Math.round(((double) calcTotalWinningMoney() / usedMoney) * 100);
    }

    private long calcTotalWinningMoney() {
        long totalWinningMoney = 0;

        for (Map.Entry<Rank, Integer> entry : this.matches.entrySet()){
            totalWinningMoney += (long) entry.getValue() * entry.getKey().getWinningMoney();
        }

        return totalWinningMoney;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        for (Map.Entry<Rank, Integer> entry : this.matches.entrySet()){
            sb.append(String.format(
                    entry.getKey() != Rank.SECOND ? "%d개 일치 (%d원) - %d개%n" : "%d개 일치, 보너스 볼 일치 (%d원) - %d개%n",
                    entry.getKey().getCountOfMatch(), entry.getKey().getWinningMoney(), entry.getValue()));
        }

        return sb.toString();
    }
}
