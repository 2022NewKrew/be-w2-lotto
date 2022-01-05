package domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class Results {
    private final List<Result> results;

    public Results(List<Lotto> lottos, List<Integer> winningNumbers, int bonusNum) {
        this.results = generate(lottos,winningNumbers,bonusNum);
    }

    private static List<Result> generate(List<Lotto> lottos, List<Integer> winningNumbers, int bonusNum) {
        List<Result> results = new ArrayList<>();
        List<Rank> resultRanks = lottos.stream()
                .map(lotto -> Rank.of(lotto, new Lotto(winningNumbers), LottoNumber.of(bonusNum)))
                .filter(Objects::nonNull)
                .collect(Collectors.toList());

        for (Rank rank : Rank.values()) {
            int count = (int) resultRanks.stream().filter(rank::equals).count();
            results.add(new Result(rank, count));
        }

        return results;
    }

    public List<Result> getResults() {
        return Collections.unmodifiableList(results);
    }
}
