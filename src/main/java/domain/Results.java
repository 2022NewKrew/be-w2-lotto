package domain;

import java.util.Collections;
import java.util.List;

public class Results {
    private final List<Result> results;

    public Results(List<Lotto> lottos, List<Integer> winningNumbers, int bonusNum) {
        this.results = ResultGenerator.generate(lottos, winningNumbers, bonusNum);
    }

    public List<Result> getResults() {
        return Collections.unmodifiableList(results);
    }
}
